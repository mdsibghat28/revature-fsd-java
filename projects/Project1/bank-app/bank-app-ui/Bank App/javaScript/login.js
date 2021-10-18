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
            window.location.href = "accounts.html";
        }

    } catch (err) {

    }
};

/* ********** Employee Login************ */ 

let submitBtn1 = document.getElementById("empLogin");
let form1 = document.forms[1];
let email1 = form1.empEmail;
let password1 = form1.empPassword;
let emailbtn1 = document.getElementById("empEmail");
let passwordbtn1 = document.getElementById("empPassword");
let loginError1 = document.getElementById("login-error1");

loginError1.style.display = "none";
submitBtn1.addEventListener("click", function(){
    getEmployeeById();

});


async function getEmployeeById() {
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/employees/"+email1.value+"/"+password1.value);
        console.log(response.status);
        if(response.status == "401"){
            loginError1.style.display = "block";
        }
        if (response.status == 200){
            window.location.href = "employee.html";
        }

    } catch (err) {

    }
};