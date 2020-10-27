import java.awt.GridLayout;
import java.util.StringTokenizer;
import java.lang.Exception;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Project1 
{
    public static void main(String[] args)
    {
      Date212 [] inputD = new Date212[50]; 
      Date212 [] sortedD = new Date212[50];

      TextFileInput inputDate = new TextFileInput("input.txt");

      int count = 0;
      String line;
      //Checks if there is still dates on the line. 
      while((line = inputDate.readLine()) != null) 
      { 
        String delimiter = ",";
        StringTokenizer tokenizer = new StringTokenizer(line, delimiter);   
        //Checks if there is more tokens within the line.
        while(tokenizer.hasMoreTokens()) 
        {     
            String token = tokenizer.nextToken();
            Date212 testDate = new Date212(); 
            //Since we are in a while loop, if the token is deemed invalid, it will NOT put the date into an array, go to the top of the while loop.
            //Then it will move on to the next token WITHIN the line.
            if(testDate.isValid(token)) 
            {
              inputD[count] = new Date212(token);
              count++;
            }
        } 
      }

      //Sorts the dates into a Date212 object. FIND A WAY TO MAKE IT SORT INTO ANOTHER 
      selectionSort(inputD, sortedD);

      //DateGUI should serve as a template to allow for us to display BOTH Date212 objects. 
      DateGUI myGUI = new DateGUI(inputD, sortedD); 

      //Allows for the GUI to be visible.
      myGUI.showGui();

      //Closes file at the end of the program.
      inputDate.close();

   }  //end of main

    public static void selectionSort(Date212 [] input, Date212 [] sorted)
     {  
      for(int i = 0; i < input.length; i++) {
        sorted[i] = input[i];
      } 
      for (int i = 0; i < input.length; i++)
         {
          Date212 min = sorted[i];
          int minIndex = i;
          for (int j = i + 1; j < input.length; j++)
          {
            if(sorted[j] == null) break;
            else if (min.compareTo(sorted[j]) > 0)
            {
              min = sorted[j];
              minIndex = j;
            }		
          }
          swap(sorted, i, minIndex);
		 }
    }
     public static void swap(Date212 [] input, int i, int j)
     {
         Date212 temp = input[i];
         input[i] = input[j];
         input[j] = temp;
     } 

}