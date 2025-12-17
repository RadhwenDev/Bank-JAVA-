package Bank;

import java.util.ArrayList;
import java.util.Formatter;

public class clsTransferLogScreen extends clsScreen{

	
	private static void printTransferLogRecordLine(TransferLogRecord record) {
        Formatter fmt = new Formatter();
        fmt.format("| %-23s", record.dateTime);
        fmt.format("| %-8s", record.sourceAccountNumber);
        fmt.format("| %-8s", record.destinationAccountNumber);
        fmt.format("| %-8.2f", record.amount);
        fmt.format("| %-10.2f", record.srcBalanceAfter);
        fmt.format("| %-10.2f", record.destBalanceAfter);
        fmt.format("| %-8s", record.userName);

        System.out.println("\t" + fmt);
    }
	
	public static void showTransferLogScreen() {
        ArrayList<TransferLogRecord> records = clsBankClient.getTransfersLogList();

        String title = "\tTransfer Log List Screen";
        String subTitle = "\t    (" + records.size() + ") Record(s).";

        drawScreenHeader(title, subTitle);

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");

        Formatter header = new Formatter();
        header.format("| %-23s", "Date/Time");
        header.format("| %-8s", "s.Acct");
        header.format("| %-8s", "d.Acct");
        header.format("| %-8s", "Amount");
        header.format("| %-10s", "s.Balance");
        header.format("| %-10s", "d.Balance");
        header.format("| %-8s", "User");
        System.out.println("\t" + header);

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");

        if (records.isEmpty()) {
            System.out.println("\t\t\t\tNo Transfers Available In the System!");
        } else {
            for (TransferLogRecord record : records) {
                printTransferLogRecordLine(record);
            }
        }

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");
    }
	
	
	
}
