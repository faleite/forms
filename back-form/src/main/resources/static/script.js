document.getElementById("userForm").addEventListener("submit", function(event) {
    // console.log("Objeto do evento: ", event);
    // console.log("Quem disparou o evento: ", event.target);

    event.preventDefault(); // Prevent the default form submission

    const formData = {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        contactNumber: document.getElementById("contactNumber").value,
        address: document.getElementById("address").value,
        city: document.getElementById("city").value,
        state: document.getElementById("state").value,
        country: document.getElementById("country").value,
    }

    console.log("Form Data submitted: ", formData);

    // Now call spring boot api and save into database

    fetch('/api/save-data',
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        }).then(response => {
        if (response.ok) {
            document.getElementById("success").innerText = "Data saved successfully";
            document.getElementById("userForm").reset(); // Reset the form
        } else {
            //throw new Error('Network response was not ok');
            alert("Error saving data. Please try again.");
        }
    }).catch(error => {
        console.error("Error:", error);
        alert("Error saving data. Please try again.");
    });
});