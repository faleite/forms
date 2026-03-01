function browse(page) {
	fetch(`/pages/${page}.html`)
		.then(response => {
			if (!response.ok) {
				throw new Error('Página não encontrada');
			}
			return response.text();
		})
		.then(html => {
			document.getElementById('content').innerHTML = html;
		})
		.catch(error => {
			console.error("Erro:", error);
			alert("Página Inválida. Tente novamente!");
	});
}