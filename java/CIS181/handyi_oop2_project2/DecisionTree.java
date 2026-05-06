/* 
 * Instructor/Programmer: Clinton Rogers
 * Date: 4/2/2019
 * Any documents, source code, or work you create/modify as a result of this project is the 
 * property of the University of Massachusetts Dartmouth.  This document and any and all source 
 * code cannot be shared with anyone except: University of Massachusetts Dartmouth faculty 
 * (including TA�s), and in a private digital portfolio (public access online is prohibited) 
 * with the intention of applying to jobs and internships. These exceptions are non-transferable. 
 * Failure to comply is, at the very least, an academic infraction that could result in dismissal 
 * from the university. 
 * 
 * Student Name: Ian Handy
 * Date: 2026-04-24
 * Description: Binary decision tree for a text-based choose-your-path game.
 *              play() traverses the tree iteratively based on user input.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DecisionTree {
	
	private TreeNode head = null;
	Scanner input = new Scanner(System.in);
	
	public void play()
	{
		// Walk the tree from head. At each non-ending node, print the prompt
		// and follow option1 or option2 based on the user's 1/2 choice.
		TreeNode trav = head;
		while(!trav.isEnding())
		{
			System.out.println(trav.getMessage());

			int choice = 0;
			while(choice != 1 && choice != 2)
			{
				String line = input.nextLine().trim();
				try { choice = Integer.parseInt(line); }
				catch(NumberFormatException e) { choice = 0; }
				if(choice != 1 && choice != 2)
					System.out.println("Please enter 1 or 2.");
			}

			trav = (choice == 1) ? trav.getOption1() : trav.getOption2();
		}
		System.out.println(trav.getMessage());
	}
	
	public void buildStory()
	{
		head = recursivelyBuildTree(new String());
		System.out.println("The Story Is Complete!");
	}
	
	private TreeNode recursivelyBuildTree(String storySoFar)
	{
		
		//Reiterate the story so far....
		System.out.println("The story so far...");
		System.out.println(storySoFar);
		
		//Create a new node
		TreeNode newNode = new TreeNode();
		
		//Find out if this is an end to the story
		char choice;
		do{
			System.out.println("Is this an ending node? (y/n)");
			choice = input.nextLine().charAt(0);
		}while((choice != 'n')&&(choice != 'N')&&(choice != 'Y')&&(choice != 'y'));
		
		//Set the newNode to reflect if it's an ending...
		newNode.setEnding(choice=='y' || choice=='Y');
		
		//Get the text for this segment
		String temp;
		do{
			System.out.println("What is the text for this section of the story?");
			temp = input.nextLine();
			System.out.println("Are you okay with this?(y/n): " + temp);
			choice = input.nextLine().charAt(0);
		}while((choice == 'n')||(choice == 'N'));
		
		//Set the newNode to reflect the new text
		newNode.setMessage(temp);
		
		//Recursively call recursivelyBuildTree if this is not an ending...
		if(!newNode.isEnding())
		{
			newNode.setOption1(recursivelyBuildTree(storySoFar+temp+'\n'+"Option 1 chosen"+'\n'));
			newNode.setOption2(recursivelyBuildTree(storySoFar+temp+'\n'+"Option 2 chosen"+'\n'));
		}
		
		return newNode;
	}
	
	public void saveTreeToFile()
	{
		System.out.println("What would you like your file name saved as?");
		String filename = input.nextLine();
		
		//Create file
		try{
			PrintWriter pw = new PrintWriter(filename);
			recursiveSave(pw,head);
			pw.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("File not created! Issue creating file: "+filename);
		}
		
		
		
	}
	
	private void recursiveSave(PrintWriter output, TreeNode currentNode)
	{
		//Save the text from this node
		output.println(currentNode.getMessage());
		
		//Save whether or not this is an ending node
		output.println(currentNode.isEnding());

		//if this is not an ending, we need to go deeper
		if(!currentNode.isEnding())
		{
			recursiveSave(output,currentNode.getOption1());
			recursiveSave(output,currentNode.getOption2());	
		}
	}

	public void loadTreeFromFile(String filename)
	{		
		//Create file
		try{
			File f = new File(filename);
			Scanner fileInput = new Scanner(f);
			head = recursiveLoad(fileInput);
			fileInput.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("File not created! Issue creating file: "+filename);
		}		
	}
	
	private TreeNode recursiveLoad(Scanner fileInput)
	{
		TreeNode newNode = new TreeNode();
		
		//Get and set message
		String temp = fileInput.nextLine();
		newNode.setMessage(temp);
		
		//Get and set ending condition
		temp = fileInput.nextLine();
		newNode.setEnding(temp.equalsIgnoreCase("true"));
	
		//if this is not an ending, we need to go deeper
		if(!newNode.isEnding())
		{
			TreeNode opt1 = recursiveLoad(fileInput);
			newNode.setOption1(opt1);
			TreeNode opt2 = recursiveLoad(fileInput);	
			newNode.setOption2(opt2);
		}
		return newNode;
	}
	
	
	public void displayStory()
	{
		//Recursively go through the tree and display all the messages and options.
		recursiveDisplayStory(head,new String());
	}
	
	private void recursiveDisplayStory(TreeNode currentNode, String storySoFar)
	{
		//Save the text from this node
		storySoFar+= '\n' + currentNode.getMessage();
		System.out.println("The Story So far:" + storySoFar);

		//if this is not an ending, we need to go deeper
		if(!currentNode.isEnding())
		{
			recursiveDisplayStory(currentNode.getOption1(),storySoFar + '\n' + "Option 1 chosen"+'\n');
			recursiveDisplayStory(currentNode.getOption2(),storySoFar + '\n' + "Option 2 chosen"+'\n');
		}
	}
	
}
