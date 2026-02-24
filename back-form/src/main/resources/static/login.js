const container = document.querySelector('.container');
const registerBtn = document.querySelector('.register-btn');
const loginBtn = document.querySelector('.login-btn');

registerBtn.addEventListener('click', () => {
	container.classList.add('active');
});

loginBtn.addEventListener('click', () => {
	container.classList.remove('active');
});

document.getElementById("entrar").addEventListener("submit", function(event){
	event.preventDefault();

	const formEnterData = {
		login: document.getElementById("login").value,
		password: document.getElementById("password").value,
	}

	//
	console.log("Form Data: ", formEnterData);

	fetch('/auth/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(formEnterData)
	}).then(response => {
		if (response.ok) {
			document.getElementById
		}
	})
})