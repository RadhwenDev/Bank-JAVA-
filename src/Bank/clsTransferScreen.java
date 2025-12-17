package Bank;

import java.util.Scanner;

public class clsTransferScreen extends clsScreen{

	private static final Scanner scanner = new Scanner(System.in);
	
	private static void printClient(clsBankClient client) {
        System.out.println("\nClient Card:");
        System.out.println("___________________");
        System.out.println("Full Name   : " + client.FullName());
        System.out.println("Acc. Number : " + client.AccountNumber());
        System.out.println("Balance     : " + client.GetAccountBalance());
        System.out.println("___________________\n");
    }
	
	private static String readAccountNumber(String Message) {
        System.out.print(Message);
        String accountNumber = clsInputValidate.readString();

        while (!clsBankClient.IsClientExist(accountNumber)) {
            System.out.print("\nAccount number is not found, choose another one: ");
            accountNumber = clsInputValidate.readString();
        }
        return accountNumber;
    }
	
	private static float readAmount(clsBankClient sourceClient) {
        System.out.print("Enter Transfer Amount? ");
        float amount = clsInputValidate.readFloatNumber();

        while (amount > sourceClient.GetAccountBalance()) {
            System.out.print("\nAmount Exceeds the available Balance, Enter another Amount ? ");
            amount = clsInputValidate.readFloatNumber();
        }
        return amount;
    }
	
	public static void showTransferScreen() {
        drawScreenHeader("\tTransfer Screen");

        String sourceAccNum = readAccountNumber("\nPlease Enter Account Number to Transfer From: ");
        clsBankClient sourceClient = clsBankClient.find(sourceAccNum);
        printClient(sourceClient);

        String destAccNum = readAccountNumber("\nPlease Enter Account Number to Transfer To: ");
        clsBankClient destClient = clsBankClient.find(destAccNum);
        printClient(destClient);

        float amount = readAmount(sourceClient);
        while(amount < 0) {
        	System.out.print("\nPlease enter a positif amount, ");
        	amount = readAmount(sourceClient);
        }

        System.out.print("\nAre you sure you want to perform this operation? y/n? ");
        char answer = scanner.nextLine().trim().toLowerCase().charAt(0);

        if (answer == 'y') {
            if (sourceClient.transfer(amount, destClient, clsUser.CurrentUser.GetUserName())) {
                System.out.println("\nTransfer done successfully\n");
            } else {
                System.out.println("\nTransfer Failed \n");
            }
        } else {
            System.out.println("\nOperation was cancelled.");
            return;
        }

        System.out.println("\nAfter Transfer:");
        printClient(sourceClient);
        printClient(destClient);
    }
	
}
