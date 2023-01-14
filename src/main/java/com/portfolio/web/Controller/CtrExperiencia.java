package com.portfolio.web.Controller;

import org.apache.commons.lang3.StringUtils;
import com.portfolio.web.Dto.DtoExperiencia;
import com.portfolio.web.Entity.Experiencia;
import com.portfolio.web.Security.Controller.Mensaje;
import com.portfolio.web.Service.SvcExperiencia;
import java.util.List;
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
@RequestMapping("/explabo")
@CrossOrigin (origins = "https://yoprogramo-portfolioweb.web.app")
public class CtrExperiencia {
    @Autowired
    SvcExperiencia svcExperiencia;
    
    //Trae lista de experiencia
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list (){
        List<Experiencia> list = svcExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!svcExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = svcExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
      @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!svcExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje(" Id de experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        svcExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    //crear una experiencia
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp){
       if(StringUtils.isBlank(dtoexp.getNombreE()))
           return new ResponseEntity(new Mensaje("el nombre de experiencia es obligatorio"),HttpStatus.BAD_REQUEST);
       /*if(svcExperiencia.existsByNombreE(dtoexp.getNombreE()))
           return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);*/
       
       Experiencia experiencia = new Experiencia (dtoexp.getNombreE(),dtoexp.getTituloPuesto(),dtoexp.getPeriodo(), dtoexp.getDescripcionE());
       svcExperiencia.save(experiencia);
       return new ResponseEntity(new Mensaje("Experiencia agregada exitosamente"), HttpStatus.OK);
    }
    
    
    //update una experiencia
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp){
        //validacion si existe el id
      if(!svcExperiencia.existsById(id))
          return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
      
        //Compara nombre de cada experiencia
      /*if(svcExperiencia.existsByNombreE(dtoexp.getNombreE())&& svcExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
          return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);*/
      
       //valida que el campo no este vacio
      if(StringUtils.isBlank(dtoexp.getNombreE()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      if(StringUtils.isBlank(dtoexp.getTituloPuesto()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      if(StringUtils.isBlank(dtoexp.getPeriodo()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      if(StringUtils.isBlank(dtoexp.getDescripcionE()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
      
      //si pasa todas las validaciones entonces:
      Experiencia experiencia =  svcExperiencia.getOne(id).get();
      experiencia.setNombreE(dtoexp.getNombreE());
      experiencia.setTituloPuesto(dtoexp.getTituloPuesto());
      experiencia.setPeriodo(dtoexp.getPeriodo());
      experiencia.setDescripcionE((dtoexp.getDescripcionE()));
      
      svcExperiencia.save(experiencia);
      return new ResponseEntity(new Mensaje("Experiencia se ha actualizado correctamente"), HttpStatus.OK);
      
    }  
            
    
}
