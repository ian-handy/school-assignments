/***********************************************************
 * Name: Ian Handy
 * Date: 2026-04-28
 * Description of lab work: Linked-list implementation of
 * the VillagerListInterface ADT using a singly linked list
 * with a dummy head node and a generic Node<E>.
 ***********************************************************/

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
    	if (name == null || name.equals("")) {
    		System.out.println("That is not a valid name!");
    		return;
    	}

    	//2. Create a new node
    	Node<String> newNode = new Node<String>();

    	//3.Add the name to the new node
    	newNode.setData(name);

    	//4.Set the new node's next to the front of the list
    	newNode.setNext(head.getNext());

    	//5. set the head of the list (remember we have a dummy node) to point to this new node
    	head.setNext(newNode);

    	//6. update the count
    	count++;
    }
    public void remove(String name)
    {
    	//1. Create a traverse pointer and have it point to the dummy node
    	Node<String> trav = head;

    	//2. while trav.getNext() is pointing at something (as opposed to null)
    	while (trav.getNext() != null) {
    		//2.1. check to see if trav.getNext().getData() is equal to the parameter name
    		if (trav.getNext().getData().compareToIgnoreCase(name) == 0) {
    			//2.1.1 if it is lets start removing it by making trav's next point to trav's next next
    			trav.setNext(trav.getNext().getNext());

    			//2.1.2 update count
    			count--;

    			//2.1.3 get the heck out of this here method right away by returning
    			return;
    		}

    		//2.2 advance the traverse pointer to the next node
    		trav = trav.getNext();
    	}

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
    	if (i < 0 || i >= count) {
    		System.out.println("That character does not live here");
    		return "";
    	}

        //2. Otherwise i is valid, have the trav pointer point to the first node in the linked list
    	trav = head.getNext();

    	//3. Move trav along the linked list 'i' times.
    	for (int x = 0; x < i; x++) {
    		trav = trav.getNext();
    	}

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
    	trav = head.getNext();

    	//3. Move trav along the linked list until it gets to the end
    	while (trav != null) {
    		//3.1 for each node that trav points to, print out the name/data in that node. trav.getData();
    		System.out.println(trav.getData());
    		trav = trav.getNext();
    	}
    }


}
