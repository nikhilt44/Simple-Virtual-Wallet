import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {

    private String user_name;
    private long user_id;
    long last_id = -1;

    //Used Map to get the account with the help of the account_name efficiently
    private HashMap<String,Transaction_account> accounts;
    private Virtual_Wallet wallet;

    User(String name){
        this.user_name = name;
        last_id++;
        this.user_id = last_id;
        accounts = new HashMap<String,Transaction_account>();
    }

    //Add the account foe this user
    public void add_account(String name, double balance){
        Transaction_account account = new Transaction_account(name, balance);
        this.accounts.put(name,account);
    }

    //Add a Virtual Wallet for this user
    public Virtual_Wallet add_virtual_wallet(String wallet_name){
        wallet = new Virtual_Wallet(wallet_name,this);
        return wallet;
    }

    //Get the account for this user
    public HashMap<String,Transaction_account> get_accounts(){
        return this.accounts;
    }

    //Get the wallet for this user
    public Virtual_Wallet get_wallet(){
        return this.wallet;
    }

    //Get the user name
    public String get_user_name(){
        return this.user_name;
    }

    //Get the user id
    public long get_user_id(){
        return this.user_id;
    }
}
