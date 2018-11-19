
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.LinkedHashSet;

class Main {

    public static void main(String[] args) throws Exception {

        //Create a User
        User user = new User("Nikhil");

        //Add a virtual wallet for the user
        Virtual_Wallet wallet = user.add_virtual_wallet("my_wallet");

        //Add accounts for the user with an account name and some initial balance
        double initial_balance = 500;
        user.add_account("Checking",initial_balance);
        user.add_account("Savings",initial_balance+1000);


        //Perform transactions using the wallet
        //first parameter is the account name to perform transaction on
        //second parameter is the type of transaction
        //third parameter is the amount to be used in the transaction
        wallet.add_transaction("Checking","Deposit",200);
        wallet.add_transaction("Savings","Deposit",200);
        wallet.add_transaction("Checking","Withdrawl",10);

        //Get account Balance by account name
        System.out.println("Initial Balances");
        System.out.println(wallet.get_account_balance("Checking"));
        System.out.println(wallet.get_account_balance("Savings") +"\n");


        //Perform a Transfer from one account to another
        //first parameter is the source account
        //second parameter is the target account
        //third parameter is the amount to be transferred
        wallet.transfer_money("Checking","Savings",100);
        wallet.transfer_money("Savings","Checking",100);

        System.out.println("Balances after transactions");
        System.out.println(wallet.get_account_balance("Checking"));
        System.out.println(wallet.get_account_balance("Savings")+"\n");


        //Get the last N transaction for a particular account
        ArrayList<Transaction> result = wallet.get_transactions(10,"Savings");
        ArrayList<Transaction> result1 = wallet.get_transactions(10,"Checking");

        System.out.println(result);
        System.out.println(result1);
    }
}
