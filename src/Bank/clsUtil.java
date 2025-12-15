package Bank;

import java.util.Random;
import java.util.Scanner;

public class clsUtil {

	private static final Random random = new Random();
	
	enum enCharType {
        SmallLetter, CapitalLetter,
        Digit, SpecialCharacter, MixChars
    };
	
    public static void srand() {
        random.setSeed(System.currentTimeMillis());
    }
    
    public static int RandomNumber(int from, int to) {
        if (from > to) {
            int temp = from;
            from = to;
            to = temp;
        }
        return random.nextInt(to - from + 1) + from;
    }
    
    public static char GetRandomCharacter(enCharType charType) {
    	if (charType == enCharType.MixChars) {
            int randomType = RandomNumber(1, 3);
            switch (randomType) {
                case 1:
                    charType = enCharType.SmallLetter;
                    break;
                case 2:
                    charType = enCharType.CapitalLetter;
                    break;
                case 3:
                    charType = enCharType.Digit;
                    break;
                default:
                    charType = enCharType.CapitalLetter;
                    break;
            }
        }
    	
    	switch (charType) {
        case SmallLetter:
            return (char) RandomNumber(97, 122);  
        case CapitalLetter:
            return (char) RandomNumber(65, 90);  
        case SpecialCharacter:
            return (char) RandomNumber(33, 47);  
        case Digit:
            return (char) RandomNumber(48, 57);
        default:
            return (char) RandomNumber(65, 90);
    }
    }
    
    public static  String GenerateWord(enCharType CharType, short Length){
        String Word = "";

        for (int i = 1; i <= Length; i++)

        {

            Word += GetRandomCharacter(CharType);

        }
        return Word;
    }
    
    public static String  GenerateKey(enCharType CharType){
        String Key = "";
        Key += GenerateWord(CharType, (short)4) + "-";
        Key += GenerateWord(CharType, (short)4) + "-";
        Key += GenerateWord(CharType, (short)4) + "-";
        Key += GenerateWord(CharType, (short)4);
        return Key;
    }
    
    public static String  GenerateKey() {
    	return GenerateKey(enCharType.CapitalLetter);
    }
    
    public static void GenerateKeys(short NumberOfKeys, enCharType CharType){
    	Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= NumberOfKeys; i++)
        {
        	System.out.print("Key [" + i + "] : ");
        	System.out.println(GenerateKey(CharType));
        }
    }
    
    public static void FillArrayWithRandomNumbers(int[] arr, int arrLength, int From, int To)
    {
        for (int i = 0; i < arrLength; i++)
            arr[i] = RandomNumber(From, To);
    }
    
    public static void FillArrayWithRandomWords(String[] arr, int arrLength, enCharType CharType, short Wordlength)
    {
        for (int i = 0; i < arrLength; i++)
            arr[i] = GenerateWord(CharType, Wordlength);
    }
    
    static void FillArrayWithRandomKeys(String[] arr, int arrLength, enCharType CharType)
    {
        for (int i = 0; i < arrLength; i++)
            arr[i] = GenerateKey(CharType);
    }
    
    public static void Swap(int[] arr, int i, int j) {
    	int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void Swap(double[] arr, int i, int j) {
    	double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void Swap(boolean[] arr, int i, int j) {
        boolean temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void Swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void Swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void Swap(clsTime[] a, clsTime[] b) {
        clsTime.swapDates(a[0], b[0]);
    }
    
    public static  void ShuffleArray(int[] arr, int arrLength){
        for (int i = 0; i < arrLength; i++)
        {
        	int randomIndex1 = RandomNumber(0, arrLength - 1);
        	int randomIndex2 = RandomNumber(0, arrLength - 1);
        	Swap(arr, randomIndex1, randomIndex2);
        }
    }
    
    public static  void ShuffleArray(String [] arr, int arrLength){
        for (int i = 0; i < arrLength; i++)
        {
        	int randomIndex1 = RandomNumber(0, arrLength - 1);
        	int randomIndex2 = RandomNumber(0, arrLength - 1);
        	Swap(arr, randomIndex1, randomIndex2);
        }
    }
    
    public static String Tabs(short NumberOfTabs){
        String t = "";
        for (int i = 1; i < NumberOfTabs; i++)
        {
            t += "\t";
            System.out.print(t);
        }
        return t;
    }
    
    public static String EncryptText(String Text, short EncryptionKey){
    	String s = "";
    	for (char c : Text.toCharArray()) {
    	    s += (char)(c + EncryptionKey);
    	}
    	return s;
    }
    
    public static String DecryptText(String Text, short EncryptionKey){
    	String s = "";
    	for (char c : Text.toCharArray()) {
    	    s += (char)(c - EncryptionKey);
    	}
    	return s;
    }
}
