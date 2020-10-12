
public class Node2
{
	Node2 next;
	int key;
	String fname;
	String lname;
	double balance;
	TestClass x;
	
	public Node2(int key, String fname, 
			String lname, double balance)
	{
		this.key = key;
		this.fname = fname;
		this.lname = lname;
		this.balance = balance;
		//this.customclassx = specific object;
	}
	
	//overloaded constructor for custom class only
	public Node2(TestClass x) {  //this is how I would essentially point to an object of a custom class from a node
		this.x = x;
	}
}
