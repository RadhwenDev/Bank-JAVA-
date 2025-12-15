package Bank;

import java.util.ArrayList;

public class clsString {

	
	private String value;
	
	public clsString()
    {
       this.value = "";
    }
	
	public clsString(String value)
    {
        this.value = value;
    }
	
	public void SetValue(String value) {
		this.value = value;
    }

    String GetValue() {
        return value;
    }
    
    public static int Length(String S1)
    {
        return S1.length();
    };
    public int Length()
    {
    	return value.length();
    };
    
    public static int CountWordInString(String s, String delim) {
		int pos = 0;
		int count = 0;
		while((pos = s.indexOf(delim)) != -1) {
			count++;
			s = s.substring(pos + delim.length(), s.length());
		}
		if(s != "")
			count++;
		return count;
	}
    public int CountWordInString() {
    	return CountWordInString(value, " ");
    }
    
    public static String UpperFirstLetterOfEachWord(String s) {
		boolean isFirstLetter = true;
		String sT = "";
		char c;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && isFirstLetter) {
				c = s.charAt(i);
				sT += Character.toUpperCase(c);
			}
			else sT += s.charAt(i);
			isFirstLetter = (s.charAt(i) == ' ' ? true : false);
		}
		return sT;
	}
    void UpperFirstLetterOfEachWord() {
    	value = UpperFirstLetterOfEachWord(value);
    }
    
    public static String LowerFirstLetterOfEachWord(String s) {
    	boolean isFirstLetter = true;
    	String sT = "";
    	char c;
    	for(int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) != ' ' && isFirstLetter) {
    			c = s.charAt(i);
    			sT += Character.toLowerCase(c);
    		}
    		else sT += s.charAt(i);
    		isFirstLetter = (s.charAt(i) == ' ' ? true : false);
    	}
    	return sT;
    }
    public void LowerFirstLetterOfEachWord() {
    	value = LowerFirstLetterOfEachWord(value);
    }
    
    public static String UpperAllString(String s) {
		String sT = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				c = s.charAt(i);
				sT += Character.toUpperCase(c);
			}
			else sT += ' ';
		}
		return sT;
	}
    
    public void  UpperAllString()
    {
        value = UpperAllString(value);
    }
    
    public static String LowerAllString(String s) {
		String sT = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				c = s.charAt(i);
				sT += Character.toLowerCase(c);
			}
			else sT += ' ';
		}
		return sT;
	}
    void  LowerAllString()
    {
        value = LowerAllString(value);
    }
	
	public static char InvertLetterCase(char c) {
		return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
	}
	
	public static String InvertAllLettersCase(String s) {
		String sT = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				c = InvertLetterCase(s.charAt(i));
				sT += c;
			}
			else sT += s.charAt(i);
		}
		return sT;
	}
	
	public void InvertAllLettersCase() {
		value = InvertAllLettersCase(value);
	}
	
	public enum enWhatToCount { SmallLetters , CapitalLetters , All};
	
	public static int CountLetter(String s, enWhatToCount WhatToCount) {
		if (WhatToCount == enWhatToCount.All)
			return s.length();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(WhatToCount == enWhatToCount.CapitalLetters && Character.isUpperCase(s.charAt(i)))
				count++;
			if(WhatToCount == enWhatToCount.SmallLetters && Character.isLowerCase(s.charAt(i)))
				count++;
		}
		return count;
	}
	
	public static int CountCapitalLetters(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i)))
				count++;
		}
		return count;
	}
	public int CountCapitalLetters() {
		return CountCapitalLetters(value);
	}
	
	public static int CountSmallLetters(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if(Character.isLowerCase(s.charAt(i)))
				count++;
		}
		return count;
	}
	public int CountSmallLetters() {
		return CountSmallLetters(value);
	}
	
	public static int CountSpecificLetter(String s, char c, boolean MatchCase) {
		int count = 0;
		for (int i = 0; i < s.length(); i++){
			if(MatchCase)
				if (s.charAt(i) == c)
					count++;
			else
				if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(c))
					count++;
		}
		return count;
	}
	public int CountSpecificLetter(char c, boolean MatchCase) {
		return CountSpecificLetter(value, c, MatchCase);
	}
	
	public static boolean IsVowel(char c) {
		c = Character.toLowerCase(c);
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
	
	public static int CountVowels(String S1)
	  {
	      short Counter = 0;

	      for (short i = 0; i < S1.length(); i++)
	      {
	          if (IsVowel(S1.charAt(i)))
	              Counter++;
	      }
	      return Counter;
	  }
	public int CountVowels() {
		return CountVowels(value);
	}
	
	public static ArrayList Split(String s, String delim) {
		ArrayList<String> words = new ArrayList<>();
		int pos = 0;
		while((pos = s.indexOf(delim)) != -1) {
			words.add(s.substring(0, pos));
			s = s.substring(pos + delim.length(), s.length());
		}
		if (s != "")
			words.add(s);
		return words;
	}
	public ArrayList Split(String delim) {
		return Split(value, delim);
	}
	
	public static String TrimLeft(String s, String delim) {
		for (int i = 0; i < s.length(); i++)
		{
			if (delim.indexOf(s.charAt(i)) == -1)
				return s.substring(i);
		}
		return "";
	}
	public void TrimLeft(String delim) {
		value = TrimLeft(value, delim);
	}
	
	public static String TrimRight(String s, String delim) {
		for (int i = s.length() - 1; i >= 0; i--)
		{
			if (delim.indexOf(s.charAt(i)) == -1)
				return s.substring(0, i + 1);
		}
		return "";
	}
	public void TrimRight(String delim) {
		value = TrimRight(value, delim);
	}
	
	public static String Trim(String s, String delim) {
		s = TrimLeft(s, delim);
		s = TrimRight(s, delim);
		return s;
	}
	public void Trim(String delim) {
		value = Trim(value, delim);
	}
	
	public static String join(ArrayList<String> words, String delim) {
		String s = "";
		for (String S: words) {
			s += S + delim;
		}
		return s.substring(0, s.length() - delim.length());
	}
	
	public static String join(String[] words, int len, String delim) {
		String s = "";
		for (int i = 0; i < len; i++) {
			s += words[i] + delim;
		}
		return s.substring(0, s.length() - delim.length());
	}
	
	public static String ReverseWordsInString(String s, String delim) {
		return join(Split(s, delim), delim);
	}
	public void ReverseWordsInString(String delim) {
		value = ReverseWordsInString(value, delim);
	}
	
	public static String ReplaceWord(String a, String toReplace, String ReplaceTo, String delim, boolean MatchCase) {
		ArrayList<String> words = new ArrayList<>();
		words = Split(a, delim);
		String s = "";
		String lowtoReplace = toReplace.toLowerCase();
		for (String S : words) {
			if (MatchCase) {
				if (S.toLowerCase().equals(lowtoReplace))
					s += delim + ReplaceTo;
				else
					s += delim + S;
			}
			else
				s += delim + S;
		}
		return s.substring(delim.length());
	}
	public String ReplaceWord(String toReplace, String ReplaceTo, String delim, boolean MatchCase) {
		return ReplaceWord(value, toReplace, ReplaceTo, delim, MatchCase);
	}
	
	public static String RemovePunctuations(String s) {
	    if (s == null || s.isEmpty()) return "";
	    return s.replaceAll("[\\p{Punct}&&[^']]", "");
	}
	public void RemovePunctuations() {
		value = RemovePunctuations(value);
	}
	
}
