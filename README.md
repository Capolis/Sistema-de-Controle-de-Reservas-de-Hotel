# Projeto: Sistema de Controle de Reservas de Hotel

## About the Project:

###### Criar um programa em Java para cadastrar reservas, listar hóspedes, buscar por nome e ordenar hóspedes pelo número de dias hospedados.


## Tech Stack: 

###### Spring Initializr (Java 21 ou superior, Maven, dependências: Spring Web, Spring Data JPA, H2 Database, Validation)


# How to Run:

###### br.com.caio.hotel
###### ├── controller
###### │   └── ReservationController.java
###### ├── exception
###### │   └── GlobalExceptionHandler.java
###### ├── dto
###### │   ├── ReservationRequestDTO.java
###### │   └── ReservationResponseDTO.java
###### ├── entity
###### │   └── Reservation.java
###### ├── repository
###### │   └── ReservationRepository.java
###### └── service
###### │   └── ReservationService.java