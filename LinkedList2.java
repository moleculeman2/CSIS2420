
public class LinkedList2
{

	Node2 head;
	Node2 test = new Node2(0, null, null, 0);
	
	public void append(int key, String fname, String lname, double balance)
	{
		if (head == null)
		{
			head = new Node2(key, fname, lname, balance);
			return;
		}
		Node2 current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = new Node2(key, fname, lname, balance);
	}
	
	
	public void append(int key)
	{
		if (head == null)
		{
			head = new Node2(key, "", "", 0);
			return;
		}
		Node2 current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = new Node2(key, "", "", 0);
	}
	
	public void prepend(int key, String fname, String lname, double balance)
	{
		Node2 newHead = new Node2(key, fname, lname, balance);
		newHead.next = head;
		head = newHead;
	}

	
	public void insert(boolean before, int key, String fname, 
			String lname, double balance)
	{
		Node2 current;
		Node2 prev;
		if (head == null)	//if no head, create node and set to head
		{
			head = new Node2(key, fname, lname, balance);
			return;
		}
		
		if (head.key == key && before)  //always use before = true until "after" portion re-enabled
		{
			current = head; 							//current and head point to same node
			head = new Node2(key, fname, lname, balance);	//head points to newly created node
			head.next = current;						//head.next points to old head, which connects to rest of list
			return;
		}
		
		/**  removed for performance sake, will re-add later (inserts after)
		if (head.key == key && !before)
		{
			current = head.next; 							//current and pointer after head point to same node
			head.next = new Node2(key, fname, lname, balance);	//pointer after head points to new node
			head.next.next = current;						//head.next.next points to old node, which connects to rest of list
			return;
		} **/
		
		current = head;
		prev = head;
		while (current.next != null)
		{
			prev = current;									//saves the pointer to the previous value (this may affect cost)
			current = current.next;
			if (current.key == key && before)
			{
				prev.next = new Node2(key, fname, lname, balance); 	//point prev.next to this new node
				prev.next.next = current;						//point prev.next.next to the rest of the list
				return;
			}
			/** removed for performance sake, will re-add later (inserts after)
			else if (current.key == key && !before) {
				Node2 temp = new Node2(key, fname, lname, balance);
				temp.next = current.next;
				current.next = temp;
			} **/
		}
	}
	
	public void deleteWithValue(int key)
	{
		if (head == null) return;
		
		if (head.key == key)
		{
			head = head.next;
			return;
		}
		Node2 current = head;
		while (current.next != null)
		{
			if (current.next.key == key)
			{
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public String searchList(int key)
	{
		String result = "Not found";
		if (head == null) return "List Empty";
		Node2 current = head;
	
		if (head.key == key)
		{
			result = "Key: " + head.key 
					+ "  Name: " + head.fname + " " 
					+ head.lname + "  Balance: "
					+ head.balance;
		}
		else
		{
			while (current.next != null)
			{
				if (current.next.key == key)
				{
					result = "Key: " + current.next.key 
							+ "  Name: " + current.next.fname + " " 
							+ current.next.lname + "  Balance: "
							+ current.next.balance;
				}
				current = current.next;
			}
		}
		return result;
	}
	
	public String searchList(String fn, String ln)
	{
		String result = "Not found";
		if (head == null) return "List Empty";
		Node2 current = head;
	
		if (head.fname.equals(fn) && head.lname.equals(ln))
		{
			result = "Key: " + head.key 
					+ "  Name: " + head.fname + " " 
					+ head.lname + "  Balance: "
					+ head.balance;
		}
		else
		{
			while (current.next != null)
			{
				if (current.next.fname.equals(fn) && current.next.lname.equals(ln))
				{
					result = "Key: " + current.next.key 
							+ "  Name: " + current.next.fname + " " 
							+ current.next.lname + "  Balance: "
							+ current.next.balance;
					break;
				}
				current = current.next;
			}
		}
		
		return result;
	}

	public String searchList(double balance)
	{
		String result = "Not found";
		if (head == null) return "List Empty";
		Node2 current = head;
	
		if (head.balance == balance)
		{
			result = "Key: " + head.key 
					+ "  Name: " + head.fname + " " 
					+ head.lname + "  Balance: "
					+ head.balance;
		}
		else
		{
			while (current.next != null)
			{
				if (current.next.balance == balance)
				{
					result = "Key: " + current.next.key 
							+ "  Name: " + current.next.fname + " " 
							+ current.next.lname + "  Balance: "
							+ current.next.balance;
					break;
				}
				current = current.next;
			}
		}
		
		return result;
	}

	public int length()
	{
		int len = 1;
		if (head == null) return len - 1;
		Node2 current = head;
		while (current.next != null)
		{
			len++;
			current = current.next;
		}
		return len;	
	}

	public void printList()
	{
		Node2 current = head;
		System.out.print("List: ");
		while (current != null)
		{
			System.out.print("\n\tKey: " + current.key + " [" + 
					current.fname + " " + 
					current.lname + "] Balance [" + 
					current.balance + "]" + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

}
