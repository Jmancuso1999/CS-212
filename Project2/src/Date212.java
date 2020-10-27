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
            //When the Date212 object is now called, we have EACH individual month, day and year for each value in the object. 
            //Takes each value and separates the data into month, year, and day
            year = Integer.parseInt(inputDate.substring(0,4));
            month = Integer.parseInt(inputDate.substring(4,6));
            day = Integer.parseInt(inputDate.substring(6,8));

      }
      
      //Returns the date in a format of (month spelt) (day #), (year #)
      @Override
      public String toString(){
	      return (months[this.month - 1] + " " + this.day + ", " + this.year);
      }
   
      //Certain months have a certain amount of days. isValid allows us to check if the potential dates and days that may create an invalid date.    
      //If one of the conditions is satsified, we know that the date is valid. 
      public boolean isValid(String date) 
      {
            Date212 dateCheck = new Date212(date);
            if(dateCheck.month >= 1 && dateCheck.month <= 12) 
            {
                  if(dateCheck.month == 2) 
                  {
                        if(dateCheck.day >= 1 && dateCheck.day <= 28) 
                              return true;
                  }
                  if(dateCheck.month == 4 || dateCheck.month == 6 || dateCheck.month == 9 || dateCheck.month == 11) 
                  {
                        if(dateCheck.day >= 1 && dateCheck.day <= 30) return true;
                  }
                  if(dateCheck.month == 1 || dateCheck.month == 3 || dateCheck.month == 5 || dateCheck.month == 8 || dateCheck.month == 10 || dateCheck.month == 12) 
                  {
                        if(dateCheck.day >= 1 && dateCheck.day <= 31) return true;
                  }            
            }
            else
                  System.out.println("Invalid date");
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