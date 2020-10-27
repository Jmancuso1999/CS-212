import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JFrame;

public class DateGUI extends JFrame
{
    //Instance variables
    private JTextArea leftTextArea;
    private JTextArea rightTextArea;

	public DateGUI() {

	}

	//Template for a GUI. 
    public DateGUI(Date212 [] input, Date212 [] sortInput)
    {
		super("Dates ");
		
		//Configure main JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //taken from the JFrame class, allows us to close the window
		this.setSize(100, 100);// (width, height);
        this.setLocation(200, 200);// x, y);
		this.setLayout(new GridLayout(1, 2)); //sets the GUI to be 1 row 2 columns 
		
		//Initializes the JTextArea with the dates of BOTH Date212 objects.
		this.leftTextArea = new JTextArea("Unsorted Dates: \n");
		this.rightTextArea = new JTextArea("Sorted Dates: \n");

		//Adds in the unsorted and sorted dates. 
		for(int i = 0; i < input.length; i++) {
			//Potential null values within array. As long as it's not null, continue the for loop.
			if(input[i] != null) {
				this.leftTextArea.append(input[i].toString() + "\n");
				this.rightTextArea.append(sortInput[i].toString() + "\n");
			}
			else 
				break;
		}

		//Adds the information we put into the text area to the GUI.
		this.getContentPane().add(this.leftTextArea);
		this.getContentPane().add(this.rightTextArea);
    }
	
	//Allows for the GUI to display 
    public void showGui()
    {
	    this.pack();
        this.setVisible(true);
    }
}