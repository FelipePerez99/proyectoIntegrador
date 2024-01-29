package com.app.integrador.Repository;

import com.app.integrador.Entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}
