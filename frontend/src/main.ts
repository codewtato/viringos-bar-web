const form = document.querySelector("#reserve-form") as HTMLFormElement;
const inputName = document.querySelector("#input-name") as HTMLInputElement;
const inputDate = document.querySelector("#input-date") as HTMLInputElement;
const inputTime = document.querySelector("#input-time") as HTMLInputElement;
const inputSize = document.querySelector("#input-size") as HTMLInputElement;
form.addEventListener("submit", (e) => {
    e.preventDefault();
    const name = inputName.value;
    const date = inputDate.value;
    const time = inputTime.value;
    const size = inputSize.value;
})
