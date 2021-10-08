/*            View Accounts                    */
(async function() {
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/accounts");
        let accounts = await response.json();
        let html = "";
        for (let account of accounts) {
            html +=  `<div class="col-md-6 col-lg-4 mb-2">
                             <div class="card">
                                <div class="p-4">
                                    <div class="d-flex flex-row">
                                        <div class=""><img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="user" class="rounded-circle" width="100" /></div>
                                            <div class=" ms-3 pl-4">
                                                <h3>Account Number</h3>
                                                <h4>${account.accountNumber}</h4>
                                                <button class="balance btn btn-info btn-rounded text-white text-uppercase font-14"><span class="balanceBtnDisp">Balance: </span><span class="balanceDisp" > ${account.balance} </span><i class="fa fa-dollar mr-2"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="card-body row">
                                        <button class="col-sm-6 col-md-5 btn btn-success">Deposit</button>
                                        <button class="col-sm-6 col-md-5 btn btn-primary">Withdraw</button>
                                        <button class ="col-sm-6 col-md-5 btn btn-info disabled">Trasfer</button>
                                        <button class ="col-sm-6 col-md-5 btn btn-secondary disabled">Transactions</button>
                                    </div>
                                </div>
                            </div>`;
        }
        document.getElementById("accountCards").innerHTML = html;

    } catch (err) {

        }
})();


