package Bank;

import java.util.ArrayList;
import java.util.Formatter;

public class clsLoginRegisterScreen extends clsScreen{

	private static void printLoginRegisterRecordLine(clsUser.LoginRegisterRecord record) {
        Formatter fmt = new Formatter();
        fmt.format("| %-35s", record.dateTime);
        fmt.format("| %-20s", record.userName);
        fmt.format("| %-20s", record.password);
        fmt.format("| %-10d", record.permissions);

        System.out.println("\t" + fmt);
    }
	
	public static void showLoginRegisterScreen() {
		if (!clsUser.CurrentUser.checkAccessPermission(clsUser.enPermissions.pShowLogInRegister)) {
            clsUser.drawAccessDeniedMessage();
            return; 
        }
		
        ArrayList<clsUser.LoginRegisterRecord> records = clsUser.getLoginRegisterList();

        String title = "\tLogin Register List Screen";
        String subTitle = "\t\t(" + records.size() + ") Record(s).";

        drawScreenHeader(title, subTitle);

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");

        Formatter header = new Formatter();
        header.format("| %-35s", "Date/Time");
        header.format("| %-20s", "UserName");
        header.format("| %-20s", "Password");
        header.format("| %-10s", "Permissions");
        System.out.println("\t" + header);

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");

        if (records.isEmpty()) {
            System.out.println("\t\t\t\tNo Logins Available In the System!");
        } else {
            for (clsUser.LoginRegisterRecord record : records) {
                printLoginRegisterRecordLine(record);
            }
        }

        System.out.println("\t_______________________________________________________" +
                           "_________________________________________");
    }
	
}
