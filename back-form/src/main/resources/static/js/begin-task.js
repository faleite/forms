
document.getElementById("controleDiario").addEventListener("submit", function(event) {
	event.preventDefault(); // Permite que você controle o envio via JavaScript

	const formData = {
		name: document.getElementById("name").value,
		carRegistration: document.getElementById("matricula").value,
		circuit: document.getElementById("giro").value,
		initialKm: document.getElementById("kmIniciais").value,
		numObjects: document.getElementById("qtdObjetos").value,
		numCollections: document.getElementById("qtdRecolhas").value
	}
	
	console.log("Form Data: ", formData);
	
	fetch('api/start/save', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(formData)
	}).then(response => {
		if (response.ok) {
			document.getElementById("success").innerText = "Data saved successfully";
			document.getElementById("controleDiario").reset();
		} else {
			alert("Error savind data. Please try again.");
		}
	}).catch(error => {
		console.error("Error: ", error);
		alert("Error savind data. Please try again.");
	});
});