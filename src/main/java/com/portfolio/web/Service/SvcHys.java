package com.portfolio.web.Service;

import com.portfolio.web.Entity.Hys;
import com.portfolio.web.Repository.RepHys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SvcHys {

    @Autowired
    RepHys repHys;

    public List<Hys> list() {
        return repHys.findAll();
    }

    public Optional<Hys> getOne(int id) {
        return repHys.findById(id);
    }

    public Optional<Hys> getByNombre(String nombre) {
        return repHys.findByNombre(nombre);
    }

    public void save(Hys skill) {
        repHys.save(skill);
    }

    public void delete(int id) {
        repHys.deleteById(id);
    }

    public boolean existsById(int id) {
        return repHys.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return repHys.existsByNombre(nombre);

    }
}
