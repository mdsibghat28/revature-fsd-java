(async function () {
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/customers");
        let customer = await response.json();
        let html = "";
        html =  `<li>Customer Id :<span>${ customer.customerId}</span></li>
                        <li>First Name :<span>${ customer.firstName}</span></li>
                        <li>Last Name :<span>${ customer.lastName}</span></li>
                        <li>User Id :<span>${ customer.email}</span></li> `;
        document.getElementById("customerDetails").innerHTML = html;
    } catch (err) {

        }
})();

/*             New account Registration                    */

let newAccount = document.getElementById("submit");
let form = document.forms[0];
let accNum = form.accountNumber;
let balance = form.initialDeposit;

newAccount.addEventListener("click" , function() {
    console.log(accNum.value);
    console.log(parseInt(balance.value));
    if (balance.value > 0 ) {
       console.log("success");
        addAccount();
        window.location.href = "customer.html";
    } else {
        alert("Finish all the mandotory fields")
    }
});

async function addAccount() {
    let account = {
        accountNumber: accNum.value,
        balance : balance.value,
    };

    var options = {
        method: 'POST',
        headers: { "Content-Type": "application/json"},
        body: JSON.stringify(account)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/accounts", options);

    } catch (err) {
    }
}
