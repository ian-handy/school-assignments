
public class MyAnimalCrossingVillagerLL implements VillagerListInterface {
	
	private Node<String> head;
	private int count;
	
	public MyAnimalCrossingVillagerLL()
	{
		head = new Node<String>(); //Dummy head node, to make things easier.
		count = 0;
	}
	
    public void add(String name)
    {
    	//1. Make sure name is valid, if it's not return;
    	
    	
    	//2. Create a new node
    	
    	
    	//3.Add the name to the new node
    	
    
    	//4.Set the new node's next to the front of the list
    	
    	
    	//5. set the head of the list (remember we have a dummy node) to point to this new node
    	
    	
    	//6. update the count

    	
    }
    public void remove(String name)
    {
    	//1. Create a traverse pointer and have it point to the dummy node
    
    	
    	//2. while trav.getNext() is pointing at something (as opposed to null)
    	
    		//2.1. check to see if trav.getNext().getData() is equal to the parameter name
    		
    			//2.1.1 if it is lets start removing it by making trav's next point to trav's next next
    			
    			
    			//2.1.2 update count
    			
    			
    			//2.1.3 get the heck out of this here method right away by returning
    			
    		
    		//2.2 advance the traverse pointer to the next node
    		
    	
    	
    	//3. FREEBIE Code: it never returned and made it here, it  means it never found name....
    	System.out.println(name + " already does not live on the island!");
    }
    public boolean isEmpty()
    {
    	//FREEBIE Code:
    	return count == 0;
    }
    public boolean isFull()
    {
    	//FREEBIE Code:
    	return false; //linked lists are never full
    }
    public String getItem(int i)
    {
    	//0. FREEBIE CODE: Set up a trav pointer
    	Node<String>trav = null;
    	
    	//1. Check to make sure i is valid, if it's not, print out "That character does not live here" and return "";
        
        //2. Otherwise i is valid, have the trav pointer point to the first node in the linked list
    	
    	//3. Move trav along the linked list 'i' times.

    	//4. FREEBIE CODE: trav should be pointing at the 'i'th node, return trav.getData();
    	return trav.getData();
    	
    }
	public int getSize()
	{
		//FREEBIE Code:
		return count;
	}
	public VillagerListInterface shuffleAndFilter()
	{
		//FREEBIE Code:
		String tempArray[] = new String[count];
		Node<String> trav = head.getNext();
		
		//temporarily copy everything to an array.
		for(int x = 0; x<count ;x++)
		{
			tempArray[x] = trav.getData();
			trav = trav.getNext();
		}
		
		VillagerListInterface newList = new MyAnimalCrossingVillagerLL(); 
		//Now build a new Linked list with even entries first, and odd entries last
		for(int x = 0; x< count;x+=2)
		{
			newList.add(tempArray[x]);
		}
		
		for(int x = 1; x< count;x+=2)
		{
			newList.add(tempArray[x]);
		}
		
		return newList;
	}
    public void printList()
    {
    	//1. FREEBIE CODE: Set up a trav pointer
    	Node<String>trav = null;
        
        //2. have the trav pointer point to the first node in the linked list
    	
    	//3. Move trav along the linked list until it gets to the end
    	
    		//3.1 for each node that trav points to, print out the name/data in that node. trav.getData();


    }
	

}
