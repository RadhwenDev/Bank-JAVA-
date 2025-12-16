package Bank;

import java.util.Scanner;

public class clsMainScreen extends clsScreen{
	private static final Scanner scanner = new Scanner(System.in);
	
	private enum enMainMenueOptions {eListClients, eAddNewClient, eDeleteClient, eUpdateClient, eFindClient, eShowTransactionsMenue, eManageUsers, eExit };
	
	private static short readMainMenuOption() {
        System.out.print("\t\t\t\t      Choose what do you want to do? [1 to 8]? ");
        short choice = (short)clsInputValidate.readIntNumberBetween(1, 8, "\t\t\t\t      Enter Number between 1 to 8? ");
        return (short)(choice - 1); 
    }
	
	private static void _GoBackToMainMenue() {
        System.out.println("\n\tPress Enter to go back to Main Menu...");
        scanner.nextLine();
        showMainMenu();
    }
	
	private static void showAllClientsScreen() {
		clsClientListScreen.showClientsList();
    }
	
	private static void showAddNewClientsScreen() {
		clsAddNewClientScreen.showAddNewClientScreen();
    }

    private static void showDeleteClientScreen() {
    	clsDeleteClientScreen.showDeleteClientScreen();
    }

    private static void showUpdateClientScreen() {
    	clsUpdateClientScreen.showUpdateClientScreen();
    }

    private static void showFindClientScreen() {
    	clsFindClientScreen.showFindClientScreen();
    }

    private static void showTransactionsMenu() {
    	clsTransactionsScreen.showTransactionsMenu();
    }

    private static void showManageUsersMenu() {
    	clsManageUsersScreen.showManageUsersMenu();
    }

    private static void Logout() {
    	clsUser.CurrentUser = clsUser.find("", "");
    }
    
    private static void performMainMenuOption(enMainMenueOptions MainMenueOption) {
    	switch (MainMenueOption)
        {
        case enMainMenueOptions.eListClients:
        {
        	clearScreen();
        	showAllClientsScreen();
            _GoBackToMainMenue();
            break;
        }
        case enMainMenueOptions.eAddNewClient:
        	clearScreen();
        	showAddNewClientsScreen();
            _GoBackToMainMenue();
            break;

        case enMainMenueOptions.eDeleteClient:
        	clearScreen();
        	showDeleteClientScreen();
            _GoBackToMainMenue();
            break;

        case enMainMenueOptions.eUpdateClient:
        	clearScreen();
            showUpdateClientScreen();
            _GoBackToMainMenue();
            break;

        case enMainMenueOptions.eFindClient:
        	clearScreen();
            showFindClientScreen();
            _GoBackToMainMenue();
            break;

        case enMainMenueOptions.eShowTransactionsMenue:
        	clearScreen();
        	showTransactionsMenu();
            break;

        case enMainMenueOptions.eManageUsers:
        	clearScreen();
        	showManageUsersMenu();
            break;

        case enMainMenueOptions.eExit:
        	clearScreen();
            Logout();
            break;
        }
    }
    
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }
    
    public static void showMainMenu() {
        clearScreen();
        drawScreenHeader("\t\tMain Screen");

        System.out.println("\t\t\t\t      ===========================================");
        System.out.println("\t\t\t\t\t\t\tMain Menu");
        System.out.println("\t\t\t\t      ===========================================");
        System.out.println("\t\t\t\t\t\t[1] Show Client List.");
        System.out.println("\t\t\t\t\t\t[2] Add New Client.");
        System.out.println("\t\t\t\t\t\t[3] Delete Client.");
        System.out.println("\t\t\t\t\t\t[4] Update Client Info.");
        System.out.println("\t\t\t\t\t\t[5] Find Client.");
        System.out.println("\t\t\t\t\t\t[6] Transactions.");
        System.out.println("\t\t\t\t\t\t[7] Manage Users.");
        System.out.println("\t\t\t\t\t\t[8] Logout.");
        System.out.println("\t\t\t\t      ===========================================");

        performMainMenuOption(clsMainScreen.enMainMenueOptions.values()[readMainMenuOption()]);
    }
}
