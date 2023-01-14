package com.portfolio.web.Controller;

import com.portfolio.web.Dto.DtoProyecto;
import com.portfolio.web.Entity.Proyecto;
import com.portfolio.web.Security.Controller.Mensaje;
import com.portfolio.web.Service.SvcProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://yoprogramo-portfolioweb.web.app")
public class CtrProyecto {

    @Autowired
    SvcProyecto svcProyecto;

    //Trae lista de proyecto
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = svcProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!svcProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = svcProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!svcProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje(" Id de proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        svcProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    //crear una proyecto
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto) {
        if (StringUtils.isBlank(dtoProyecto.getNombrePr())) {
            return new ResponseEntity(new Mensaje("el nombre de proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (svcProyecto.existsByNombrePr(dtoProyecto.getNombrePr())) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoProyecto.getNombrePr(), dtoProyecto.getDescripcionPr(), dtoProyecto.getLinkPr());
        svcProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado exitosamente"), HttpStatus.OK);
    }

    //update una proyecto
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto) {
        //validacion si existe el id
        if (!svcProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Compara nombre de cada proyecto
        if (svcProyecto.existsByNombrePr(dtoProyecto.getNombrePr()) && svcProyecto.getByNombrePr(dtoProyecto.getNombrePr()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        //valida que el campo no este vacio
        if (StringUtils.isBlank(dtoProyecto.getNombrePr())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoProyecto.getDescripcionPr())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getLinkPr())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //si pasa todas las validaciones entonces:
        Proyecto proyecto = svcProyecto.getOne(id).get();
        proyecto.setNombrePr(dtoProyecto.getNombrePr());
        proyecto.setDescripcionPr((dtoProyecto.getDescripcionPr()));
        proyecto.setLinkPr((dtoProyecto.getLinkPr()));

        svcProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto se ha actualizado correctamente"), HttpStatus.OK);

    }

}
