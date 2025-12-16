package Bank;

import java.util.Scanner;

public class clsTransactionsScreen extends clsScreen{
	
	private static final Scanner scanner = new Scanner(System.in);
	
	private enum enTransactionsMenueOptions {eDeposit, eWithdraw, eShowTotalBalance, eShowMainMenue};
	
	private static short readTransactionsMenuOption() {
        System.out.print("\t\t\t\t      Choose what do you want to do? [1 to 4]? ");
        short choice = (short)clsInputValidate.readIntNumberBetween(1, 4, "\t\t\t\t      Enter Number between 1 to 4? ");
        return (short)(choice - 1);
    }
	
	private static void goBackToTransactionsMenu() {
        System.out.println("\n\nPress Enter to go back to Transactions Menu...");
        scanner.nextLine();
        showTransactionsMenu();
    }
	
	private static void showDepositScreen() {
		clsDepositScreen.showDepositScreen();
    }

    private static void showWithdrawScreen() {
    	clsWithdrawScreen.showWithdrawScreen();
    }

    private static void showTotalBalancesScreen() {
    	clsTotalBalancesScreen.showTotalBalances();
    }
    
    static void performTransactionsMenuOption(enTransactionsMenueOptions TransactionsMenueOption)
    {
        switch (TransactionsMenueOption)
        {
        case enTransactionsMenueOptions.eDeposit:
        {
        	clearScreen();
        	showDepositScreen();
            goBackToTransactionsMenu();
            break;
        }

        case enTransactionsMenueOptions.eWithdraw:
        {
        	clearScreen();
            showWithdrawScreen();
            goBackToTransactionsMenu();
            break;
        }

        case enTransactionsMenueOptions.eShowTotalBalance:
        {
        	clearScreen();
            showTotalBalancesScreen();
            goBackToTransactionsMenu();
            break;
        }


        case enTransactionsMenueOptions.eShowMainMenue:
        {
        	clearScreen();
        	clsMainScreen.showMainMenu();
        }
        }
    }
    
    private static void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    
    public static void showTransactionsMenu() {
        clearScreen();
        drawScreenHeader("\t  Transactions Screen");

        System.out.println("\t\t\t\t      ===========================================");
        System.out.println("\t\t\t\t\t\tTransactions Menu");
        System.out.println("\t\t\t\t      ===========================================");
        System.out.println("\t\t\t\t\t\t[1] Deposit.");
        System.out.println("\t\t\t\t\t\t[2] Withdraw.");
        System.out.println("\t\t\t\t\t\t[3] Total Balances.");
        System.out.println("\t\t\t\t\t\t[4] Main Menu.");
        System.out.println("\t\t\t\t      ===========================================");

        performTransactionsMenuOption(enTransactionsMenueOptions.values()[readTransactionsMenuOption()]);
    }

}
