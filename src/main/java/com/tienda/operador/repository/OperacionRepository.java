package com.tienda.operador.repository;

import com.tienda.operador.model.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacionRepository extends JpaRepository<Operacion, Long> {
    List<Operacion> findByUsuarioId(Long usuarioId);
}
