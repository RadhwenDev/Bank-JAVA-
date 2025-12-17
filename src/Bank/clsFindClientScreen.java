package Bank;

public class clsFindClientScreen extends clsScreen{
	
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
	
	public static void showFindClientScreen() {
		if (!clsUser.CurrentUser.checkAccessPermission(clsUser.enPermissions.pFindClient)) {
            clsUser.drawAccessDeniedMessage();
			return;
		}
		
        drawScreenHeader("\tFind Client Screen");

        System.out.print("\nPlease Enter Account Number: ");
        String accountNumber = clsInputValidate.readString();

        while (!clsBankClient.IsClientExist(accountNumber)) {
            System.out.print("\nAccount number is not found, choose another one: ");
            accountNumber = clsInputValidate.readString();
        }

        clsBankClient client = clsBankClient.find(accountNumber);

        if (!client.IsEmpty()) {
            System.out.println("\nClient Found :-)");
        } else {
            System.out.println("\nClient Was not Found :-(");
        }

        printClient(client);
    }
}
