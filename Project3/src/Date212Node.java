public class Date212Node 
{
   //Protected instance variables - purpose is to only be used with descedent classes from this one. 
   protected Date212 data;
   protected Date212Node next; 
   
   //constructor 
	public Date212Node() 
	{
		this.data = null;
		this.next = null;
	}
	
   //constructor   
   //We are importing 1 date at a time. 
   public Date212Node(Date212 d) 
   {
		this.data = d;
		this.next = null;
   }

   //constructor 
   public Date212Node(Date212 d, Date212Node n) 
   {
		this.data = d;
		this.next = n;
   }
   
   //This makes data avaiable outside the class.
   public String toString() 
   {
		return data.toString();
   }
   public Date212Node getNext() 
   {
		return this.next; 
   }
   
}