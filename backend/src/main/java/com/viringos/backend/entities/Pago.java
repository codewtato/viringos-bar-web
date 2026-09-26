package com.viringos.backend.entities;

import com.viringos.backend.entities.enums.EstadoPago;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
}