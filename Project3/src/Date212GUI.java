import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFileChooser;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

import java.util.StringTokenizer;
import java.lang.Exception;
import java.util.LinkedList; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Date212GUI extends JFrame
{
	//Instance variables
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;
	
	//Since Date212List is abstract, the objects will be the decedent classes. 
	private UnsortedDate212List unsorted = new UnsortedDate212List();
	private SortedDate212List sorted = new SortedDate212List();

	Date212GUI myGUI; 
	
	public Date212GUI() 
	{
		this.getMenu();
	}

	//Template for a GUI. 
    public Date212GUI(String title)
    {
		//sets title of GUI 
		super(title);
		
		//Configure main JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //taken from the JFrame class, allows us to close the window
		this.setSize(300, 300);// (width, height);
		this.setLocation(200, 200);// x, y);
		this.setLayout(new GridLayout(1, 2)); //sets the GUI to be 1 row 2 columns 

		//Calls the getMenu() method which creates the objects for the FileMenuHandler
		this.getMenu();

		//Initializes the JTextArea with the dates of BOTH Date212 objects.
		this.leftTextArea = new JTextArea(5, 20);
		this.rightTextArea = new JTextArea(5, 20);
			
		this.leftTextArea.append("Unsorted Dates: \n");
		this.rightTextArea.append("Sorted Dates: \n");
	
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

	//Method to create the objects for a FileMenu and adds the Actions from the FileMenuHandler class to the Menu with the created options.
	public void getMenu() 
	{		
		//Create the menu bar objects
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File"); //Creates the drop down menu (NOT the buttons inside of it) - look at picture from notes to see.
		JMenuItem open = new JMenuItem("Open"); //CREATES (DOESNT ADD TO THE MENU) One of the options in the drop down menu
		JMenuItem quit = new JMenuItem("Quit");
		
		FileMenuHandler fmh = new FileMenuHandler(this); //From the class FileMenuHandler we've created
										//this is pointing to the object created within the constructor - refer to FileMenuHandler constructor that has a parameter
										//In this case we need this because this has a value for the object created.
										
		// Add logic to the menu items 
		open.addActionListener(fmh);
		quit.addActionListener(fmh);
				
		// Add the menu items to the file menu
		fileMenu.add(open);
		fileMenu.addSeparator();
		fileMenu.add(quit);
		
		// Add file menu to the menu bar, and set this gui's
		menuBar.add(fileMenu);
				
		//Add menu to the GUI
		this.setJMenuBar(menuBar);
	}

	//Method should get a file inputted after the user had selected their file, once the file is selected. 
	//Add the data to a sorted and unsorted Date212List and display within a GUI.
	public void readFile(File file) 
	{
		//test whether a file was located. 
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		TextFileInput inputDate = new TextFileInput(file.getAbsolutePath());

		//Everytime readFile is called, the LinkedList values are reset. 
		unsorted.deleteList();
		sorted.deleteList();

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
					//Create a temporary Date212 object so we can test each individual token. 
					Date212 testDate = new Date212();  
					int month = Integer.parseInt(token.substring(4,6));
					int day = Integer.parseInt(token.substring(6,8));
					//Since we are in a while loop, if the token is deemed invalid, it will NOT put the date into an array, go to the top of the while loop.
					//Then it will move on to the next token WITHIN the line.
					try {
						 if(testDate.isValid(month, day)) 
						 {
							  testDate = new Date212(token);
							  unsorted.add(testDate);
							  sorted.add(testDate);
						 }
					} 
					//Displays exception message WITH the invalid date WHEN caught
					catch(Date212Exception e) {
						 System.out.println(token + e.getMessage());
					}
			  }
		}
		//The toString() method in the abstract class Date212List intializes the ENTIRE LinkedList, calling the non-static method will append the entire list to the TextAreas.
		//setText replaces previous text or adds text depending on whether the GUI is empty. 
		this.leftTextArea.setText("Unsorted Dates: \n" + unsorted.toString() + "\n");
		this.rightTextArea.setText("Sorted Dates: \n" + sorted.toString() + "\n");	

		//Closes file at the end of the program.
		inputDate.close();

	}
}