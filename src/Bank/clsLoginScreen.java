package Bank;

public class clsLoginScreen extends clsScreen{

	public static void showLoginScreen() {
        drawScreenHeader("\t  Login Screen");
        login();
        clearScreen();
    }
	
	private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
	
	private static void login() {
        boolean loginFailed = false;

        String username;
        String password;

        do {
            if (loginFailed) {
                System.out.println("\nInvalid Username/Password!\n");
            }

            System.out.print("Enter Username? ");
            username = clsInputValidate.readString();

            System.out.print("Enter Password? ");
            password = clsInputValidate.readString();

            clsUser.CurrentUser = clsUser.find(username, password);

            loginFailed = clsUser.CurrentUser.IsEmpty();

        } while (loginFailed);
        
        clsMainScreen.showMainMenu();
    }
	
}
