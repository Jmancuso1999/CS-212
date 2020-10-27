import javax.swing.JOptionPane;

/*
James Mancuso
Lab section 11D: Tuesday, Thursday from 12:15-1:05pm 
*/

public class Main 
{
	public static void main(String [] args) 
	{
		String stop = "stop";
		String wantToStop;
		 
		//Keep the while loop true until the user wants to stop.
		while(true) 
		{	
			String input = JOptionPane.showInputDialog("Enter a sentence: ");
			
			//Create a for loop to check the ENTIRE length of the string.
			int upE = 0, lowE = 0; 
			
			for(int i = 0;i < input.length(); i++) 
			{
				//Checks each character in the string if it is UPPERCASE.
				if(input.charAt(i) == 'E')
					upE++;
				else if(input.charAt(i) == 'e')
					lowE++;
			}
			
			//Use JOptionPane showInputDialog to display in a window the upper and lower case total
			JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowE + "\nNumber of upper case e's: " + upE);
						//To display both lowE and upE in the SAME box, use \n to skip a line.
						
			//Ask's the user if he wants to continue, compares to stop keyword and ignores capitalization.
			wantToStop = JOptionPane.showInputDialog("Type stop to prevent continuation: ");
			if(stop.equalsIgnoreCase(wantToStop)) 
				return; 

		}
	}
}