abstract public class Date212List 
{
  //abstract class means it CANNOT be initiated - however, classes that extend from Date212List CAN be. Serves as a template for Uunsorted and Sorted class.
  
  //creating protected fields for the nodes 
  protected Date212Node head;
  protected Date212Node tail;
  protected int length;

  public Date212List()
  {
		Date212Node ln = new Date212Node();
		//Dummy nodes 
		this.head = ln;
		this.tail = ln; 
		this.length = 0;
  }

  //append method to add a Date212 object onto a LinkedList
  public void append(Date212 date) 
  {
		Date212Node n = new Date212Node(date);  
		//step 1 - connecting the LinkedNodes
		tail.next = n;

		//step 2 - since tail has a new end, we reset what tail is equal to. 
		tail = n; 

		//step 3
		length++;
  }
  
  public void deleteList() {
	  Date212Node n = new Date212Node();
	  this.head = n;
	  this.tail = n;
  }

  //Method used when we need to iterate the ENTIRE LinkedList
  public String toString()
  {
		// Create the StringBuilder we'll use to append every node's data to
		StringBuilder sb = new StringBuilder();

		// Iterate through linked list until we hit null, adding the string 
		// that's inside each node to the StringBuilder
		for (Date212Node i = head.next; i != null; i = i.next)
		{
          sb.append(i.toString() + "\n");
		}
  
		// Add to the StringBuilder the last string
		//sb.append("null"); - NOT adding to the StringBuilder since we are displaying the dates using this toString method.

		// Return the string representation of the StringBuilder
		return sb.toString();
  }
}