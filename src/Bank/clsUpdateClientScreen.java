package Bank;

import java.util.Scanner;

public class clsUpdateClientScreen extends clsScreen{

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
	
	private static void readClientInfo(clsBankClient client) {
        System.out.print("\nEnter FirstName: ");
        client.SetFirstName(clsInputValidate.readString());

        System.out.print("\nEnter LastName: ");
        client.SetLastName(clsInputValidate.readString());

        System.out.print("\nEnter Email: ");
        client.SetEmail(clsInputValidate.readString());

        System.out.print("\nEnter Phone: ");
        client.SetPhone(clsInputValidate.readString());

        System.out.print("\nEnter PinCode: ");
        client.SetPinCode(clsInputValidate.readString());

        System.out.print("\nEnter Account Balance: ");
        client.SetAccountBalance(clsInputValidate.readFloatNumber());
    }
	
	public static void showUpdateClientScreen() {
		if (!clsUser.CurrentUser.checkAccessPermission(clsUser.enPermissions.pUpdateClients)) {
            clsUser.drawAccessDeniedMessage();
			return;
		}
		
        drawScreenHeader("\tUpdate Client Screen");

        System.out.print("\nPlease Enter client Account Number: ");
        String accountNumber = clsInputValidate.readString();

        while (!clsBankClient.IsClientExist(accountNumber)) {
            System.out.print("\nAccount number is not found, choose another one: ");
            accountNumber = clsInputValidate.readString();
        }

        clsBankClient client = clsBankClient.find(accountNumber);
        printClient(client);

        System.out.print("\nAre you sure you want to update this client y/n? ");
        char answer = scanner.nextLine().trim().toLowerCase().charAt(0);

        if (answer == 'y') {
            System.out.println("\n\nUpdate Client Info:");
            System.out.println("____________________\n");

            readClientInfo(client);

            clsBankClient.enSaveResults saveResult = client.Save();

            switch (saveResult) {
                case svSucceeded:
                    System.out.println("\nAccount Updated Successfully :-)");
                    printClient(client);
                    break;

                case svFaildEmptyObject:
                    System.out.println("\nError account was not saved because it's Empty");
                    break;

                default:
                    System.out.println("\nUnexpected error occurred while saving.");
                    break;
            }
        } else {
            System.out.println("\nUpdate operation cancelled.");
        }
    }
	
}
