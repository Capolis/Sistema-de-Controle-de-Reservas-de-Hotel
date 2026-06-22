package br.com.caio.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.caio.hotel.dto.ReservationRequestDTO;
import br.com.caio.hotel.entity.Reservation;
import br.com.caio.hotel.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    // Injeção de dependência recomendada via construtor
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Reservation createReservation(ReservationRequestDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setGuestName(dto.getGuestName());
        reservation.setRoomType(dto.getRoomType());
        reservation.setNumberOfDays(dto.getNumberOfDays());
        reservation.setDailyRate(dto.getDailyRate());
        
        return repository.save(reservation);
    }

    @Transactional(readOnly = true)
    public List<Reservation> listAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Reservation> searchByGuestName(String name) {
        return repository.findByGuestNameContainingIgnoreCase(name);
    }

    @Transactional(readOnly = true)
    public List<Reservation> listAllSortedByDaysDesc() {
        return repository.findAllByOrderByNumberOfDaysDesc();
    }
}