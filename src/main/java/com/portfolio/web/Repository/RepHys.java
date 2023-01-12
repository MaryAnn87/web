package com.portfolio.web.Repository;

import com.portfolio.web.Entity.Hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepHys extends JpaRepository<Hys,Integer>{
    public Optional<Hys> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
