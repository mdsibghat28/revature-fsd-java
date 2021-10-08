let submitBtn = document.getElementById("custLogin");
let form = document.forms[0];
let email = form.custEmail;
let password = form.custPassword;
let emailbtn = document.getElementById("inputEmail1");
let passwordbtn = document.getElementById("inputPassword1");
let loginError = document.getElementById("login-error");

loginError.style.display = "none";
submitBtn.addEventListener("click", function(){
    getCustomerById();

});


async function getCustomerById() {
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers/"+email.value+"/"+password.value);
        console.log(response.status);
        if(response.status == "401"){
            loginError.style.display = "block";
        }
        let customer = await response.json();
        if (response.status == 200){
            window.location.href = "customer.html";
        }

    } catch (err) {

    }
};