package Bank;

public class clsScreen {
	protected static void drawScreenHeader(String title) {
        drawScreenHeader(title, "");
    }

	protected static void drawScreenHeader(String title, String subTitle) {
        System.out.println("\t\t\t\t\t______________________________________");

        System.out.println("\n\t\t\t\t\t  " + title);

        if (subTitle != null && !subTitle.isEmpty()) {
            System.out.println("\t\t\t\t\t  " + subTitle);
        }

        System.out.println("\n\t\t\t\t\t______________________________________\n");
    }
	
	protected static boolean checkAccessRights(clsUser.enPermissions permission) {
        if (!clsUser.CurrentUser.checkAccessPermission(permission)) {
            System.out.println("\t\t\t\t\t______________________________________");
            System.out.println("\n\n\t\t\t\t\t  Access Denied! Contact your Admin.");
            System.out.println("\n\t\t\t\t\t______________________________________\n\n");
            return false;
        }
        return true;

    }
}
