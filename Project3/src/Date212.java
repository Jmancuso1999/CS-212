import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.lang.Exception;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JFrame;

public class Date212 
{
      //Instance variables
      private int month;
      private int year;
      private int day; 
      
      static String [] months =
                              {"January", "February","March","April","May","June",
                              "July","August","September","October","November","December"}; 

      public Date212() 
      {
      }

      public Date212(String inputDate) 
      {
            try {
                  //When the Date212 object is now called, we have EACH individual month, day and year for each value in the object. 
                  //Takes each value and separates the data into month, year, and day
                  year = Integer.parseInt(inputDate.substring(0,4));
                  month = Integer.parseInt(inputDate.substring(4,6));
                  day = Integer.parseInt(inputDate.substring(6,8));
                  //isValid is checked here so if an exception is thrown from the current inputed information, it will be caught here. 
                  if(isValid(month, day)) {}
            }
            //Displays exception message WITH the invalid date WHEN caught
            catch(Date212Exception e) {
                  System.out.println(e.getMessage());
            }
      }
      
      //Returns the date in a format of (month spelt) (day #), (year #)
      @Override
      public String toString(){
	      return (months[this.month - 1] + " " + this.day + ", " + this.year);
      }
   
      //Certain months have a certain amount of days. isValid allows us to check if the potential dates and days that may create an invalid date.    
      //If one of the conditions is satisfied, we know that the date is valid. 
      public boolean isValid(int month, int day) throws Date212Exception
      {	
            if(month >= 1 && month <= 12) 
            {
                  if(month == 2) 
                  {
                        if(day >= 1 && day <= 28) 
                              return true;
                  }
                  if(month == 4 || month == 6 || month == 9 || month == 11) 
                  {
                        if(day >= 1 && day <= 30) return true;
                  }
                  if(month == 1 || month == 3 || month == 5 || month == 8 || month == 10 || month == 12) 
                  {
                        if(day >= 1 && day <= 31) return true;
                  }            
            }
            //throws an exception if we are not given a valid date. 
            else throw new Date212Exception("is a invalid date.");
            return false;
      }
      
      //Checks in order, if the years dont match at first, then we can determine the order just from the years
      //If the return value greater than 0, we know that the 1st date is older than the 2nd date which requires a switch.
      public int compareTo(Date212 date) 
      {	
            if(this.year != date.year)
                  return this.year - date.year;
                  
            else if(this.month != date.month) 
                  return this.month - date.month; 

            else if(this.day != date.day)
                  return this.day - date.day;

            return 0;
      }
}