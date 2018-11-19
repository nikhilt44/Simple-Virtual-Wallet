import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashSet;

public class Transaction_account {

    private String account_name;
    private long account_id;
    long last_account_id = -1;
    double initial_balance;
    private double current_balance;

    //Used LinkedHashSet to maintain the order of transactions
    private LinkedHashSet<Transaction> transactions;
    Date date = new Date();

    Transaction_account(String name, double initial_balance) {
        last_account_id++;
        this.account_id = last_account_id;
        this.initial_balance = initial_balance;
        this.current_balance = initial_balance;
        this.account_name = name;
        this.transactions = new LinkedHashSet<Transaction>();
    }

    //Do a transaction on this account
    public void add_transaction(String transaction_type, double amount) throws Exception {

        //Check for the account balance
        if (transaction_type.equals("Withdrawl")) {
            if (this.current_balance - amount <= 0) {
                //System.out.println("Cannot perform this Transaction as it will result in zero or negative balance");
                throw new Exception("Cannot perform this Transaction as it will result in zero or negative balance");
                //return;
            }
        }

        //Get the current timestamp
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);

        //Create a Transaction and add it to the list of transaction
        Transaction transaction = new Transaction(transaction_type,amount,timestamp);
        if(transaction_type.equals("Withdrawl")){
            this.current_balance -= amount;
        }
        else if(transaction_type.equals("Deposit")){
            this.current_balance += amount;
        }
        this.transactions.add(transaction);
    }

    //Transer some amount to another account
    public void transfer_amount(Transaction_account target_account, double amount) throws Exception {

        if(amount>=this.current_balance){
            throw new Exception("Cannot perform this Transaction as it will result in zero or negative balance");
        }

        //Get the current timestamp
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);

        //Create a Transaction and add it to the list of transaction
        Transaction transaction = new Transaction("transfer",amount,timestamp);
        //Set the target account in the transaction to target
        transaction.set_target_account(target_account);

        //Change the amount in respective accounts
        this.current_balance -= amount;
        target_account.current_balance += amount;

        this.transactions.add(transaction);
    }


    //Get the balance for the account
    public Double get_balance(){
        return this.current_balance;
    }

    //Get the account id
    public Long get_account_id(){
        return this.account_id;
    }

    //Get the transaction made till now
    public LinkedHashSet<Transaction> get_Transactions(){
        return this.transactions;
    }

    //Get the account name
    public String get_account_name(){
        return this.account_name;
    }
}


