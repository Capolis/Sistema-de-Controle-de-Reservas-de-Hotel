package br.com.caio.hotel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.caio.hotel.dto.ReservationRequestDTO;
import br.com.caio.hotel.entity.Reservation;
import br.com.caio.hotel.service.ReservationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    // Rota para: Nova reserva
    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody ReservationRequestDTO dto) {
        Reservation created = service.createReservation(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // Rota para: Listar reservas
    @GetMapping
    public ResponseEntity<List<Reservation>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    // Rota para: Buscar reserva por nome do hóspede
    @GetMapping("/search")
    public ResponseEntity<List<Reservation>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchByGuestName(name));
    }

    // Rota para: Ordenar reservas por número de dias (decrescente)
    @GetMapping("/sorted")
    public ResponseEntity<List<Reservation>> listSorted() {
        return ResponseEntity.ok(service.listAllSortedByDaysDesc());
    }
}