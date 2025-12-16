package Bank;

import java.util.Scanner;

public class clsDeleteUserScreen extends clsScreen{

	private static final Scanner scanner = new Scanner(System.in);
	
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
	
	public static void showDeleteUserScreen() {
		if (!clsUser.CurrentUser.checkAccessPermission(clsUser.enPermissions.pDeleteClient)) {
            clsUser.drawAccessDeniedMessage();
			return;
		}
		
        drawScreenHeader("\tDelete User Screen");

        System.out.print("\nPlease Enter UserName: ");
        String userName = clsInputValidate.readString();

        while (!clsUser.IsUserExist(userName)) {
            System.out.print("\nUser is not found, choose another one: ");
            userName = clsInputValidate.readString();
        }

        clsUser user = clsUser.find(userName);
        printUser(user);
        
        System.out.print("\nAre you sure you want to delete this User y/n? ");
        char answer = scanner.nextLine().trim().toLowerCase().charAt(0);

        if (answer == 'y') {
            if (user.delete()) {
                System.out.println("\nUser Deleted Successfully :-)");
                printUser(user); 
            } else {
                System.out.println("\nError User Was not Deleted");
            }
        } else {
            System.out.println("\nDelete operation cancelled.");
        }
    }
	
}
