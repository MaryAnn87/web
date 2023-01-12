package com.portfolio.web.Controller;

import com.portfolio.web.Dto.DtoHys;
import com.portfolio.web.Entity.Hys;
import com.portfolio.web.Security.Controller.Mensaje;
import com.portfolio.web.Service.SvcHys;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class CtrHys {

    @Autowired
    SvcHys svcHys;

    //Trae lista de skills
    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list() {
        List<Hys> list = svcHys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id) {
        if (!svcHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        Hys hys = svcHys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!svcHys.existsById(id)) {
            return new ResponseEntity(new Mensaje(" Id de experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        svcHys.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }

    //crear una skill
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHys dtoHys) {
        if (StringUtils.isBlank(dtoHys.getNombre())) {
            return new ResponseEntity(new Mensaje("el nombre de skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (svcHys.existsByNombre(dtoHys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Hys hys = new Hys(dtoHys.getNombre(), dtoHys.getPorcentaje());
        svcHys.save(hys);
        return new ResponseEntity(new Mensaje("Skill agregada exitosamente"), HttpStatus.OK);
    }

    //update una skill
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHys dtoHys) {
        //validacion si existe el id
        if (!svcHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Compara nombre de cada skill
        if (svcHys.existsByNombre(dtoHys.getNombre()) && svcHys.getByNombre(dtoHys.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        //valida que el campo no este vacio
        if (StringUtils.isBlank(dtoHys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //falta validacion de variable porcentaje
        //si pasa todas las validaciones entonces:
        Hys hys = svcHys.getOne(id).get();
        hys.setNombre(dtoHys.getNombre());
        hys.setPorcentaje(dtoHys.getPorcentaje());

        svcHys.save(hys);
        return new ResponseEntity(new Mensaje("Skill se ha actualizado correctamente"), HttpStatus.OK);

    }

}
