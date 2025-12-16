package Bank;

import java.util.Scanner;

public class clsDepositScreen extends clsScreen{

	private static final Scanner scanner = new Scanner(System.in);
	
	private static void printClient(clsBankClient client) {
        System.out.println("\nClient Card:");
        System.out.println("___________________");
        System.out.println("FirstName   : " + client.GetFirstName());
        System.out.println("LastName    : " + client.GetLastName());
        System.out.println("Full Name   : " + client.FullName());
        System.out.println("Email       : " + client.GetEmail());
        System.out.println("Phone       : " + client.GetPhone());
        System.out.println("Acc. Number : " + client.AccountNumber());
        System.out.println("Password    : " + client.GetPinCode());
        System.out.println("Balance     : " + client.GetAccountBalance());
        System.out.println("___________________\n");
    }
	
	private static String readAccountNumber() {
        System.out.print("\nPlease enter AccountNumber? ");
        return clsInputValidate.readString();
    }
	
	public static void showDepositScreen() {
        drawScreenHeader("\t   Deposit Screen");

        String accountNumber = readAccountNumber();

        while (!clsBankClient.IsClientExist(accountNumber)) {
            System.out.println("\nClient with [" + accountNumber + "] does not exist.");
            accountNumber = readAccountNumber();
        }

        clsBankClient client = clsBankClient.find(accountNumber);
        printClient(client);

        System.out.print("\nPlease enter deposit amount? ");
        double amount = clsInputValidate.readDblNumber();
        while(amount < 0) {
        	System.out.print("\nYou cannot enter a negative number\n\nPlease enter deposit amount? ");
        	amount = clsInputValidate.readDblNumber();
        }

        System.out.print("\nAre you sure you want to perform this transaction? y/n ");
        char answer = scanner.nextLine().trim().toLowerCase().charAt(0);

        if (answer == 'y') {
            client.Deposit(amount);
            System.out.println("\nAmount Deposited Successfully.");
            System.out.println("\nNew Balance Is: " + client.GetAccountBalance());
        } else {
            System.out.println("\nOperation was cancelled.");
        }
    }
}
