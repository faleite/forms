function login() {
	const container = document.querySelector('.container');
	const registerBtn = document.querySelector('.register-btn');
	const loginBtn = document.querySelector('.login-btn');

	if (!container || !registerBtn || !loginBtn) return;

	registerBtn.addEventListener('click', () => {
		container.classList.add('active');
	});

	loginBtn.addEventListener('click', () => {
		container.classList.remove('active');
	});

	const form = document.getElementById("entrar");
	if (!form) return;

	form.addEventListener("submit", function(event){
		event.preventDefault();

		const formEnterData = {
			login: document.getElementById("login").value,
			password: document.getElementById("password").value,
		}

		// console.log("Form Data: ", formEnterData);

		fetch('/auth/login', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(formEnterData)
		}).then(response => {
			if (response.ok) {
				return response.json();
			} else {
				alert("Dados Inválidos. Tente novamente!");
				throw new Error('Login failed');
			}
		}).then(data => {
			// Salvar token no sessionStorage
			sessionStorage.setItem('token', data.token);
			// console.log('token :', data.token);
			document.getElementById("entrar").reset();
			goToPage('task_a');
		}).catch(error => {
			console.error("Erro:", error);
			alert("(Error) Dados Inválidos. Tente novamente!");
		});
	});
}
