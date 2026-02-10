
document.getElementById("controleDiario").addEventListener("submit", function(event) {
	event.preventDefault(); // Permite que você controle o envio via JavaScript

	const formData = {
		name: document.getElementById("name").value,
		matricula: document.getElementById("matricula").value,
		kmIniciais: document.getElementById("kmIniciais").value,
		giro: document.getElementById("giro").value,
		qtdObjetos: document.getElementById("qtdObjetos").value,
		qtdRecolhas: document.getElementById("qtdRecolhas").value
	}
	
	console.log("Form Data: ", formData);
	
	fetch('http://localhost:8080/api/save-data', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(formData)
	}).then(response => {
		if (response.ok) {
			console.log("Form Data submitted: ", formData);
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