/*            View Accounts                    */
(async function() {
    try {
        let customerResponse = await fetch("http://localhost:8080/bank-app-rest/customers");
        let customer = await customerResponse.json();
        let response = await fetch("http://localhost:8080/bank-app-rest/accounts");
        let accounts = await response.json();
        let customerDetails = "";
         customerDetails = `<div class="col-md-6 col-lg-6 col-xl-4 mb-2">
                                        <div class="card">
                                        <div class="p-4">
                                            <div class="d-flex flex-row">
                                                <div class=""><img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="user" class="rounded-circle" width="100" /></div>
                                                    <div class=" ms-3 pl-4">
                                                        <h4>${customer.firstName + " " + customer.lastName}</h4>
                                                        <h3>Username: ${customer.email}</h3>
                                                        <button class="balance btn btn-info btn-rounded text-white  font-14"><i class="fa fa-id-card mr-2"></i><span class="balanceBtnDisp"> Customer Id: </span><span class="balanceDisp" > ${customer.customerId}</span></button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card-body row">
                                                <button class="col-sm-6 col-md-5 btn btn-success disabled"><i class="fas fa-info"></i> Edit Details</button>
                                                <button class="col-sm-6 col-md-5 btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop"><i class="fas fa-plus-square"></i> New Account</button>
                                                <button class ="col-sm-6 col-md-5 btn btn-info text-white" id = "viewAccounts" ><i class="fas fa-eye"></i> Accounts</button>
                                                <button class ="col-sm-6 col-md-5 btn btn-danger"><i class="fas fa-sign-out-alt"></i> Logout</button>
                                            </div>
                                        </div>
                                        </div>`
        let accCards = "";
        let depositModals ="";
        for (let account of accounts) {
            accCards +=  `<div class="col-md-6 col-lg-6 col-xl-4 mb-2 cardDisplay view">
                             <div class="card">
                                <div class="p-4">
                                    <div class="d-flex flex-row">
                                        <div class=""><img src="https://icon-library.com/images/money-check-icon/money-check-icon-13.jpg" alt="user" class="rounded-circle" width="100" /></div>
                                            <div class=" ms-3 pl-4">
                                                <h4>${account.accountNumber}</h4>
                                                <h3>Account Id: ${account.accountId}</h3>
                                                <button class="balance btn btn-info btn-rounded text-white text-uppercase font-14"><span class="balanceBtnDisp">Balance: </span><span class="balanceDisp" > ${account.balance} </span><i class="fa fa-dollar mr-2"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body row">
                                        <button class="col-sm-6 col-md-5 btn btn-success deposit" data-bs-toggle="modal" data-bs-target="#staticBackdrop1"  data-accountid = ${account.accountId} data-accnum = ${account.accountNumber}><i class="fas fa-coins"></i> Deposit</button>
                                        <button class="col-sm-6 col-md-5 btn btn-primary withdraw" data-bs-toggle="modal" data-bs-target="#staticBackdrop2" data-accountid = ${account.accountId} data-accnum = ${account.accountNumber} data-balance = ${account.balance}><i class="fas fa-hand-holding-usd"></i> Withdraw</button>
                                        <button class ="col-sm-6 col-md-5 btn btn-info disabled" data-accountid = ${account.accountId} data-accnum = ${account.accountNumber}><i class="fas fa-random"></i> Trasfer</button>
                                        <button class ="col-sm-6 col-md-5 btn btn-secondary transactionBtn"aria-controls="offcanvasExample" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" data-accountid = ${account.accountId} data-accnum = ${account.accountNumber}><i class="fas fa-file-invoice-dollar"></i> Transactions</button>
                                    </div>
                                </div>
                            </div>`;
        }
        let html = customerDetails + accCards;
        document.getElementById("accountCards").innerHTML = html;
        document.getElementById("deposit-modals").innerHTML = depositModals;

    } catch (err) {

        }
        let cards = document.getElementsByClassName("cardDisplay");
        let toggleAccounts = document.getElementById("viewAccounts");
        let depositbtn = document.getElementsByClassName("deposit");
        let withdrawbtn = document.getElementsByClassName("withdraw");
        let accDisp = document.getElementById("account-id");
        let accDisp1 = document.getElementById("account-id1");
        let transactionBtn = document.getElementsByClassName("transactionBtn");
   
        toggleAccounts.addEventListener("click", function(){
            for (let i =0; i < cards.length; i++){
                cards[i].classList.toggle("view");
            }
        });

        for (let i =0; i < cards.length; i++){
            depositbtn[i].addEventListener("click", function(){
                 accDisp.innerText = depositbtn[i].dataset.accnum;
                 currentAccNum = accDisp.innerText;
            });
            withdrawbtn[i].addEventListener("click", function(){
                accDisp1.innerText = withdrawbtn[i].dataset.accnum;
                currentAccNum = accDisp1.innerText;
                currentBalance = withdrawbtn[i].dataset.balance
           });
           transactionBtn[i].addEventListener("click", function(){
            transactionAcountId = transactionBtn[i].dataset.accountid;
            alert(transactionAcountId)
       });

        }

})();

let currentAccNum;
let currentBalance;
let depositSubmitBtn = document.getElementById("depositSubmit");
let depositForm = document.forms[1];
let amount = depositForm.depositAmount;
let withdrawSubmitBtn = document.getElementById("withdrawSubmit");
let withdrawForm = document.forms[2];
let amount1 = withdrawForm.withdrawAmount;

depositSubmitBtn.addEventListener("click", function(){
    if(amount.value < 100){
        document.querySelector("#deposit-error-message").style.display = "block";
    } else {
        deposit();
        window.location.href = "accounts.html";
    }
});

withdrawSubmitBtn.addEventListener("click", function(){
    if(amount1.value < 100){
        document.querySelector("#withdraw-error-message").style.display = "block";
    }
    if(parseInt(amount1.value) > parseInt(currentBalance)){
        document.querySelector("#withdraw-error-message").innerText = "Insufficient Funds";
        document.querySelector("#withdraw-error-message").style.display = "block";
    } else {
        withdraw();
        window.location.href = "accounts.html";
    }
});

async function deposit() {
    let depositDetails = {
        accountNumber: currentAccNum,
        balance: amount.value
    };

    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(depositDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/deposit", options);

        if (response.status == 200){
            alert("Successfull");
        }

    }
    catch (err) {

    }
}

async function withdraw() {
    let withdrawDetails = {
        accountNumber: currentAccNum,
        balance: amount1.value
    };

    var options = {
        method: 'PUT',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(withdrawDetails)
    };
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/transactions/withdraw", options);

        if (response.status == 200){
            alert("Successfull");
        }

    }
    catch (err) {

    }
}



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
        window.location.href = "accounts.html";
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




