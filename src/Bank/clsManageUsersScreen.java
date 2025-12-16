package Bank;

import java.util.Scanner;

public class clsManageUsersScreen extends clsScreen{

	private static final Scanner scanner = new Scanner(System.in);
	
	private enum enManageUsersMenueOptions {eListUsers, eAddNewUser, eDeleteUser, eUpdateUser, eFindUser, eMainMenue };
	public enManageUsersMenueOptions ManageUsersMenueOptions; 
	private static short readManageUsersMenuOption() {
        System.out.print("\t\t\t\t      Choose what do you want to do? [1 to 6]? ");
        short choice = (short)clsInputValidate.readIntNumberBetween(1, 6, "\t\t\t\t      Enter Number between 1 to 6? ");
        return (short)(choice - 1);
    }
	
	private static void goBackToManageUsersMenu() {
        System.out.println("\n\nPress Enter to go back to Manage Users Menu...");
        scanner.nextLine(); 
        showManageUsersMenu();
    }
	
	private static void showListUsersScreen() {
		clsListUsersScreen.showUsersList();
    }

    private static void showAddNewUserScreen() {
    	clsAddNewUserScreen.showAddNewUserScreen();
    }

    private static void showDeleteUserScreen() {
    	clsDeleteUserScreen.showDeleteUserScreen();
    }

    private static void showUpdateUserScreen() {
    	clsUpdateUserScreen.showUpdateUserScreen();
    }

    private static void showFindUserScreen() {
    	clsFindUserScreen.showFindUserScreen();
    }
    
    static void performManageUsersMenueOption(enManageUsersMenueOptions ManageUsersMenueOption)
    {

        switch (ManageUsersMenueOption)
        {
        case enManageUsersMenueOptions.eListUsers:
        {
        	clearScreen();
            showListUsersScreen();
            goBackToManageUsersMenu();
            break;
        }

        case enManageUsersMenueOptions.eAddNewUser:
        {
        	clearScreen();
            showAddNewUserScreen();
            goBackToManageUsersMenu();
            break;
        }

        case enManageUsersMenueOptions.eDeleteUser:
        {
        	clearScreen();
            showDeleteUserScreen();
            goBackToManageUsersMenu();
            break;
        }

        case enManageUsersMenueOptions.eUpdateUser:
        {
        	clearScreen();
            showUpdateUserScreen();
            goBackToManageUsersMenu();
            break;
        }

        case enManageUsersMenueOptions.eFindUser:
        {
        	clearScreen();
             showFindUserScreen();
            goBackToManageUsersMenu();
            break;
        }

        case enManageUsersMenueOptions.eMainMenue:
        {
            //do nothing here the main screen will handle it :-) ;
        }
        }

    }
    
    private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public static void showManageUsersMenu() {
        clearScreen();
        drawScreenHeader("\t Manage Users Screen");

        System.out.println("\t\t\t\t      ===========================================");
        System.out.println("\t\t\t\t\t\t\tManage Users Menu");
        System.out.println("\t\t\t\t      ===========================================");
        System.out.println("\t\t\t\t\t\t[1] List Users.");
        System.out.println("\t\t\t\t\t\t[2] Add New User.");
        System.out.println("\t\t\t\t\t\t[3] Delete User.");
        System.out.println("\t\t\t\t\t\t[4] Update User.");
        System.out.println("\t\t\t\t\t\t[5] Find User.");
        System.out.println("\t\t\t\t\t\t[6] Main Menu.");
        System.out.println("\t\t\t\t      ===========================================");

        performManageUsersMenueOption(enManageUsersMenueOptions.values()[readManageUsersMenuOption()]);
    }
}
