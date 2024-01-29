package com.app.integrador.Service.Vuelo;

import com.app.integrador.Entity.Vuelo;
import com.app.integrador.Exception.VueloNotFoundException;
import com.app.integrador.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloServiceImpl implements VueloServiceInt{
    private final VueloRepository vueloRepository;

    public VueloServiceImpl(@Autowired VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public Vuelo saveflight(Vuelo vuelo) {
        Vuelo newflight = vueloRepository.save(vuelo);
        if (newflight != null){
            return newflight;
        }else{
            throw new VueloNotFoundException();
        }
    }

    @Override
    public Optional<Vuelo> findById(Integer id) {
        Optional<Vuelo> flight = vueloRepository.findById(id);
        if (flight != null){
            return flight;
        }else{
            throw new VueloNotFoundException();
        }
    }

    @Override
    public Vuelo updateFlight(Vuelo vuelo) {
        Integer flightId = vuelo.getId();
        Vuelo existingFlight = vueloRepository.findById(flightId)
                .orElseThrow(VueloNotFoundException::new);

        existingFlight.setAerolinea(vuelo.getAerolinea());
        existingFlight.setOrigen(vuelo.getOrigen());
        existingFlight.setDestino(vuelo.getDestino());
        existingFlight.setHorario(vuelo.getHorario());
        return vueloRepository.save(existingFlight);
    }
    @Override
    public List<Vuelo> all() {
        List<Vuelo> flights = vueloRepository.findAll();
        if (flights.isEmpty()){
            throw new VueloNotFoundException();
        }
        return flights;
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Vuelo> user = vueloRepository.findById(id);
        if (user.isPresent()){
            vueloRepository.deleteById(id);
        }else{
            throw new VueloNotFoundException();
        }
    }

}
