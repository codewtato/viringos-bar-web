const form = document.querySelector("#reserve-form") as HTMLFormElement;

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

        if(!response.ok) {
            const error = await response.text();
            throw new Error(error || "Error al procesar la reserva.");
        }

        const dataReserva = await response.json();
        console.log("Reserva creada con éxito: ", dataReserva);
    } catch(error) {
        console.log("Ocurrió un error: ", error)
    }
});
