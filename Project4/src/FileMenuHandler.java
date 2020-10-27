import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;


public class FileMenuHandler implements ActionListener 
{
    // Save the reference to the gui object this FileMenuHandler is 
    // associated with
    private Date212GUI gui;
   
    // Constructor that takes as its parameter the gui associated 
    // with this FileMenuHandler
    public FileMenuHandler(Date212GUI gui) 
    {
        this.gui = gui;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        //We are getting the action that the user clicked here - finding out whether the user clicked open or quit. 
        String menuName = event.getActionCommand();
        
        if (menuName.equals("Open")) {
            
            // Create the object that will choose the file
            JFileChooser fc = new JFileChooser();

            // Attempt to open the file
            int returnVal = fc.showOpenDialog(null);

            // If user selected a file, create File object and pass it to
            // the gui's readFile method
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File file = fc.getSelectedFile();
                this.gui.readFile(file);
            } 
            else if (returnVal == JFileChooser.CANCEL_OPTION)
            {
                System.out.println("Open command canceled by user.");
            }
        } 
        else if (menuName.equals("Quit"))
        {
            JOptionPane.showMessageDialog(null,"You clicked on Quit");
            System.exit(1);
        } 
    } 
}