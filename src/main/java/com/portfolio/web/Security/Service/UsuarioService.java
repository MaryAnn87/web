package com.portfolio.web.Security.Service;

import com.portfolio.web.Security.Entity.Usuario;
import com.portfolio.web.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    //chequea si el nombre de user existe
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    //chequea si el email existe
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }

    //guarda un nuevo usuario
    public void save( Usuario usuario) {
        iusuarioRepository.save(usuario);
    }

}
