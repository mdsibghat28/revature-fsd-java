let cusCard = document.getElementById("customerCard");
let accCard = document.getElementById("accountCard");
let tranCard = document.getElementById("transactionCard");
let empCards = document.querySelectorAll(".empCards");
let table = document.getElementById("displayTable");
let table1 = document.getElementById("displayTable1");
let table2 = document.getElementById("displayTable2");

cusCard.addEventListener("click", function(){
    table.classList.toggle("view");
});
accCard.addEventListener("click", function(){
    table1.classList.toggle("view");
});
tranCard.addEventListener("click", function(){
    table2.classList.toggle("view");
});
cusCard.addEventListener("click", function(){
        table.classList.remove("view");
        table1.classList.add("view");
        table2.classList.add("view");
});
accCard.addEventListener("click", function(){
    table.classList.add("view");
    table1.classList.remove("view");
    table2.classList.add("view");
});
tranCard.addEventListener("click", function(){
    table.classList.add("view");
    table1.classList.add("view");
    table2.classList.remove("view");
});



(async function(){
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/employees/customers");
        let customers = await response.json();
        let tableHead ="";
        let tableBody="";
        let i =0;
        tableHead = `<tr>
            <th scope="col">S.No</th>
            <th scope="col">Customer Id</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Username</th>
        </tr>`
        for(let customer of customers){
            i++;
            tableBody += `<tr> 
            <th scope="row">${i}</th>
            <td>${customer.customerId}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
          </tr>`
        }
        document.getElementById("customers").innerText = i;        
        document.getElementById("cust-table-head").innerHTML = tableHead;
        document.getElementById("cust-table-body").innerHTML = tableBody;


    } catch {

    }

})();

(async function(){
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/employees/accounts");
        let accounts = await response.json();
        let tableHead ="";
        let tableBody="";
        let i =0;
        tableHead = `<tr>
            <th scope="col">S.No</th>
            <th scope="col">Customer Id</th>
            <th scope="col">Account Id</th>
            <th scope="col">Account number</th>
            <th scope="col">Balance</th>
        </tr>`
        for(let account of accounts){
            i++;
            tableBody += `<tr> 
            <th scope="row">${i}</th>
            <td>${account.customerId}</td>
            <td>${account.accountId}</td>
            <td>${account.accountNumber}</td>
            <td>${account.balance}</td>
          </tr>`
        }
        document.getElementById("accounts").innerText = i;        
        document.getElementById("acc-table-head").innerHTML = tableHead;
        document.getElementById("acc-table-body").innerHTML = tableBody;


    } catch {

    }

})();

(async function(){
    try {
        let response = await fetch("http://localhost:8080/bank-app-rest/employees/transactions");
        let transactions = await response.json();
        let tableHead ="";
        let tableBody="";
        let i =0;
        tableHead = `<tr>
            <th scope="col">S.No</th>
            <th scope="col">Account Id</th>
            <th scope="col">Transaction Id</th>
            <th scope="col">Credit/Debit</th>
            <th scope="col">Amount</th>
        </tr>`
        for(let x of transactions){
            i++;
            tableBody += `<tr> 
            <th scope="row">${i}</th>
            <td>${x.accountId}</td>
            <td>${x.transactionId}</td>
            <td>${x.type}</td>
            <td>${x.amount}</td>
          </tr>`
        }
        document.getElementById("transactions").innerText = i;        
        document.getElementById("tran-table-head").innerHTML = tableHead;
        document.getElementById("tran-table-body").innerHTML = tableBody;


    } catch {

    }

})();
