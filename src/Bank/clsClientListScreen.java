package Bank;

import java.util.ArrayList;
import java.util.Formatter;

public class clsClientListScreen extends clsScreen{

	private static void printClientRecordLine(clsBankClient client) {
        Formatter fmt = new Formatter();
        fmt.format("| %-15s", client.AccountNumber());
        fmt.format("| %-20s", client.FullName());
        fmt.format("| %-12s", client.GetPhone());
        fmt.format("| %-20s", client.GetEmail());
        fmt.format("| %-10s", client.GetPinCode());
        fmt.format("| %-12.2f", client.GetAccountBalance());

        System.out.println(fmt);
    }
	
	public static void showClientsList() {
        ArrayList<clsBankClient> clients = clsBankClient.getClientsList();

        String title = "\t  Client List Screen";
        String subTitle = "\t    (" + clients.size() + ") Client(s).";

        drawScreenHeader(title, subTitle);

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");

        Formatter header = new Formatter();
        header.format("| %-15s", "Account Number");
        header.format("| %-20s", "Client Name");
        header.format("| %-12s", "Phone");
        header.format("| %-20s", "Email");
        header.format("| %-10s", "Pin Code");
        header.format("| %-12s", "Balance");
        System.out.println(header);

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");

        if (clients.isEmpty()) {
            System.out.println("\t\t\t\tNo Clients Available In the System!");
        } else {
            for (clsBankClient client : clients) {
                printClientRecordLine(client);
            }
        }

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");
    }
	
}
