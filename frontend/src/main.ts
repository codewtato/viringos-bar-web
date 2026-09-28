const form = document.querySelector("#reserve-form") as HTMLFormElement;
const contForm = document.querySelector(".form-container")as HTMLDivElement;
const pagoBtn = document.querySelector(".pago-btn") as HTMLButtonElement;
const contPago = document.querySelector(".pago-container") as HTMLDivElement;
let reservaId: number | undefined;

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const nombreInput = (document.querySelector("#input-name") as HTMLInputElement).value;
    const fechaInput = (document.querySelector("#input-date") as HTMLInputElement).value;
    const horaInput = (document.querySelector("#input-time") as HTMLInputElement).value;
    const personasInput = (document.querySelector("#input-size") as HTMLInputElement).value;
    
    const nuevaReserva = {
        nombre: nombreInput,
        fecha: fechaInput,
        franjaHoraria: horaInput,
        cantidadPersonas: personasInput
    }

    try{
        const response = await fetch("http://localhost:8080/api/reservas",{
            method: "POST",
            headers:{
                "Content-type": "application/json"
            },
            body: JSON.stringify(nuevaReserva)
        });

        if(response.ok){
            contForm.classList.add("oculto");
            contPago.classList.remove("oculto");
            form.reset();
        }
        if(!response.ok) {
            const error = await response.text();
            throw new Error(error || "Error al procesar la reserva.");
        }

        const dataReserva = await response.json();
        reservaId = dataReserva.id;
        console.log("Reserva creada con éxito: ", dataReserva);
    } catch(error) {
        console.log("Ocurrió un error: ", error)
    }
});

pagoBtn.addEventListener("click", async (e) => {

    const nuevoPago = {
        monto: 20.0,
        metodoPago: "Tarjeta",
        reservaId: reservaId
    }

    try{
        const response = await fetch("http://localhost:8080/api/pagos",{
            method: "POST",
            headers:{
                "Content-type": "application/json"
            },
            body: JSON.stringify(nuevoPago)
        });

        if(!response.ok){
            const error = await response.text();
            throw new Error(error || "Error al procesar el pago.");
        }
       
        const dataPago = await response.json();
        console.log("Pago procesado exitosamente!", dataPago);
        contPago.classList.add("oculto");
        contForm.classList.remove("oculto");

    } catch(error){
        console.log("Ocurrió un error", error);
    }
})


