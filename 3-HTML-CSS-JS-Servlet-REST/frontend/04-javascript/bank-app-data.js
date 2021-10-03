var transaction1 = {
    id:  1,
    amount: 20000,
    type: 'C',
} ;
var transaction2 = {
    id:  2,
    amount: 3000,
    type: 'D',
} ;

var transaction = [transaction1, transaction2];

var account1 ={
    id: 1,
    accountNumber: 123456,
    balance: 10000,
    approved: 'N',
    transactions: transaction,
};