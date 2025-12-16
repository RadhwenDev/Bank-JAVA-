package Bank;

import java.util.ArrayList;
import java.util.Formatter;

public class clsListUsersScreen extends clsScreen{

	private static void printUserRecordLine(clsUser user) {
        Formatter fmt = new Formatter();
        fmt.format("| %-12s", user.GetUserName());
        fmt.format("| %-25s", user.FullName());
        fmt.format("| %-12s", user.GetPhone());
        fmt.format("| %-20s", user.GetEmail());
        fmt.format("| %-10s", user.GetPassword());
        fmt.format("| %-12d", user.GetPermissions());

        System.out.println("\t" + fmt);
    }
	
	public static void showUsersList() {
        ArrayList<clsUser> users = clsUser.getUsersList();

        String title = "\t  User List Screen";
        String subTitle = "\t    (" + users.size() + ") User(s).";

        drawScreenHeader(title, subTitle);

        System.out.println("\t_______________________________________________________" +
                           "______________________________________________");
        Formatter header = new Formatter();
        header.format("| %-12s", "UserName");
        header.format("| %-25s", "Full Name");
        header.format("| %-12s", "Phone");
        header.format("| %-20s", "Email");
        header.format("| %-10s", "Password");
        header.format("| %-12s", "Permissions");
        System.out.println("\t" + header);

        System.out.println("\t_______________________________________________________" +
                           "______________________________________________");

        if (users.isEmpty()) {
            System.out.println("\t\t\t\tNo Users Available In the System!");
        } else {
            for (clsUser user : users) {
                printUserRecordLine(user);
            }
        }

        System.out.println("\t_______________________________________________________" +
                           "______________________________________________");
    }
	
}
