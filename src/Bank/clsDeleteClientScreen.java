package Bank;

import java.util.Scanner;

public class clsDeleteClientScreen extends clsScreen{

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
	
	public static void showDeleteClientScreen() {
        drawScreenHeader("\tDelete Client Screen");

        System.out.print("\nPlease Enter Account Number: ");
        String accountNumber = clsInputValidate.readString();

        while (!clsBankClient.IsClientExist(accountNumber)) {
            System.out.print("\nAccount number is not found, choose another one: ");
            accountNumber = clsInputValidate.readString();
        }

        clsBankClient client = clsBankClient.find(accountNumber);
        printClient(client);

        System.out.print("\nAre you sure you want to delete this client y/n? ");
        char answer = scanner.nextLine().trim().toLowerCase().charAt(0);

        if (answer == 'y') {
            if (client.delete()) {
                System.out.println("\nClient Deleted Successfully :-)");
                printClient(client);
            } else {
                System.out.println("\nError Client Was not Deleted");
            }
        } else {
            System.out.println("\nDelete operation cancelled.");
        }
    }
}
