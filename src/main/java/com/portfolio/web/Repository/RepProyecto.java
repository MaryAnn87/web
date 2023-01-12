package com.portfolio.web.Repository;

import com.portfolio.web.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepProyecto  extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombrePr(String nombrePr);
    public boolean existsByNombrePr(String nombrePr);
    
}
