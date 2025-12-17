package Bank;

public class clsLoginScreen extends clsScreen{

	public static boolean showLoginScreen() {
        drawScreenHeader("\t     Login Screen");
        if(login()) {
        	clearScreen();
        	return true;
        	}
        return false;
    }
	
	private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
	
	private static boolean login() {
        boolean loginFailed = false;
        short FaildLoginCount = 3;
        
        String username;
        String password;

        do {
            if (loginFailed)
            {
            	System.out.println("\nInvalid Username/Password!\n");
                System.out.println("You Have " + FaildLoginCount + " Trial(s) to login.\n");
            }

            System.out.print("Enter Username? ");
            username = clsInputValidate.readString();

            System.out.print("Enter Password? ");
            password = clsInputValidate.readString();

            clsUser.CurrentUser = clsUser.find(username, password);

            loginFailed = clsUser.CurrentUser.IsEmpty();
            
            if (loginFailed)
            {
            	FaildLoginCount--;
            }

        } while (loginFailed && FaildLoginCount > 0);
        if(FaildLoginCount == 0) {
        	System.out.println("\nYou are Locked after 3 faild trails\n");
        	return false;
        }
        clsUser.CurrentUser.registerLogin();
        clsMainScreen.showMainMenu();
        return true;
    }
	
}
