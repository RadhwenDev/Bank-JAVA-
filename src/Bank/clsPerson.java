package Bank;

public class clsPerson {

	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;
	
	public clsPerson(String FirstName, String LastName, String Email, String Phone){  
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Phone = Phone;
    }
	
	public void SetFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String GetFirstName()
    {
        return this.FirstName;
    }
    
    public void SetLastName(String LastName)
    {
        this.LastName = LastName;
    }

    public String GetLastName()
    {
        return this.LastName;
    }
    
    public void SetEmail(String Email)
    {
        this.Email = Email;
    }

    public String GetEmail()
    {
        return this.Email;
    }
    
    public void SetPhone(String Phone)
    {
        this.Phone = Phone;
    }

    public String GetPhone()
    {
        return this.Phone;
    }
    
    public String FullName()
    {
        return FirstName + " " + LastName;
    }

    public void Print()
    {
    	System.out.print("\nInfo:");
    	System.out.print("\n___________________");
    	System.out.print("\nFirstName: ");
    	System.out.print("\nLastName : ");
    	System.out.print("\nFull Name: ");
    	System.out.print("\nEmail    : ");
    	System.out.print("\nPhone    : ");
    	System.out.print("\n___________________\n");
    }
}
