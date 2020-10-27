public class Date212Exception extends Exception
{
   //Since we do NOT want the program to halt when running, we run a Checked Exception so we extend Exception. 
   public Date212Exception(String message) 
   {
      super(message); //Purpose of this class is to throw an exception AND a message when the user inputs an in valid data
   }
}