package Bank;

import java.util.Scanner;

public class clsFindUserScreen extends clsScreen{

	private static final Scanner scanner = new Scanner(System.in);
	
	private static void printUser(clsUser user) {
        System.out.println("\nUser Card:");
        System.out.println("___________________");
        System.out.println("FirstName   : " + user.GetFirstName());
        System.out.println("LastName    : " + user.GetLastName());
        System.out.println("Full Name   : " + user.FullName());
        System.out.println("Email       : " + user.GetEmail());
        System.out.println("Phone       : " + user.GetPhone());
        System.out.println("UserName    : " + user.GetUserName());
        System.out.println("Password    : " + user.GetPassword());
        System.out.println("Permissions : " + user.GetPermissions());
        System.out.println("___________________\n");
    }
	
	public static void showFindUserScreen() {
        drawScreenHeader("\t  Find User Screen");

        System.out.print("\nPlease Enter UserName: ");
        String userName = clsInputValidate.readString();

        while (!clsUser.IsUserExist(userName)) {
            System.out.print("\nUser is not found, choose another one: ");
            userName = clsInputValidate.readString();
        }

        clsUser user = clsUser.find(userName);

        if (!user.IsEmpty()) {
            System.out.println("\nUser Found :-)");
        } else {
            System.out.println("\nUser Was not Found :-(");
        }

        printUser(user);
    }
	
}
