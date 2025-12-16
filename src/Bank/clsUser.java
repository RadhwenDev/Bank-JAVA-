package Bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class clsUser extends clsPerson{
	
	
	private enum enMode { EmptyMode, UpdateMode, AddNewMode };
	private enMode Mode;
	private String UserName;
    private String Password;
    private int Permissions;
    
    boolean MarkedForDelete = false;

    public static clsUser CurrentUser = GetEmptyUserObject();
	
    private static clsUser ConvertLinetoUserObject(String line, String separator) {
        if (separator == null || separator.isEmpty()) {
            separator = "#//#"; 
        }

        ArrayList<String> userData = new ArrayList<>(Arrays.asList(line.split(java.util.regex.Pattern.quote(separator))));

        return new clsUser(
            enMode.UpdateMode,         
            userData.get(0).trim(),             
            userData.get(1).trim(),             
            userData.get(2).trim(),             
            userData.get(3).trim(),     
            userData.get(4).trim(),    
            userData.get(5).trim(),  
            Integer.parseInt(userData.get(6).trim())
        );
    }
    
	private static clsUser ConvertLinetoUserObject(String line) {
        return ConvertLinetoUserObject(line, "#//#");
    }
    
    private static String ConverUserObjectToLine(clsUser User, String Seperator)
    {
        String stUserRecord = "";
        stUserRecord += User.GetFirstName() + Seperator;
        stUserRecord += User.GetLastName() + Seperator;
        stUserRecord += User.GetEmail() + Seperator;
        stUserRecord += User.GetPhone() + Seperator;
        stUserRecord += User.UserName + Seperator;
        stUserRecord += User.Password  + Seperator;
        stUserRecord += User.Permissions;
        return stUserRecord;
    }
    
    private static String ConverUserObjectToLine(clsUser User) {
    	return ConverUserObjectToLine(User, "#//#");
    }
    
    
    private static ArrayList<clsUser> LoadUsersDataFromFile() {
        ArrayList<clsUser> vUser = new ArrayList<>();

        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\Users.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { 
                	clsUser client = ConvertLinetoUserObject(line);
                	vUser.add(client);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: "+ fileName);
            System.out.println(e.getMessage());
        }

        return vUser;
    }
    
    private static void SaveUsersDataToFile(ArrayList<clsUser> users) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\Users.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (clsUser user : users) {
                if (user.Mode != enMode.EmptyMode) {
                    String line = ConverUserObjectToLine(user);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    private void update() {
        ArrayList<clsUser> users = LoadUsersDataFromFile();

        for (int i = 0; i < users.size(); i++) {
            clsUser user = users.get(i);
            if (user.UserName.equals(this.UserName)) {
            	users.set(i, this);
                break; 
            }
        }
        SaveUsersDataToFile(users);
    }
    
    private void AddNew() {
        AddDataLineToFile(ConverUserObjectToLine(this));
    }
    
    private static void AddDataLineToFile(String dataLine) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\Users.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(dataLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error adding the line to the file: " + e.getMessage());
        }
    }
    
    private static clsUser GetEmptyUserObject()
    {
        return new  clsUser(enMode.EmptyMode, "", "", "", "", "", "", 0);
    }
    
    public enum enPermissions {
    	eAll(-1),
        pListClients(1),
        pAddNewClient(2),
        pDeleteClient(4),
        pUpdateClients(8),
        pFindClient(16),
        pTranactions(32),
        pManageUsers(64),
        pFullAccess(-1);

        private final int value;
        enPermissions(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
    public int permissions;
    
    public clsUser(enMode mode, String FirstName, String LastName, String email, String phone, 
            String UserName, String Password, int Permissions) {
	super(FirstName, LastName, email, phone);
	this.Mode = mode;
	this.UserName = UserName;
	this.Password = Password;
	this.Permissions = Permissions;
    }
    
    public boolean IsEmpty()
    {
        return (Mode == enMode.EmptyMode);
    }
    
    public boolean MarkedForDeleted()
    {
        return MarkedForDelete;
    }
    
    public String GetUserName()
    {
        return UserName;
    }

    public void SetUserName(String UserName)
    {
        this.UserName = UserName;
    }
    
    public void SetPassword(String Password)
    {
        this.Password = Password;
    }

    public String GetPassword()
    {
        return Password;
    }
    
    
    public void SetPermissions(int Permissions)
    {
        this.Permissions = Permissions;
    }

    public int GetPermissions()
    {
        return this.Permissions;
    }
    
    public static clsUser find(String UserName) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\Users.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                clsUser user = ConvertLinetoUserObject(line);

                if (user.UserName.equals(UserName)) {
                    return user;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
        return GetEmptyUserObject();
    }
    
    public static clsUser find(String UserName, String Password) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\Users.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                clsUser user = ConvertLinetoUserObject(line);

                if (user.UserName.equals(UserName) &&
                	user.Password.equals(Password)) {
                    return user;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
        return GetEmptyUserObject();
    }
    
    enum enSaveResults { svFaildEmptyObject, svSucceeded, svFaildUserExists };
    
    public enSaveResults Save() {
    	switch(Mode) {
    	case EmptyMode:
    		return enSaveResults.svFaildEmptyObject;
    	case UpdateMode:{
    		update();
    		return enSaveResults.svSucceeded;
    		}
    	case AddNewMode:{
    		if(clsUser.IsUserExist(UserName))
    			return enSaveResults.svFaildUserExists;
    		else {
    			AddNew();
    			Mode = enMode.UpdateMode;
    			return enSaveResults.svSucceeded;
    		}
    	}
    	default:
            return enSaveResults.svFaildEmptyObject;
    	}
    }
    
    public static boolean IsUserExist(String UserName)
    {

        clsUser User = clsUser.find(UserName);
        return (!User.IsEmpty());
    }
    
    public boolean delete() {
        ArrayList<clsUser> users = LoadUsersDataFromFile();

        for (int i = 0; i < users.size(); i++) {
        	clsUser c = users.get(i);
            if (c.UserName.equals(this.UserName)) {
            	users.remove(i); 
                break;
            }
        }

        SaveUsersDataToFile(users);
        
        this.Mode = enMode.EmptyMode;
        this.SetFirstName(" ");
        this.SetLastName("");
        this.SetEmail("");
        this.SetPhone("");
        this.UserName = "";
        this.Password = "";
        this.Permissions = 0;
        
        return true;
    }
    
    public static clsUser getAddNewUserObject(String UserName) {
        return new clsUser(
            enMode.AddNewMode, "", "", "", "", UserName, "", 0 
        );
    }
    
    public static ArrayList<clsUser> getUsersList() {
        return LoadUsersDataFromFile();
    }
    
    public boolean checkAccessPermission(enPermissions permission) {
        if (this.permissions == enPermissions.eAll.getValue()) {
            return true;
        }

        if ((permission.getValue() & this.permissions) == permission.getValue()) {
            return true;
        } else {
            return false;
        }
    }
    
    protected static void drawAccessDeniedMessage() {
        System.out.println("\t\t\t\t\t______________________________________");
        System.out.println("\n\n\t\t\t\t\t  Access Denied! Contact your Admin.");
        System.out.println("\n\t\t\t\t\t______________________________________\n\n");
    }
}
