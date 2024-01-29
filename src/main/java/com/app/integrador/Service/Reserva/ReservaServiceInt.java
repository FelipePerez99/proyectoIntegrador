package com.app.integrador.Service.Reserva;

import com.app.integrador.Entity.Reserva;

import java.util.List;

public interface ReservaServiceInt {

    Reserva saveReservation(Reserva reserva);
    List<Reserva> findReservationByUser(Integer userId);
    Reserva updateReservation(Reserva reserva);
    void cancelReservation(Integer reservationId);
}
