package Bank;

import java.time.LocalDate;
import java.util.ArrayList;

public class clsTime {
	private short Day = 1;
	private short Month = 1;
	private short Year = 1900;
	
	public clsTime(){
		LocalDate now = LocalDate.now();
		this.Day   = (short)now.getDayOfMonth();
		this.Month = (short)now.getMonthValue();
		this.Year  = (short)now.getYear();
	}
	
	
	public clsTime(String sTime){
		ArrayList<String> vTime = new ArrayList<>();
		vTime = clsString.Split(sTime, "/");
		this.Day = (short)Integer.parseInt(vTime.get(0));
		this.Month = (short)Integer.parseInt(vTime.get(1));
		this.Year = (short)Integer.parseInt(vTime.get(2));
	}
	
	clsTime(short Day, short Month, short Year){
		this.Day = Day;
		this.Month = Month;
		this.Year = Year;
	}
	
	clsTime(short DateOrderInYear, short Year){
		clsTime Date1 = GetDateFromDayOrderInYear(DateOrderInYear, Year);
	    Day = Date1.Day;
		Month = Date1.Month;
		Year = Date1.Year;
	}
	
	public void SetDay(short Day) {
		this.Day = Day;
	}

	public short GetDay() {
		return this.Day;
	}
	
	public void SetMonth(short Month) {
		this.Month = Month;
	}

	public short GetMonth() {
		return this.Month;
	}
	
	public void SetYear(short Year) {
		this.Year = Year;
	}

	public short GetYear() {
		return this.Year;
	}
	
	public static String DateToString(clsTime Time) {
		return Time.Day + "/" + Time.Month + "/" + Time.Year;
	}
	public String DateToString() {
		return DateToString(this);
	}
	
	public static clsTime getSystemDate() {
        LocalDate now = LocalDate.now();
        
        return new clsTime(
        	(short)now.getDayOfMonth(),
        	(short)now.getMonthValue(),
        	(short)now.getYear()
        );
    }
	
	public static boolean isValidDate(clsTime Time) {
	    if (Time.Day < 1 || Time.Day > 31) return false;
	    if (Time.Month < 1 || Time.Month > 12) return false;

	    if (Time.Month == 2) {
	        if (isLeapYear(Time.Year)) {
	            if (Time.Day > 29) return false;
	        } else {
	            if (Time.Day > 28) return false;
	        }
	    }

	    int daysInMonth = NumberOfDaysInMonth(Time.Year, Time.Month);
	    if (Time.Day > daysInMonth) return false;

	    return true;
	}
	public boolean isValid() {
	    return isValidDate(this);
	}
	
	public static boolean isLeapYear(short Year) {
		return (Year % 400 == 0) || (Year % 4 == 0 && Year % 100 != 0);
	}
	public boolean isLeapYear()
	{
		return isLeapYear(this.Year);
	}
	
	public static int NumberOfDaysInYear(short Year) {
		return (isLeapYear(Year) ? 366 : 365);
	}
	public int NumberOfDaysInYear() {
		return NumberOfDaysInYear(this.Year);
	}
	
	public static int NumberOfHoursInAYear(short Year)
	{
		return  NumberOfDaysInYear(Year) * 24;
	}

	public int NumberOfHoursInAYear()
	{
		return  NumberOfHoursInAYear(Year);
	}

	public static int NumberOfMinutesInAYear(short Year)
	{
		return  NumberOfHoursInAYear(Year) * 60;
	}

	public int NumberOfMinutesInAYear()
	{
		return  NumberOfMinutesInAYear(Year);
	}

	public static int NumberOfSecondsInAYear(short Year)
	{
		return  NumberOfMinutesInAYear(Year) * 60;
	}

	public int NumberOfSecondsInAYear()
	{
		return  NumberOfSecondsInAYear();
	}
	
