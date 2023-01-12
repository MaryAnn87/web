package com.portfolio.web.Service;

import com.portfolio.web.Entity.Experiencia;
import com.portfolio.web.Repository.RepExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvcExperiencia {
    @Autowired
    RepExperiencia repExperiencia;
    
    public List<Experiencia> list(){
        return repExperiencia.findAll();
        
    }
     public Optional <Experiencia> getOne (int id){
         return repExperiencia.findById(id);
     }
    
     public Optional <Experiencia> getByNombreE (String nombreE){
         return repExperiencia.findByNombreE(nombreE);
     }
     
     public void save(Experiencia exp){
         repExperiencia.save (exp);
     }
     
     public void delete(int id){
         repExperiencia.deleteById(id);
     }
     
     //metodo que busca si existe la experiencia por id o nombre
     public boolean existsById(int id){
         return repExperiencia.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return repExperiencia.existsByNombreE(nombreE);
     }
}
