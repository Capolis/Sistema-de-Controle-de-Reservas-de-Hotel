package br.com.caio.hotel.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ReservationRequestDTO {

    @NotBlank(message = "O nome do hóspede é obrigatório.")
    private String guestName;

    @NotBlank(message = "O tipo do quarto é obrigatório.")
    private String roomType;

    @Min(value = 1, message = "O número de dias não pode ser menor que 1.")
    private int numberOfDays;

    @DecimalMin(value = "0.01", message = "O valor da diária deve ser maior que zero.")
    private double dailyRate;

    // Getters e Setters
    public String getGuestName() { return guestName; }
    public void setGuestName(String guestName) { this.guestName = guestName; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public int getNumberOfDays() { return numberOfDays; }
    public void setNumberOfDays(int numberOfDays) { this.numberOfDays = numberOfDays; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
}