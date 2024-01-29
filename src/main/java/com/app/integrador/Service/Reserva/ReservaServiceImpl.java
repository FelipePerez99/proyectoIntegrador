package com.app.integrador.Service.Reserva;

import com.app.integrador.Entity.Reserva;
import com.app.integrador.Entity.Usuario;
import com.app.integrador.Entity.Vuelo;
import com.app.integrador.Exception.ReservaNotFoundException;
import com.app.integrador.Exception.UsuarioNotFoundException;
import com.app.integrador.Exception.VueloNotFoundException;
import com.app.integrador.Repository.ReservaRepository;
import com.app.integrador.Repository.UsuarioRepository;
import com.app.integrador.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaServiceInt{

    private final ReservaRepository reservaRepository;

    private final UsuarioRepository usuarioRepository;

    private final VueloRepository vueloRepository;


    public ReservaServiceImpl(@Autowired ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.vueloRepository = vueloRepository;
    }
    @Override
    public Reserva saveReservation(Reserva reserva) {
        Integer userById = reserva.getUsuario().getId();
        Integer flightById = reserva.getVuelo().getId();

        Usuario usuario = usuarioRepository.findById(userById).orElseThrow(() -> new UsuarioNotFoundException());
        Vuelo vuelo = vueloRepository.findById(flightById).orElseThrow(() -> new VueloNotFoundException());

        reserva.setUsuario(usuario);
        reserva.setVuelo(vuelo);
        reserva.setFechaDeReserva(new Date());

        if (reserva != null){
            return reservaRepository.save(reserva);
        }else{
            throw new ReservaNotFoundException();
        }
    }

    @Override
    public List<Reserva> findReservationByUser(Integer userId) {
        Optional<Usuario>  user = usuarioRepository.findById(userId);

        Usuario usuario = user.orElseThrow(UsuarioNotFoundException::new);

        return reservaRepository.findByUsuarioId(usuario.getId());
    }

    @Override
    public Reserva updateReservation(Reserva reserva) {
        return null;
    }

    @Override
    public void cancelReservation(Integer reservationId) {
        Optional<Reserva> reservation = reservaRepository.findById(reservationId);
        if (reservation.isPresent()){
            reservaRepository.deleteById(reservationId);
        }else{
            throw new ReservaNotFoundException();
        }
    }
}
