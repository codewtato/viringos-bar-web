### **Segunda Entrega 27 de Septiembre**

### **Definición del Proyecto y Problema de Negocio**

### **Nombre del Proyecto:** 

Sistema Web de Automatización de Reservas y Gestión de Señas para Viringo’s Bar.

### **Contexto y Cliente:**

El proyecto está pensado para Viringo’s Bar, un establecimiento gastronómico que actualmente enfrenta serios cuellos de botella operativos en su atención al cliente y en la gestión de su salón debido a la falta de un canal digital automatizado.

### **Problema a resolver:**

Actualmente, todo su sistema de reservas se maneja de forma manual a través de canales informales como WhatsApp, Instagram, Facebook. De acuerdo con las observaciones de la administración del local, esta modalidad presenta dos dificultades principales:<br>
* Sobrecarga administrativa en la gestión: El personal debe destinar parte de su jornada laboral a responder consultas repetitivas, coordinar disponibilidad por chat y registrar cada reserva manualmente, lo que resta tiempo de dedicación para la atención presencial y otras tareas operativas del salón.<br>
* Reservas no concretadas (ausentismo): Al no existir un compromiso previo o seña al momento de reservar, los encargados señalan que es frecuente que algunos clientes reserven y finalmente no se presenten ni den aviso. Esto ocasiona que haya capacidad retenida hasta determinado horario que no puede ser asignada a otros clientes que acuden al local, afectando el aprovechamiento del salón y la facturación de la jornada.

### **Solución Propuesta:**

 Se desarrollará una aplicación web ágil donde los clientes puedan autogestionar la reserva de sus mesas de manera autónoma. La plataforma incorporará el registro de una seña previa como condición para confirmar la reserva. Con esta implementación se busca establecer un mayor compromiso por parte del cliente para reducir el ausentismo en las fechas reservadas y disminuir la carga administrativa del personal asociada a la gestión manual por redes sociales.

### **Casos de Uso y Escenario del Sitema**

CASO A: 
* **Descripción del flujo:** El cliente selecciona una fecha, horario, cantidad de personas en la interfaz y solicitar la reserva. El sistema va a validar disponibilidad, creará un registro de reserva en estado `solicitada` y genera la orden de pago por la seña. Al pagar la seña en el plazo, el pago se aprueba, la reserva pasa a estado `confirmada` y se congela al cupo. El cliente asiste al local y el personal registra la asistencia.
* ** Registros creados:** `Cliente`, `Reserva` y `Pago`.
* **Estados:** Acá se trabaja sobre el estado tanto de `Reserva` como del `Pago`
    * Reserva: `solicitada` -> `confirmada` -> `asistida`.
    * Pago: `pendiente` -> `aprobado`.

CASO B:
* **Descripción del flujo:** Dos clientes intentan reservar en el mismo horario y la segunda operación supera la capacidad disponible. El sistema procesa lr primera, valida que hay capacidad y asigna el cupo. Cuando ingresa la segunda solicitud, la validación va a detectar que el cupo ya fue entregado y rechazará la operación, informando al usuario que no hay disponibilidad para ese horario.
* **Registros creados:** Se crea el registro de la reserva y pago solo para la primera solicitud. Para el segundo caso solo se genera un registro de rechazo.
* **Estados:**
    * Primer usuario: Reserva `pendiente` -> `confirmada`.
    * Segundo usuario: Se rechaza la solicitud de forma inmediata. 

CASO C:
* **Descripción del flujo:** El cliente inicia la reserva y el sistema la genera junto a la orden de pago. Luego el cliente abandona la pasarela de pago antes de finalizarlo o la transferencia es rechazada. Al cumplirse el tiempo límite (15 minutos) el sistema libera automáticamente la mesa retenida y cancela el proceso.
* **Registros creados:** Se crea un registro para la `Reserva` y `Pago` en estado `pendiente`.
* **Estados:** 
    * Reserva: `pendiente` durante 15 minutos -> `cancelada` ya sea por falta de pago o rechazo.
    * Pago: `pendiente` -> `rechazado`.

CASO D:

* **Descripción del flujo:** El cliente completa el proceso de reserva y pasa a estado `confirmada`. Sin embargo, en el día y horario pactado, el cliente no se presenta. El administrador del sistema registra la ausencia.
* **Registros creados:** Los registros para la reserva confirmada persisten en la base de datos.
* **Estados:** 
    * Reserva: `confirmada` -> `no_asistio`.
    * Pago: Se mantiene en estado `aprobado`.

