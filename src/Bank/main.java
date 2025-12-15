package Bank;

import java.util.ArrayList;
import java.util.Formatter;

public class main {
	
	
	
	private static void printClientRecordBalanceLine(clsBankClient client) {
        Formatter fmt = new Formatter();
        fmt.format("| %-15s", client.AccountNumber());
        fmt.format("| %-40s", client.FullName());
        fmt.format("| %-12.2f", client.GetAccountBalance());

        System.out.println(fmt);
    }
	
	public static void showTotalBalances() {
        ArrayList<clsBankClient> clients = clsBankClient.getClientsList();

        System.out.println("\n\t\t\t\t\tBalances List (" + clients.size() + ") Client(s).");
        System.out.println("_______________________________________________________" +
                           "_________________________________________");

        Formatter header = new Formatter();
        header.format("| %-15s", "Account Number");
        header.format("| %-40s", "Client Name");
        header.format("| %-12s", "Balance");
        System.out.println(header);

        System.out.println("_______________________________________________________" +
                           "_________________________________________");

        double totalBalances = clsBankClient.getTotalBalances();

        if (clients.isEmpty()) {
            System.out.println("\t\t\t\tNo Clients Available In the System!");
        } else {
            for (clsBankClient client : clients) {
                printClientRecordBalanceLine(client);
            }
        }

        System.out.println("_______________________________________________________" +
                           "_________________________________________");
        System.out.printf("\t\t\t\t\t   Total Balances = %.2f%n", totalBalances);
    }
	
	public static void main(String[] args) {
		clsMainScreen.showMainMenu();
		//showTotalBalances();
	}

}
