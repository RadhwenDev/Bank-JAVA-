package Bank;

public class TransferLogRecord {

	public String dateTime;
    public String sourceAccountNumber;
    public String destinationAccountNumber;
    public float amount;
    public float srcBalanceAfter;
    public float destBalanceAfter;
    public String userName;

    public TransferLogRecord(String dateTime, String sourceAccountNumber, String destinationAccountNumber,
                             float amount, float srcBalanceAfter, float destBalanceAfter, String userName) {
        this.dateTime = dateTime;
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
        this.srcBalanceAfter = srcBalanceAfter;
        this.destBalanceAfter = destBalanceAfter;
        this.userName = userName;
    }
	
}
