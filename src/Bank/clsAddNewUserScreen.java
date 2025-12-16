package Bank;

import java.util.Scanner;

public class clsAddNewUserScreen extends clsScreen{
	
	private static final Scanner scanner = new Scanner(System.in);
	
	private static void readUserInfo(clsUser user) {
        System.out.print("\nEnter FirstName: ");
        user.SetFirstName(clsInputValidate.readString());

        System.out.print("\nEnter LastName: ");
        user.SetLastName(clsInputValidate.readString());

        System.out.print("\nEnter Email: ");
        user.SetEmail(clsInputValidate.readString());

        System.out.print("\nEnter Phone: ");
        user.SetPhone(clsInputValidate.readString());

        System.out.print("\nEnter Password: ");
        user.SetPassword(clsInputValidate.readString());

        System.out.print("\nEnter Permission: ");
        user.SetPermissions(readPermissionsToSet());
    }
	
	private static void printUser(clsUser user) {
        System.out.println("\nUser Card:");
        System.out.println("___________________");
        System.out.println("FirstName   : " + user.GetFirstName());
        System.out.println("LastName    : " + user.GetLastName());
        System.out.println("Full Name   : " + user.FullName());
        System.out.println("Email       : " + user.GetEmail());
        System.out.println("Phone       : " + user.GetPhone());
        System.out.println("User Name   : " + user.GetUserName());
        System.out.println("Password    : " + user.GetPassword());
        System.out.println("Permissions : " + user.GetPermissions());
        System.out.println("___________________\n");
    }
	
	private static int readPermissionsToSet() {
        int permissions = 0;
        System.out.print("\nDo you want to give full access? y/n? ");
        char answer = scanner.nextLine().trim().toLowerCase().charAt(0);

        if (answer == 'y') {
            return -1;
        }

        System.out.println("\nDo you want to give access to : \n");

        permissions += askPermission("Show Client List? y/n? ", clsUser.enPermissions.pListClients.ordinal());
        permissions += askPermission("Add New Client? y/n? ", clsUser.enPermissions.pAddNewClient.ordinal());
        permissions += askPermission("Delete Client? y/n? ", clsUser.enPermissions.pDeleteClient.ordinal());
        permissions += askPermission("Update Client? y/n? ", clsUser.enPermissions.pUpdateClients.ordinal());
        permissions += askPermission("Find Client? y/n? ", clsUser.enPermissions.pFindClient.ordinal());
        permissions += askPermission("Transactions? y/n? ", clsUser.enPermissions.pTranactions.ordinal());
        permissions += askPermission("Manage Users? y/n? ", clsUser.enPermissions.pManageUsers.ordinal());

        return (permissions == 127) ? -1 : permissions;
    }

    private static int askPermission(String question, int permissionValue) {
        System.out.print(question);
        char answer = scanner.nextLine().trim().toLowerCase().charAt(0);
        return (answer == 'y') ? permissionValue : 0;
    }
    
    public static void showAddNewUserScreen() {
    	if (!clsUser.CurrentUser.checkAccessPermission(clsUser.enPermissions.pAddNewClient)) {
            clsUser.drawAccessDeniedMessage();
			return;
		}
    	
        drawScreenHeader("\t  Add New User Screen");

        System.out.print("\nPlease Enter UserName: ");
        String userName = clsInputValidate.readString();

        while (clsUser.IsUserExist(userName)) {
            System.out.print("\nUserName Is Already Used, Choose another one: ");
            userName = clsInputValidate.readString();
        }

        clsUser newUser = clsUser.getAddNewUserObject(userName);

        readUserInfo(newUser);

        clsUser.enSaveResults saveResult = newUser.Save();

        switch (saveResult) {
            case svSucceeded:
                System.out.println("\nUser Added Successfully :-)");
                printUser(newUser);
                break;

            case svFaildEmptyObject:
                System.out.println("\nError User was not saved because it's Empty");
                break;

            case svFaildUserExists:
                System.out.println("\nError User was not saved because UserName is used!");
                break;

            default:
                System.out.println("\nUnknown error occurred.");
                break;
        }
    }
	
}
