package com.viringos.backend.services.reserva;

import com.viringos.backend.dtos.reserva.ReservaCreate;
import com.viringos.backend.dtos.reserva.ReservaDto;
import com.viringos.backend.entities.enums.EstadoReserva;
import com.viringos.backend.entities.Mesa;
import com.viringos.backend.entities.Reserva;
import com.viringos.backend.repositories.MesaRepository;
import com.viringos.backend.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImp implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final MesaRepository mesaRepository;

    @Override
    public ReservaDto procesarSolicitud(ReservaCreate dto) {
        // traer mesas y calcular capacidad total
        List<Mesa> todasLasMesas = mesaRepository.findAll();
        
        // traer reservas existentes para esa fecha y hora
        List<Reserva> reservasOcupadas = reservaRepository.findByFechaAndFranjaHoraria(dto.fecha(), dto.franjaHoraria());

        // calcular capacidad ocupada
        int capacidadOcupada = reservasOcupadas.stream()
                .mapToInt(Reserva::getCantidadPersonas)
                .sum();

        int capacidadTotal = todasLasMesas.stream()
                .mapToInt(Mesa::getCapacidad)
                .sum();

        // validar si hay lugar en el bar
        int lugaresLibres = capacidadTotal - capacidadOcupada;
        if (lugaresLibres < dto.cantidadPersonas()) {
            throw new RuntimeException("No hay capacidad suficiente en el bar para esa fecha y hora.");
        }

        // filtrar mesas ocupadas
        List<Long> idsMesasOcupadas = reservasOcupadas.stream()
                .map(reserva -> reserva.getMesa().getId())
                .toList();

        // asignar una mesa libre que tenga la capacidad necesaria
        Mesa mesaAsignada = todasLasMesas.stream()
                .filter(mesa -> !idsMesasOcupadas.contains(mesa.getId()))
                .filter(mesa -> mesa.getCapacidad() >= dto.cantidadPersonas())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Hay lugares, pero no hay una mesa individual para " + dto.cantidadPersonas() + " personas."));

        // crear y guardar la reserva
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setFecha(dto.fecha());
        nuevaReserva.setFranjaHoraria(dto.franjaHoraria());
        nuevaReserva.setCantidadPersonas(dto.cantidadPersonas());
        nuevaReserva.setEstado(EstadoReserva.SOLICITADA);
        nuevaReserva.setMesa(mesaAsignada);
        nuevaReserva.setNombre(dto.nombre());

        Reserva reservaGuardada = reservaRepository.save(nuevaReserva);

        return new ReservaDto(
                reservaGuardada.getId(),
                reservaGuardada.getNombre(),
                reservaGuardada.getFecha(),
                reservaGuardada.getFranjaHoraria(),
                reservaGuardada.getCantidadPersonas(),
                reservaGuardada.getEstado().name(),
                reservaGuardada.getMesa().getId()
        );
    }
}