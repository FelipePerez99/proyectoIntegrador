package com.app.integrador.Controller;

import com.app.integrador.Entity.Reserva;
import com.app.integrador.Service.Reserva.ReservaServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {
    private final ReservaServiceInt reservaServiceInt;

    public ReservaController(@Autowired ReservaServiceInt reservaServiceInt) {
        this.reservaServiceInt = reservaServiceInt;
    }

    @PostMapping
    public ResponseEntity<Reserva> registerReservation(@RequestBody Reserva reserva) {
        return new ResponseEntity<>(reservaServiceInt.saveReservation(reserva), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Reserva> updateReservation(@RequestBody Reserva reserva) {
        Reserva updatedReservation = reservaServiceInt.updateReservation(reserva);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> allReservations(@PathVariable Integer userId){
        List<Reserva> reservas = reservaServiceInt.findReservationByUser(userId);
        return ResponseEntity.ok(reservas);

    }

    @DeleteMapping("/{idReservation}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Integer idReservation){
        reservaServiceInt.cancelReservation(idReservation);
        return ResponseEntity.noContent().build();
    }
}
