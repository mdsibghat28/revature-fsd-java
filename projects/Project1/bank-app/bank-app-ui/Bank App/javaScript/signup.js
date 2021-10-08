
let signup = document.getElementById("submit");
let form = document.forms[0];
let terms = document.getElementById("gridCheck");


signup.addEventListener("click" , function() {
    if (terms.checked && form.firstName.value != null && form.firstName.value != "" && form.lastName.value != null && form.lastName.value != "" && form.email.value != null && form.email.value != "" && form.password.value.length > 3) {
        addCustomer();
        window.location.href = "index.html";
    } else {
        alert("Finish all the mandotory fields")
    }
});

async function addCustomer() {
    let customer = {
        firstName: form.firstName.value,
        lastName : form.lastName.value,
        email : form.email.value,
        password: form.password.value,
    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json"},
        body: JSON.stringify(customer)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers", options);
        //let data = await response.json();
        console.log("after getting data");

        console.log("after clearing form");

    } catch (err) {
    }
}
