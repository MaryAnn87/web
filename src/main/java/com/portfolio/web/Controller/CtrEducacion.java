package com.portfolio.web.Controller;

import com.portfolio.web.Dto.DtoEducacion;
import com.portfolio.web.Entity.Educacion;
import com.portfolio.web.Security.Controller.Mensaje;
import com.portfolio.web.Service.SvcEducacion;
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
@RequestMapping("/edu")
@CrossOrigin(origins = "https://yoprogramo-portfolioweb.web.app")

public class CtrEducacion {

    @Autowired
    SvcEducacion svcEducacion;

    //Trae lista de educacion
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = svcEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!svcEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = svcEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!svcEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje(" Id de educacion no existe"), HttpStatus.NOT_FOUND);
        }
        svcEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    //crear una educacion
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getNombreInstitucion())) {
            return new ResponseEntity(new Mensaje("el nombre de educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (svcEducacion.existsByNombreInstitucion(dtoedu.getNombreInstitucion())) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getNombreInstitucion(), dtoedu.getTituloEd(), dtoedu.getPeriodo(), dtoedu.getDescripcionEd());
        svcEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada exitosamente"), HttpStatus.OK);
    }

    //update una educacion
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoedu) {
        //validacion si existe el id
        if (!svcEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Compara nombre de cada educacion
        if (svcEducacion.existsByNombreInstitucion(dtoedu.getNombreInstitucion()) && svcEducacion.getByNombreInsitucion(dtoedu.getNombreInstitucion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }

        //valida que el campo no este vacio
        if (StringUtils.isBlank(dtoedu.getNombreInstitucion())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoedu.getTituloEd())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoedu.getPeriodo())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoedu.getDescripcionEd())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //si pasa todas las validaciones entonces:
        Educacion educacion = svcEducacion.getOne(id).get();
        educacion.setNombreInstitucion(dtoedu.getNombreInstitucion());
        educacion.setTituloEd(dtoedu.getTituloEd());
        educacion.setPeriodo(dtoedu.getPeriodo());
        educacion.setDescripcionEd((dtoedu.getDescripcionEd()));

        svcEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion se ha actualizado correctamente"), HttpStatus.OK);

    }

}
