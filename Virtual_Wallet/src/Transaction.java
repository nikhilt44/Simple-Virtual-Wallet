import java.sql.Timestamp;

//Class Transaction
class Transaction{

    private String transaction_type;
    long last_transaction_id = -1;
    private long transaction_id;
    private double amount;
    private Timestamp timestamp;
    private Transaction_account target_account;

    Transaction(String type,double amount,Timestamp timestamp) {
        this.transaction_type = type;
        last_transaction_id++;
        this.transaction_id = last_transaction_id;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    //Get the amount for the transaction
    public double get_amount(){
        return this.amount;
    }

    //Get the transaction id
    public double get_transaction_id(){
        return this.transaction_id;
    }

    //Get the transaction type -> Deposit or Withdrawl
    public String get_transaction_type(){
        return this.transaction_type;
    }

    //Get the time-stamp for the transaction
    public Timestamp get_transaction_timestamp(){
        return this.timestamp;
    }

    public void set_target_account(Transaction_account target){
        this.target_account = target;
    }

    public Transaction_account get_target_account(){
        return this.target_account;
    }
}