package com.app.integrador.Service.Vuelo;

import com.app.integrador.Entity.Vuelo;

import java.util.List;
import java.util.Optional;

public interface VueloServiceInt {
    Vuelo saveflight(Vuelo vuelo);
    Optional<Vuelo> findById(Integer id);
    Vuelo updateFlight(Vuelo vuelo);
    List<Vuelo> all();
    void deleteById(Integer id);
}
