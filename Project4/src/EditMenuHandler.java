import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;

public class EditMenuHandler implements ActionListener 
{
   // Save the reference to the gui object this EditMenuHandler is associated with
   private Date212GUI gui;

   public EditMenuHandler(Date212GUI g) 
   {
      //If a Date212GUI object is taken in, the GUI is saved as a reference now which allows us to access the information of the GUI.
      gui = g; 
   }

   @Override
   public void actionPerformed(ActionEvent event) 
   {
      String menuName = event.getActionCommand();

      if(menuName == "Insert") {
         String inputDate = JOptionPane.showInputDialog(null, "Enter a date is the valid format yyyymmdd: ");
         Date212 date = new Date212();
         int month = Integer.parseInt(inputDate.substring(4,6));
         int day = Integer.parseInt(inputDate.substring(6,8));
         try {
            //Checks whether user inputted date is valid - since isValid is a Date212 method, we need to create a Date212 object to access the method.
            if(date.isValid(month, day)) {             
                  //gui is an object of Date212GUI which allows access to the addingDate method
                  //Method adds the inputted date to BOTH the TreeMap and Date212UnsortedList
                  gui.addingDate(inputDate);

                  /*

                     FIX:
                        -MAKE SURE TO SORT THE RIGHT SIDE OF THE GUI BY ----> TreeMap ---> Figure out what exactly is tree map and then solve on my own
                        -FIGURE OUT WHY "isValid" is showing a red text.


                  
                  */

            }
         }
         catch(Date212Exception e) {
            System.out.println(inputDate + e.getMessage());
         }
      }
   
   }
   
} 