public class SortedDate212List extends Date212List 
{
   //Default constructor, sets up the LinkedList when no values are inputted. 
   public SortedDate212List() 
   {
		super();
   }

   //When a SortedDate212List object is created - the following add method CAN be used. 
   
   public void add(Date212 date) 
   {
		//Creating a node so we can add it to the LinkedList. We are using the D212Node(parameter), the date is being placed as a node to put into the LinkedList.
		//Since we've created the node, we now can place it into the LinkedList when we find the location.
		Date212Node n = new Date212Node(date); 

		//Iterator needed so we can start from the BEGINNING of the LinkedList, once we have the first node, the rest of the list is connected. 
		Date212Node iterator = head; 

		//Iterates through the sorted dates to find the correct position to input the new date
		for(iterator = head; iterator.next != null && n.data.compareTo(iterator.next.data) > 0; iterator = iterator.next) //We are checking until we reached the node we are looking for.
		{
         		//do nothing
		}

		//Makes sure the linkedlist from the right of this node is not broken off.
		n.next = iterator.next; 
      
		//connects the node we are placing in it's sorted order location. 
		iterator.next = n; 
		
		//edge case 
		if(iterator == this.tail) this.tail = n;
		
		length++;
   }
   
   
} //end of class
