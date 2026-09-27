package com.viringos.backend.services.reserva;

import com.viringos.backend.dtos.cliente.ClienteDto;
import com.viringos.backend.dtos.reserva.ReservaCreate;
import com.viringos.backend.dtos.reserva.ReservaDto;
import com.viringos.backend.entities.Cliente;
import com.viringos.backend.entities.enums.EstadoReserva;
import com.viringos.backend.entities.Mesa;
import com.viringos.backend.entities.Reserva;
import com.viringos.backend.repositories.ClienteRepository;
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
    private final ClienteRepository clienteRepository;

    @Override
    public ReservaDto procesarSolicitud(ReservaCreate dto) {
        
        // validar cliente
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

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
        nuevaReserva.setCliente(cliente);
        nuevaReserva.setMesa(mesaAsignada);

        Reserva reservaGuardada = reservaRepository.save(nuevaReserva);

        // devolver el DTO
        ClienteDto clienteDto = new ClienteDto(
                cliente.getId(), 
                cliente.getNombre(), 
                cliente.getApellido(), 
                cliente.getTelefono(), 
                cliente.getEmail()
        );

        return new ReservaDto(
                reservaGuardada.getId(),
                reservaGuardada.getFecha(),
                reservaGuardada.getFranjaHoraria(),
                reservaGuardada.getCantidadPersonas(),
                reservaGuardada.getEstado().name(),
                clienteDto,
                reservaGuardada.getMesa().getId()
        );
    }
}