package Bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class clsBankClient extends clsPerson{

	private enum enMode { EmptyMode, UpdateMode, AddNewMode };
	private enMode Mode;
	
	private String AccountNumber;
    private String PinCode;
    private float AccountBalance;
    boolean _MarkedForDelete = false;
    
    
    public static clsBankClient convertLineToClientObject(String line, String separator) {
        if (separator == null || separator.isEmpty()) {
            separator = "#//#"; 
        }

        ArrayList<String> clientData = new ArrayList<>(Arrays.asList(line.split(java.util.regex.Pattern.quote(separator))));

        return new clsBankClient(
            enMode.UpdateMode,         
            clientData.get(0).trim(),             
            clientData.get(1).trim(),             
            clientData.get(2).trim(),             
            clientData.get(3).trim(),     
            clientData.get(4).trim(),    
            clientData.get(5).trim(),  
            Float.parseFloat(clientData.get(6).trim())
        );
    }
    
    public static clsBankClient convertLineToClientObject(String line) {
        return convertLineToClientObject(line, "#//#");
    }
    
    static clsBankClient _GetEmptyClientObject()
    {
        return new clsBankClient(enMode.EmptyMode, "", "", "", "", "", "", 0.0f);
    }
    
    private clsBankClient(enMode mode, String FirstName, String LastName, String email, String phone, 
            String accountNumber, String pinCode, float accountBalance) {
	super(FirstName, LastName, email, phone);
	this.Mode = mode;
	this.AccountNumber = accountNumber;
	this.PinCode = pinCode;
	this.AccountBalance = accountBalance;
    }
    
    private static String _ConverClientObjectToLine(clsBankClient Client, String Seperator)
    {
        String stClientRecord = "";
        stClientRecord += Client.GetFirstName() + Seperator;
        stClientRecord += Client.GetLastName() + Seperator;
        stClientRecord += Client.GetEmail() + Seperator;
        stClientRecord += Client.GetPhone() + Seperator;
        stClientRecord += Client.AccountNumber() + Seperator;
        stClientRecord += Client.PinCode + Seperator;
        stClientRecord += Client.AccountBalance;
        return stClientRecord;
    }
    
    public static String _ConverClientObjectToLine(clsBankClient Client) {
    	return _ConverClientObjectToLine(Client, "#//#");
    }
    
    public static ArrayList<clsBankClient> loadClientsDataFromFile() {
        ArrayList<clsBankClient> vClients = new ArrayList<>();

        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\src\\Bank\\Clients.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { 
                    clsBankClient client = convertLineToClientObject(line);
                    vClients.add(client);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: "+ fileName);
            System.out.println(e.getMessage());
        }

        return vClients;
    }
    
    private static void saveClientsDataToFile(ArrayList<clsBankClient> clients) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\src\\Bank\\Clients.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (clsBankClient client : clients) {
                if (client.Mode != enMode.EmptyMode) {
                    String line = _ConverClientObjectToLine(client);
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    public void update() {
        ArrayList<clsBankClient> clients = loadClientsDataFromFile();

        for (int i = 0; i < clients.size(); i++) {
            clsBankClient client = clients.get(i);
            if (client.AccountNumber().equals(this.AccountNumber())) {
                clients.set(i, this);
                break; 
            }
        }
        saveClientsDataToFile(clients);
    }
    
    public void AddNew() {
        AddDataLineToFile(_ConverClientObjectToLine(this));
    }
    
    private static void AddDataLineToFile(String dataLine) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\src\\Bank\\Clients.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(dataLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error adding the line to the file: " + e.getMessage());
        }
    }
    
    public boolean IsEmpty()
    {
        return (Mode == enMode.EmptyMode);
    }
    
    public String AccountNumber()
    {
        return AccountNumber;
    }
    
    public void SetPinCode(String PinCode)
    {
        this.PinCode = PinCode;
    }

    public String GetPinCode()
    {
        return PinCode;
    }
    
    public void SetAccountBalance(float AccountBalance)
    {
        this.AccountBalance = AccountBalance;
    }

    public float GetAccountBalance()
    {
        return this.AccountBalance;
    }
    
    public void Print()
    {
    	System.out.print("\nClient Card:");
    	System.out.print("\n___________________");
    	System.out.print("\nFirstName: " + super.GetFirstName());
    	System.out.print("\nLastName : " + super.GetLastName());
    	System.out.print("\nFull Name: " + super.FullName());
    	System.out.print("\nEmail    : " + super.GetEmail());
    	System.out.print("\nPhone    : " + super.GetPhone());
    	System.out.print("\nAcc. Number : " + AccountNumber);
    	System.out.print("\nPassword    : " + PinCode);
    	System.out.print("\nBalance     : " + AccountBalance);
    	System.out.print("\n___________________\n");
    }
    
    public static clsBankClient find(String accountNumber) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\src\\Bank\\Clients.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                clsBankClient client = convertLineToClientObject(line);

                if (client.AccountNumber().equals(accountNumber)) {
                    return client;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
        return _GetEmptyClientObject();
    }
    
    public static clsBankClient find(String accountNumber, String pinCode) {
        String fileName = "C:\\Users\\ASUS\\Desktop\\Bank Java\\Bank\\src\\Bank\\Clients.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                clsBankClient client = convertLineToClientObject(line);

                if (client.AccountNumber().equals(accountNumber) &&
                    client.GetPinCode().equals(pinCode)) {
                    return client;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
        return _GetEmptyClientObject();
    }
    
    enum enSaveResults { svFaildEmptyObject, svSucceeded, svFaildAccountNumberExists };
    
    public enSaveResults Save() {
    	switch(Mode) {
    	case EmptyMode:
    		return enSaveResults.svFaildEmptyObject;
    	case UpdateMode:{
    		update();
    		return enSaveResults.svSucceeded;
    		}
    	case AddNewMode:{
    		if(clsBankClient.IsClientExist(AccountNumber))
    			return enSaveResults.svFaildAccountNumberExists;
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
    
    public static boolean IsClientExist(String AccountNumber) {
    	clsBankClient Client1 = clsBankClient.find(AccountNumber);
    	return (!Client1.IsEmpty());
    }
    
    public boolean delete() {
        ArrayList<clsBankClient> clients = loadClientsDataFromFile();

        for (int i = 0; i < clients.size(); i++) {
            clsBankClient c = clients.get(i);
            if (c.AccountNumber().equals(this.AccountNumber())) {
                clients.remove(i); 
                break;
            }
        }

        saveClientsDataToFile(clients);
        
        this.Mode = enMode.EmptyMode;
        this.SetFirstName(" ");
        this.SetLastName("");
        this.SetEmail("");
        this.SetPhone("");
        this.AccountNumber = "";
        this.PinCode = "";
        this.AccountBalance = 0.0f;
        
        return true;
    }
    
    public static clsBankClient getAddNewClientObject(String accountNumber) {
        return new clsBankClient(
            enMode.AddNewMode, "", "", "", "", accountNumber, "", 0.0f  
        );
    }
    
    public static ArrayList<clsBankClient> getClientsList() {
        return loadClientsDataFromFile();
    }
    
    public static double getTotalBalances() {
        ArrayList<clsBankClient> clients = getClientsList();
        double total = 0.0;

        for (clsBankClient client : clients) {
            total += client.GetAccountBalance();
        }

        return total;
    }

    public void Deposit(double Amount)
    {
        AccountBalance += Amount;
        Save();
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > this.AccountBalance) {
            return false; 
        }

        this.AccountBalance -= amount;
        this.Save();  
        return true;
    }
}
