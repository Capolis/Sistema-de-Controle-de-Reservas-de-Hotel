package br.com.caio.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String guestName;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private int numberOfDays;

    @Column(nullable = false)
    private double dailyRate;

    // Construtor padrão exigido pela JPA
    public Reservation() {
    }

    // Construtor completo para uso interno/testes
    public Reservation(Long id, String guestName, String roomType, int numberOfDays, double dailyRate) {
        this.id = id;
        this.guestName = guestName;
        this.roomType = roomType;
        this.numberOfDays = numberOfDays;
        this.dailyRate = dailyRate;
    }

    // Regra de negócio: calcula o valor total da hospedagem
    public double getTotalPrice() {
        return this.numberOfDays * this.dailyRate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", numberOfDays=" + numberOfDays +
                ", dailyRate=" + dailyRate +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public int getNumberOfDays() { return numberOfDays; }
    public void setNumberOfDays(int numberOfDays) { this.numberOfDays = numberOfDays; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

}