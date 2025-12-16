package Bank;

public class clsAddNewClientScreen extends clsScreen{

	
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
	
	public static void showAddNewClientScreen() {
		if (!clsUser.CurrentUser.checkAccessPermission(clsUser.enPermissions.pAddNewClient)) {
            clsUser.drawAccessDeniedMessage();
			return;
		}
		
        drawScreenHeader("\t  Add New Client Screen");

        System.out.print("\nPlease Enter Account Number: ");
        String accountNumber = clsInputValidate.readString();

        while (clsBankClient.IsClientExist(accountNumber)) {
            System.out.print("\nAccount Number Is Already Used, Choose another one: ");
            accountNumber = clsInputValidate.readString();
        }

        clsBankClient newClient = clsBankClient.getAddNewClientObject(accountNumber);

        readClientInfo(newClient);

        clsBankClient.enSaveResults saveResult = newClient.Save();

        switch (saveResult) {
            case svSucceeded:
                System.out.println("\nAccount Added Successfully :-)");
                printClient(newClient);
                break;

            case svFaildEmptyObject:
                System.out.println("\nError: Account was not saved because it's empty.");
                break;

            case svFaildAccountNumberExists:
                System.out.println("\nError: Account was not saved because account number already exists!");
                break;

            default:
                System.out.println("\nUnknown error occurred while saving.");
                break;
        }
    }
	
}
