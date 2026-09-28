package com.viringos.backend.services.pago;

import com.viringos.backend.dtos.pago.PagoCreate;
import com.viringos.backend.dtos.pago.PagoDto;
import com.viringos.backend.entities.enums.EstadoPago;
import com.viringos.backend.entities.enums.EstadoReserva;
import com.viringos.backend.entities.Pago;
import com.viringos.backend.entities.Reserva;
import com.viringos.backend.repositories.PagoRepository;
import com.viringos.backend.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PagoServiceImp implements PagoService {

    private final PagoRepository pagoRepository;
    private final ReservaRepository reservaRepository;

    @Override
    @Transactional // si falla algo, no se guarde el pago ni cambie el estado
    public PagoDto procesarPago(PagoCreate dto) {
        
        // buscar la reserva a la que se le va a pagar la seña
        Reserva reserva = reservaRepository.findById(dto.reservaId())
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        // validar que la reserva esté en estado SOLICITADA
        if (reserva.getEstado() != EstadoReserva.SOLICITADA) {
            throw new RuntimeException("Solo se pueden pagar señas de reservas SOLICITADAS");
        }

        // crear el pago
        Pago nuevoPago = new Pago();
        nuevoPago.setMonto(dto.monto());
        nuevoPago.setMetodoPago(dto.metodoPago());
        nuevoPago.setEstadoPago(EstadoPago.APROBADO); 
        nuevoPago.setReserva(reserva);

        Pago pagoGuardado = pagoRepository.save(nuevoPago);

        // cambiar el estado de la reserva a CONFIRMADA
        reserva.setEstado(EstadoReserva.CONFIRMADA);
        reservaRepository.save(reserva);

        // devolver el DTO del pago
        return new PagoDto(
                pagoGuardado.getId(),
                pagoGuardado.getMonto(),
                pagoGuardado.getMetodoPago(),
                pagoGuardado.getEstadoPago().name(),
                pagoGuardado.getReserva().getId()
        );
    }
}