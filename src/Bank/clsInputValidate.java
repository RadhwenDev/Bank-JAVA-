package Bank;

import java.util.Scanner;

public class clsInputValidate {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static boolean IsNumberBetween(short Number, short From, short To) {
		if (Number >= From && Number <= To)
			return true;
		else
			return false;
	}
	
	public static boolean IsNumberBetween(int Number, int From, int To) {
		if (Number >= From && Number <= To)
			return true;
		else
			return false;
	}
	
	public static boolean IsNumberBetween(float Number, float From, float To) {
		if (Number >= From && Number <= To)
			return true;
		else
			return false;
	}
	
	public static boolean IsNumberBetween(double Number, double From, double To) {
		if (Number >= From && Number <= To)
			return true;
		else
			return false;
	}
	
	public static boolean IsDateBetween(clsTime Date, clsTime From, clsTime To) {
		if((clsTime.isDate1AfterDate2(Date, From) || clsTime.isDate1EqualDate2(Date, From)) && clsTime.isDate1BeforeDate2(Date, To) || clsTime.isDate1EqualDate2(Date, To))
			return true;
		if((clsTime.isDate1AfterDate2(Date, To) || clsTime.isDate1EqualDate2(Date, To)) && clsTime.isDate1BeforeDate2(Date, From) || clsTime.isDate1EqualDate2(Date, From))
			return true;
		return false;
	}
	
	public static int readIntNumber(String errorMessage) {
        int number;

        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                return number;
            } else {
                System.out.print(errorMessage);
                scanner.nextLine(); 
            }
        }
    }
	
	public static int readIntNumber() {
        return readIntNumber("Invalid Number, Enter again\n");
    }
	
	public static int readIntNumberBetween(int from, int to, String errorMessage) {
        int number = readIntNumber();  

        while (!IsNumberBetween(number, from, to)) {
            System.out.print(errorMessage);
            number = readIntNumber();
        }
        return number;
    }

    public static int readIntNumberBetween(int from, int to) {
        return readIntNumberBetween(from, to, "Number is not within range, Enter again:\n");
    }
    
    public static float readFloatNumber(String errorMessage) {
        while (true) {
            if (scanner.hasNextFloat()) {
                float number = scanner.nextFloat();
                scanner.nextLine(); 
                return number;
            } else {
                System.out.print(errorMessage);
                scanner.nextLine(); 
            }
        }
    }

    public static float readFloatNumber() {
        return readFloatNumber("Invalid Number, Enter again\n");
    }

    public static float readFloatNumberBetween(float from, float to, String errorMessage) {
        float number = readFloatNumber();

        while (!IsNumberBetween(number, from, to)) {
            System.out.print(errorMessage);
            number = readFloatNumber();
        }
        return number;
    }

    public static float readFloatNumberBetween(float from, float to) {
        return readFloatNumberBetween(from, to, "Number is not within range, Enter again:\n");
    }
	
    public static double readDblNumber(String errorMessage) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double num = scanner.nextDouble();
                scanner.nextLine();
                return num;
            } else {
                System.out.print(errorMessage);
                scanner.nextLine();
            }
        }
    }

    public static double readDblNumber() {
        return readDblNumber("Invalid Number, Enter again\n");
    }
    
    public static double readDblNumberBetween(double from, double to, String errorMessage) {
        double number = readDblNumber();

        while (!IsNumberBetween(number, from, to)) {
            System.out.print(errorMessage);
            number = readDblNumber();
        }
        return number;
    }

    public static double readDblNumberBetween(double from, double to) {
        return readDblNumberBetween(from, to, "Number is not within range, Enter again:\n");
    }
    
    public static boolean isValidDate(clsTime date) {
        return clsTime.isValidDate(date);  
    }
    
    public static String readString() {
    	return scanner.nextLine().trim();
    }
}
