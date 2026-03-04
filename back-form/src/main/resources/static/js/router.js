function goToPage(page) {
	fetch(`/pages/${page}.html`)
		.then(response => {
			if (!response.ok) {
				throw new Error('Página não encontrada');
			}
			return response.text();
		})
		.then(html => {
			document.getElementById('content').innerHTML = html;
			// setActiveNav(page)
			initPage(page);
		})
		.catch(error => {
			console.error("Erro:", error);
			alert("Página Inválida. Tente novamente!");
	});
}

// function initApp() {
// 	const token = sessionStorage.getItem('token');
// 	const initialPage = token ? 'task_a' : 'login';

// 	goToPage(initialPage);
// }

// function setActiveNav(page) {
//     document.querySelectorAll('nav a').forEach(link => {
//         link.classList.remove('active');
//         if (link.getAttribute('onclick').includes(page)) {
//             link.classList.add('active');
//         }
//     });
// }


function initPage(page) {
	const models = {login, task_a}
	if (models[page]) {
		models[page]()
	}
}

document.addEventListener('DOMContentLoaded', () => goToPage('login'));
