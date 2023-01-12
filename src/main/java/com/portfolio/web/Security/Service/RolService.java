package com.portfolio.web.Security.Service;

import com.portfolio.web.Security.Entity.Rol;
import com.portfolio.web.Security.Enums.RolNombre;
import com.portfolio.web.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }

    //crear metodo para guardar cambios
    public void save(Rol rol) {
        irolRepository.save(rol);
    }

}

