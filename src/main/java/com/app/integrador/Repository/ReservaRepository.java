package com.app.integrador.Repository;

import com.app.integrador.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByUsuarioId(Integer userId);
}
