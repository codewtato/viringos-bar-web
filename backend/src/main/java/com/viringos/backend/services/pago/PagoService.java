package com.viringos.backend.services.pago;

import com.viringos.backend.dtos.pago.PagoCreate;
import com.viringos.backend.dtos.pago.PagoDto;

public interface PagoService {
    PagoDto registrarSenia(PagoCreate dto);
}