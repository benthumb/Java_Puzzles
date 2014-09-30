package org.benthumb.tests;

public class AltCalendarSystem {
  
  public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
    FRIDAY, SATURDAY, SUNDAY
  }
  
  public enum Month {
    MONTH_1, MONTH_2, MONTH_3, MONTH_4, MONTH_5, MONTH_6,
    MONTH_7, MONTH_8, MONTH_9, MONTH_10, MONTH_11, MONTH_12, MONTH_13 
  }
 
  int fYearsElasped = 0;
  static int fNumberOfLeapYears = 0;
  static int fNumberOfDecades = 0;
  static int fNumberOfDaysElapsed = 0;
  static int fDay = 0;
  static int fMonth = 0;
  static int fYear = 0;
  
  static final int NUMBER_WEEKDAYS_SHIFTED_LEAP_YEAR = 7;
  static final int NUMBER_WEEKDAYS_SHIFTED_STANDARD_YEAR = 6;
  static final int YEAR_ONE = 1900;

  public AltCalendarSystem() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    Day day;
    // TODO Auto-generated method stub
    
    //    year | 5  => 13th month @ 21 days (leap year)
    //  !(year | 5) => 13th month @ 22 days
    //   month | 2  => month @ 21 days (even months)
    // !(month | 2) => month @ 22 days (odd months)
    
    // input day, month, year 
    
    setMonth(args[0]);
    setDay(args[1]);
    setYear(args[2]);
    setNumberOfLeapYears(fYear);
    int elapsedTime = fYear == YEAR_ONE ? 0 : (fYear - YEAR_ONE) - 1;
    setfNumberOfDaysElapsed(elapsedTime); // all years in between minus last

    System.out.println("First day of the week: " + Day.MONDAY);
    if( Day.FRIDAY.ordinal() == (30 % 26)){
      System.out.println("We're into following weekday based on modulus calculation: " + Day.FRIDAY);
    }else{
      System.out.println("Fail!");
      System.out.println("Friday's place in the universe: " + Day.FRIDAY.ordinal());
    }
  }
  
  private static void setNumberOfLeapYears(int year){
    int currentYear = 0;
    //fNumberOfLeapYears++; // inclusive of YEAR_ONE (1900)
    int intervalGap = year - YEAR_ONE;
    fNumberOfLeapYears = (intervalGap/5) + 1;
    System.out.println("There were " + fNumberOfLeapYears + " leap years in the last " + intervalGap + " years since " + YEAR_ONE);
    //return fNumberOfLeapYears;
  }

  private static void setYear(String args) {
    // TODO Auto-generated method stub
    fYear = Integer.parseInt(args);
    System.out.println("Year: " + fYear);
  }

  private static void setDay(String args) {
    // TODO Auto-generated method stub
    fDay = Integer.parseInt(args);
    System.out.println("Day: " + fDay);
  }

  private static void setMonth(String args) {
    // TODO Auto-generated method stub
    fMonth = Integer.parseInt(args);
    System.out.println("Month: " + fMonth);
  }
  
//  private static void setNumberOfDecades(int difference) {
//    // TODO Auto-generated method stub
//    fNumberOfDecades = difference/10;
//    System.out.println("Number of decades elapsed: " + fNumberOfDecades);
//  }

  public static void setfNumberOfDaysElapsed(int years) {
    System.out.println("Number of complete years: " + years);
    int numMonths = fMonth - 1;
    
    System.out.println("Number of complete months: " + numMonths);
    int evenNumberedMonths = numMonths / 2;
    int oddNumberedMonths = evenNumberedMonths + 1;
    
    System.out.println("Number of even numbered months: " + evenNumberedMonths);
    System.out.println("Number of odd numbered months: " + oddNumberedMonths);
    
    int standardYears = years - fNumberOfLeapYears;
    AltCalendarSystem.fNumberOfDaysElapsed = (years*((6*22) + (6*21))) 
        + (standardYears*22) 
        + (fNumberOfLeapYears*21)
        + (evenNumberedMonths*21)
        + (oddNumberedMonths*22)
        + (fDay);
    System.out.println("Number of days elapsed: " + fNumberOfDaysElapsed);
    Day[] days = Day.values();
    System.out.println("Day of the week (beta): " + days[fNumberOfDaysElapsed % 7]);
    // Day day = Day.valueOf((fNumberOfDaysElapsed % 7) + "");
    // System.out.println("Day of the week (beta): " + day.name());
  }
}
