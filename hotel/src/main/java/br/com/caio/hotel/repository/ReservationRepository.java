package br.com.caio.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caio.hotel.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Busca por parte do nome do hóspede ignorando maiúsculas/minúsculas (Busca do Menu original)
    List<Reservation> findByGuestNameContainingIgnoreCase(String guestName);

    // Lista todas as reservas ordenando por número de dias decrescente (Ordenação do Menu original)
    List<Reservation> findAllByOrderByNumberOfDaysDesc();
}