	public static short NumberOfDaysInMonth(short Year, short Month) {
		if (Month < 1 || Month > 12)
			return 0;
		short[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		return (short)((Month == 2) ? (isLeapYear(Year) ? 29 : 28) : days[Month - 1]);
	}
	public short NumberOfDaysInMonth()
	{
		return NumberOfDaysInMonth(Year, Month);
	}
	
	public static short NumberOfHoursInAMonth(short Month, short Year)
	{
		return  (short)(NumberOfDaysInMonth(Year, Month) * 24);
	}

	public short NumberOfHoursInAMonth()
	{
		return  (short)(NumberOfDaysInMonth(Year, Month) * 24);
	}

	public static int NumberOfMinutesInAMonth(short Month, short Year)
	{
		return  NumberOfHoursInAMonth(Year, Month) * 60;
	}

	public int NumberOfMinutesInAMonth()
	{
		return  NumberOfHoursInAMonth(Year, Month) * 60;
	}

	public static int NumberOfSecondsInAMonth(short Month, short Year)
	{
		return  NumberOfMinutesInAMonth(Year, Month) * 60;
	}

	public int NumberOfSecondsInAMonth()
	{
		return  NumberOfMinutesInAMonth(Year, Month) * 60;
	}
	
	public static short DayOfWeekOrder(short Year, short Month, short Day) {
		byte a = (byte)((14 - Month) / 12);
		short y = (short)(Year - a);
		short m = (short)(Month + 12 * a - 2);
		return (short)((Day + y + (y / 4) - (y / 100) + (y / 400) + (31 * m / 12)) % 7);
	}
	public short DayOfWeekOrder()
	{
		return DayOfWeekOrder(Year, Month, Day);
	}
	
	public static String NameOfDay(short Year, short Month, short Day) {
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		return days[DayOfWeekOrder(Year, Month, Day)];
	}
	public String NameOfDay() {
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		return days[DayOfWeekOrder(Year, Month, Day)];
	}
	
	public static String NameOfMonths(short Month) {
		String[] days = {"Jan", "Feb", "Mar", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		return days[Month - 1];
	}
	public String NameOfMonths() {
		return NameOfMonths(Month);
	}
	
	public static String Space(short d, boolean flag) {
		String s = "  ";
		if (flag)
			for (int i = 0; i < d; i++) {
				s += "     ";
			}
		else
			s = "    ";
		return s;
	}
	
	public static void PrintMonthCalendar(short Year, short Month) {
		System.out.println("\n______________" + NameOfMonths(Month) + "________________");
		System.out.println("\nSun  Mon  Tue  Wed  Thu  Fri  Sat");
		short n = NumberOfDaysInMonth(Year, Month);
		short d = DayOfWeekOrder(Year, Month, (short)1);
		System.out.print(Space(d, true));
		for (int i = 1; i <= n; i++) {
			System.out.print(i);
			if(i >= 9)
				System.out.print(Space(d, false).substring(1));
			else
				System.out.print(Space(d, false));
			if ((d + i) % 7 == 0) {
				if(i >= 9)
					System.out.print("\n ");
				else
					System.out.print("\n  ");
			}	
		}
		if ((d + n) % 7 != 0)
			System.out.println();
		System.out.println("_________________________________");
	}
	void PrintMonthCalendar() {
		PrintMonthCalendar(Year, Month);
	}
	
	public static void PrintYearCalendar(short Year) {
		System.out.println("\n_________________________________");
		System.out.print("\n         Calendar - " + Year);		
		System.out.println("\n_________________________________");
		for (int i = 1; i <= 12; i++) {
			PrintMonthCalendar(Year, (short)i);
		}
	}
	public void PrintYearCalendar() {
		PrintYearCalendar(Year);
	}
	
	public static short DaysFromBeginningOfYear(short Year, short Month, short Day) {
		short sum = 0;
		for (short i = 1; i < Month; i++) {
			sum += NumberOfDaysInMonth(Year, (short)i);
		}
		return (short)(sum + Day);
	}
	public short DaysFromBeginningOfYear() {
		return DaysFromBeginningOfYear(this.Year, this.Month, this.Day);
	}
	
	public static String getDayMonth(int totalDays, short year) {
        int sum = 0;
        short currentMonth = 1;

        while (sum + NumberOfDaysInMonth(year, currentMonth) < totalDays) {
            sum += NumberOfDaysInMonth(year, currentMonth);
            currentMonth++;
        }

        int day = totalDays - sum;
        return String.format("%02d/%02d", day, currentMonth);
    }

	public static String dateFromDayOfYear(int totalDays, short year) {
        return getDayMonth(totalDays, year) + "/" + year;
    }
	
	static clsTime GetDateFromDayOrderInYear(short DateOrderInYear, short year)
	{
		LocalDate date = LocalDate.ofYearDay(year, DateOrderInYear);
        return new clsTime(
        	(short)date.getDayOfMonth(),
        	(short)date.getMonthValue(),
        	(short)date.getYear()
        );
	}
	public void addDays(int days) {
	    int remainingDays = days + DaysFromBeginningOfYear(this.Year, this.Month, this.Day);
	    this.Month = 1;

	    while (true) {
	        int monthDays = NumberOfDaysInMonth(this.Year, this.Month);

	        if (remainingDays > monthDays) {
	            remainingDays -= monthDays;
	            this.Month++;
	            if (this.Month > 12) {
	                this.Month = 1;
	                this.Year++;
	            }
	        } else {
	            this.Day = (short)remainingDays;
	            break;
	        }
	    }
	}
	
	public static boolean isDate1BeforeDate2(clsTime date1, clsTime date2) {
        if (date1.Year < date2.Year) return true;
        if (date1.Year > date2.Year) return false;
        if (date1.Month < date2.Month) return true;
        if (date1.Month > date2.Month) return false;
        return date1.Day < date2.Day;
    }
	public boolean isDateBeforeDate2(clsTime date2) {
        return isDate1BeforeDate2(this, date2);
    }
	
	public static boolean isDate1EqualDate2(clsTime date1, clsTime date2) {
        return date1.Year == date2.Year &&
               date1.Month == date2.Month &&
               date1.Day == date2.Day;
    }

    public boolean isDateEqualDate2(clsTime date2) {
        return isDate1EqualDate2(this, date2);
    }

    public static boolean isLastDayInMonth(clsTime date) {
        return date.Day == NumberOfDaysInMonth(date.Month, date.Year);
    }

    public boolean isLastDayInMonth() {
        return isLastDayInMonth(this);
    }
    
    public static boolean isLastMonthInYear(int month) {
        return (month == 12);
    }

    public static clsTime addOneDay(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year); 

        if (isLastDayInMonth(newDate)) {
            if (isLastMonthInYear(newDate.Month)) {
                newDate.Month = 1;
                newDate.Day = 1;
                newDate.Year++;
            } else {
                newDate.Day = 1;
                newDate.Month++;
            }
        } else {
            newDate.Day++;
        }

        return newDate;
    }


    public void addOneDay() {
    	clsTime temp = addOneDay(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }

    public static void swapDates(clsTime date1, clsTime date2) {
        short tempDay = date1.Day;
        short tempMonth = date1.Month;
        short tempYear = date1.Year;

        date1.Day = date2.Day;
        date1.Month = date2.Month;
        date1.Year = date2.Year;

        date2.Day = tempDay;
        date2.Month = tempMonth;
        date2.Year = tempYear;
    }
    
    public static int getDifferenceInDays(clsTime date1, clsTime date2, boolean includeEndDay) {
        int days = 0;
        int swapFlagValue = 1;

        clsTime d1 = new clsTime(date1.Day, date1.Month, date1.Year);
        clsTime d2 = new clsTime(date2.Day, date2.Month, date2.Year);

        if (!isDate1BeforeDate2(d1, d2)) {
            swapDates(d1, d2);
            swapFlagValue = -1;
        }

        while (isDate1BeforeDate2(d1, d2)) {
            days++;
            d1 = addOneDay(d1);
        }

        if (includeEndDay) {
            days++;
        }

        return days * swapFlagValue;
    }
    
    public int getDifferenceInDays(clsTime date2, boolean includeEndDay) {
        return getDifferenceInDays(this, date2, includeEndDay);
    }
    
    public static int calculateMyAgeInDays(clsTime dateOfBirth) {
        return getDifferenceInDays(dateOfBirth, getSystemDate(), true);
    }
    
    public static clsTime increaseDateByOneWeek(clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= 7; i++) {
            result = addOneDay(result);
        }

        return result;
    }
    
    public void increaseDateByOneWeek() {
    	clsTime temp = increaseDateByOneWeek(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime increaseDateByXWeeks(int weeks, clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= weeks; i++) {
            result = increaseDateByOneWeek(result);
        }
        return result;
    }

    public void increaseDateByXWeeks(int weeks) {
    	clsTime temp = increaseDateByXWeeks(weeks, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }

    public static clsTime increaseDateByOneMonth(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);

        if (newDate.Month == 12) {
            newDate.Month = 1;
            newDate.Year++;
        } else {
            newDate.Month++;
        }

        int daysInCurrentMonth = NumberOfDaysInMonth(newDate.Month, newDate.Year);
        if (newDate.Day > daysInCurrentMonth) {
            newDate.Day = (short)daysInCurrentMonth;
        }

        return newDate;
    }


    public void increaseDateByOneMonth() {
    	clsTime temp = increaseDateByOneMonth(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }

    public static clsTime increaseDateByXDays(int days, clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= days; i++) {
            result = addOneDay(result);
        }
        return result;
    }

    public void increaseDateByXDays(int days) {
    	clsTime temp = increaseDateByXDays(days, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }

    public static clsTime increaseDateByXMonths(short months, clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= months; i++) {
            result = increaseDateByOneMonth(result);
        }
        return result;
    }

    public void increaseDateByXMonths(short months) {
    	clsTime temp = increaseDateByXMonths(months, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime increaseDateByOneYear(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year++;
        return newDate;
    }

    public void increaseDateByOneYear() {
    	clsTime temp = increaseDateByOneYear(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime increaseDateByXYears(int years, clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year += years;
        return newDate;
    }

    public void increaseDateByXYears(int years) {
    	clsTime temp = increaseDateByXYears(years, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    
    public static clsTime increaseDateByOneDecade(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year += 10;
        return newDate;
    }

    public void increaseDateByOneDecade() {
    	clsTime temp = increaseDateByOneDecade(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime increaseDateByXDecades(int decades, clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year += decades * 10;
        return newDate;
    }

    public void increaseDateByXDecades(int decades) {
    	clsTime temp = increaseDateByXDecades(decades, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime increaseDateByOneCentury(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year += 100;
        return newDate;
    }

    public void increaseDateByOneCentury() {
    	clsTime temp = increaseDateByOneCentury(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime increaseDateByOneMillennium(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year += 1000;
        return newDate;
    }

    public void increaseDateByOneMillennium() {
    	clsTime temp = increaseDateByOneMillennium(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByOneDay(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);

        if (newDate.Day == 1) {
            if (newDate.Month == 1) {
                newDate.Month = 12;
                newDate.Day = 31;
                newDate.Year--;
            } else {
                newDate.Month--;
                newDate.Day = NumberOfDaysInMonth(newDate.Month, newDate.Year);
            }
        } else {
            newDate.Day--;
        }

        return newDate;
    }

    public void decreaseDateByOneDay() {
    	clsTime temp = decreaseDateByOneDay(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByOneWeek(clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= 7; i++) {
            result = decreaseDateByOneDay(result);
        }

        return result;
    }

    public void decreaseDateByOneWeek() {
    	clsTime temp = decreaseDateByOneWeek(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByXWeeks(int weeks, clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= weeks; i++) {
            result = decreaseDateByOneWeek(result);
        }

        return result;
    }

    public void decreaseDateByXWeeks(int weeks) {
    	clsTime temp = decreaseDateByXWeeks(weeks, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByOneMonth(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);

        if (newDate.Month == 1) {
            newDate.Month = 12;
            newDate.Year--;
        } else {
            newDate.Month--;
        }

        short daysInCurrentMonth = NumberOfDaysInMonth(newDate.Month, newDate.Year);
        if (newDate.Day > daysInCurrentMonth) {
            newDate.Day = daysInCurrentMonth;
        }

        return newDate;
    }

    public void decreaseDateByOneMonth() {
    	clsTime temp = decreaseDateByOneMonth(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByXDays(int days, clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= days; i++) {
            result = decreaseDateByOneDay(result);
        }

        return result;
    }

    public void decreaseDateByXDays(short days) {
    	clsTime temp = decreaseDateByXDays(days, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByXMonths(short months, clsTime date) {
    	clsTime result = new clsTime(date.Day, date.Month, date.Year);

        for (int i = 1; i <= months; i++) {
            result = decreaseDateByOneMonth(result);
        }

        return result;
    }

    public void decreaseDateByXMonths(short months) {
    	clsTime temp = decreaseDateByXMonths(months, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
	
    public static clsTime decreaseDateByOneYear(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year--;
        return newDate;
    }

    public void decreaseDateByOneYear() {
    	clsTime temp = decreaseDateByOneYear(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByXYears(int years, clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year -= years;
        return newDate;
    }

    public void decreaseDateByXYears(int years) {
    	clsTime temp = decreaseDateByXYears(years, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByOneDecade(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year -= 10;
        return newDate;
    }

    public void decreaseDateByOneDecade() {
    	clsTime temp = decreaseDateByOneDecade(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByXDecades(int decades, clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year -= decades * 10;
        return newDate;
    }

    public void decreaseDateByXDecades(int decades) {
    	clsTime temp = decreaseDateByXDecades(decades, this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByOneCentury(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year -= 100;
        return newDate;
    }

    public void decreaseDateByOneCentury() {
    	clsTime temp = decreaseDateByOneCentury(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static clsTime decreaseDateByOneMillennium(clsTime date) {
    	clsTime newDate = new clsTime(date.Day, date.Month, date.Year);
        newDate.Year -= 1000;
        return newDate;
    }

    public void decreaseDateByOneMillennium() {
    	clsTime temp = decreaseDateByOneMillennium(this);
        this.Day = temp.Day;
        this.Month = temp.Month;
        this.Year = temp.Year;
    }
    
    public static boolean isEndOfWeek(clsTime date) {
        return DayOfWeekOrder(date.Day, date.Month, date.Year) == 6;
    }

    public boolean isEndOfWeek() {
        return isEndOfWeek(this);
    }
    
    public static boolean isWeekEnd(clsTime date) {
        int dayIndex = DayOfWeekOrder(date.Day, date.Month, date.Year);
        return (dayIndex == 5 || dayIndex == 6);
    }

    public boolean isWeekEnd() {
        return isWeekEnd(this);
    }
    
    public static boolean isBusinessDay(clsTime date) {
        return !isWeekEnd(date);
    }

    public boolean isBusinessDay() {
        return isBusinessDay(this);
    }
    
    public static int daysUntilTheEndOfWeek(clsTime date) {
        return 6 - DayOfWeekOrder(date.Day, date.Month, date.Year);
    }

    public int daysUntilTheEndOfWeek() {
        return daysUntilTheEndOfWeek(this);
    }
    
    public static int daysUntilTheEndOfMonth(clsTime date) {
    	clsTime endOfMonthDate = new clsTime(
    		(short)NumberOfDaysInMonth(date.Month, date.Year),
            (short)date.Month,
            (short)date.Year
        );

        return getDifferenceInDays(date, endOfMonthDate, true);
    }

    public int daysUntilTheEndOfMonth() {
        return daysUntilTheEndOfMonth(this);
    }
    
    public static int daysUntilTheEndOfYear(clsTime date) {
    	clsTime endOfYearDate = new clsTime((short)31, (short)12, date.Year);
        return getDifferenceInDays(date, endOfYearDate, true);
    }

    // Version instance
    public int daysUntilTheEndOfYear() {
        return daysUntilTheEndOfYear(this);
    }
    
    public static int calculateBusinessDays(clsTime dateFrom, clsTime dateTo) {
        int days = 0;
        clsTime current = new clsTime(dateFrom.Day, dateFrom.Month, dateFrom.Year);

        while (isDate1BeforeDate2(current, dateTo)) {
            if (isBusinessDay(current)) {
                days++;
            }
            current = addOneDay(current);
        }

        return days;
    }
    
    public static int calculateVacationDays(clsTime dateFrom, clsTime dateTo) {
        return calculateBusinessDays(dateFrom, dateTo);
    }
    
    public static clsTime calculateVacationReturnDate(clsTime dateFrom, int vacationDays) {
    	clsTime current = new clsTime(dateFrom.Day, dateFrom.Month, dateFrom.Year);
        int weekEndCounter = 0;

        for (int i = 1; i <= vacationDays; i++) {
            if (isWeekEnd(current)) {
                weekEndCounter++;
            }
            current = addOneDay(current);
        }

        for (int i = 1; i <= weekEndCounter; i++) {
            current = addOneDay(current);
        }

        return current;
    }
    
    public static boolean isDate1AfterDate2(clsTime date1, clsTime date2) {
        return (!isDate1BeforeDate2(date1, date2) && !isDate1EqualDate2(date1, date2));
    }

    public boolean isDateAfterDate2(clsTime date2) {
        return isDate1AfterDate2(this, date2);
    }
    
    
    enum enDateCompare { Before, Equal, After };
    
    public static enDateCompare compareDates(clsTime date1, clsTime date2) {
        if (isDate1BeforeDate2(date1, date2)) {
            return enDateCompare.Before;
        }

        if (isDate1EqualDate2(date1, date2)) {
            return enDateCompare.Equal;
        }

        return enDateCompare.After;
    }

    // Version instance
    public enDateCompare compareDates(clsTime date2) {
        return compareDates(this, date2);
    }
}
