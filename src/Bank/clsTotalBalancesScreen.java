package Bank;

import java.util.ArrayList;
import java.util.Formatter;

public class clsTotalBalancesScreen extends clsScreen{

	private static void printClientRecordBalanceLine(clsBankClient client) {
        Formatter fmt = new Formatter();
        fmt.format("| %-15s", client.AccountNumber());
        fmt.format("| %-40s", client.FullName());
        fmt.format("| %-12.2f", client.GetAccountBalance());

        System.out.println("\t\t" + fmt);
    }
	
	
	public static void showTotalBalances() {
        ArrayList<clsBankClient> clients = clsBankClient.getClientsList();

        String title = "\t  Balances List Screen";
        String subTitle = "\t    (" + clients.size() + ") Client(s).";

        drawScreenHeader(title, subTitle);

        System.out.println("\t\t_______________________________________________________" +
                           "__________________________");

        Formatter header = new Formatter();
        header.format("| %-15s", "Account Number");
        header.format("| %-40s", "Client Name");
        header.format("| %-12s", "Balance");
        System.out.println("\t\t" + header);

        System.out.println("\t\t_______________________________________________________" +
                           "__________________________");

        double totalBalances = clsBankClient.getTotalBalances();

        if (clients.isEmpty()) {
            System.out.println("\t\t\t\tNo Clients Available In the System!");
        } else {
            for (clsBankClient client : clients) {
                printClientRecordBalanceLine(client);
            }
        }

        System.out.println("\t\t_______________________________________________________" +
                           "__________________________");
        System.out.printf("\t\t\t\t\t\t\t     Total Balances = %.2f%n", totalBalances);
    }
}
