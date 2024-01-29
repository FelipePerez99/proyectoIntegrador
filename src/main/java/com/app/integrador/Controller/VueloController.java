package com.app.integrador.Controller;

import com.app.integrador.Entity.Vuelo;
import com.app.integrador.Service.Vuelo.VueloServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vuelo")
public class VueloController {

    private final VueloServiceInt vueloServiceInt;

    public VueloController(@Autowired VueloServiceInt vueloServiceInt) {
        this.vueloServiceInt = vueloServiceInt;
    }

    @PostMapping
    public ResponseEntity<Vuelo> addFlight(@RequestBody Vuelo vuelo){
        return new ResponseEntity<>(vueloServiceInt.saveflight(vuelo), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findFlightById(@PathVariable Integer id){
        Optional<Vuelo> flight = vueloServiceInt.findById(id);
        return new ResponseEntity<>(flight, HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Vuelo> updateFlight(@PathVariable Integer id, @RequestBody Vuelo vuelo) {
        Vuelo updatedFlight = vueloServiceInt.updateFlight(vuelo);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> allFlight(){
        List<Vuelo> flights = vueloServiceInt.all();
        return new ResponseEntity<>(flights,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id){
        vueloServiceInt.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
