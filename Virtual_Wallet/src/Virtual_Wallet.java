import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

//Virtual Wallet class
public class Virtual_Wallet{

    private String wallet_name;
    private User user;

    Virtual_Wallet(String name,User user){
        this.wallet_name = name;
        this.user = user;
    }

    //Get the Virtual wallet name
    public String get_wallet_name(){
        return this.wallet_name;
    }

    //Do a Transaction
    public void add_transaction(String account_name, String transaction_type, double amount) throws Exception {

        //Get the account to perform transaction on
        Transaction_account account = this.user.get_accounts().get(account_name);
        account.add_transaction(transaction_type,amount);
    }

    //Return last N transactions for an account
    public ArrayList<Transaction> get_transactions(int n, String account_type){

        //Get the account to get transactions_from
        Transaction_account account = this.user.get_accounts().get(account_type);
        LinkedHashSet<Transaction> transactions = account.get_Transactions();

        ArrayList<Transaction> result = new ArrayList<Transaction>();
        result.addAll(0,transactions);

        //If the number of transactions is less than n
        if(transactions.size()<n){
            return result;
        }

        ArrayList<Transaction> final_result = new ArrayList<>(result.subList(0,n));
        return final_result;
    }

    //Get account Balance
    public double get_account_balance(String account_name){
        Transaction_account account = this.user.get_accounts().get(account_name);
        return account.get_balance();
    }

    //Transfer money between accounts
    public void transfer_money(String source_account_name, String target_account_name,double amount) throws Exception {

        Transaction_account source_account = this.user.get_accounts().get(source_account_name);
        Transaction_account target_account = this.user.get_accounts().get(target_account_name);
        source_account.transfer_amount(target_account,amount);
    }

}
