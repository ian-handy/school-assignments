//Ian Handy 10/15/25
//This program copies the values from one Box item over to a new one, creating a copy of it.

public class Box {
	
	//private class attributes
	private double width;
	private double length;
	private double height;
	private String label;
	
	
	public Box(double w, double l, double h,String name)
	{
		//Set defaults to ensure all values have a number and then fill with given values (if valid)
		setDefaults();
		if (w>0) this.width = w;
		if (l>0) this.length = l;
		if (h>0) this.height = h;
		if (name.length()>0) this.label = name;
		
	}
	
	public Box(Box cloneMe)
	{
		//Copy the attributes of cloneMe to this classes instance
		this.width = cloneMe.getWidth();
		this.length = cloneMe.getLength();
		this.height = cloneMe.getHeight();
		this.label = cloneMe.getLabel() + " clone"; //Add 'clone' to the end of the copied Box
		
	}

	private void setDefaults()
	{
		width = 1;
		length = 1;
		height = 1;
		label = "Gary Goodspeed";
	}
	
	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public String getLabel() {
		return label;
	}
	
	public double getVolume() {
		return this.length*this.height*this.width;
	}
	
	public double compareTo(Box b)
	{
		//if Box b exists return the difference in volume between the current Box and Box b, otherwise return the volume of this Box
		if (b==null) {return this.getVolume();}
		return this.getVolume() - b.getVolume();
	}
	
	
	public boolean equals(Box b)
	{
		//If, I should make sure b is actually an instance
		if(b == null)
		{
			//b is not pointing to an instance, so it's automatically
			//not equal to ours.
			return false;
		}
		
		//if the the code makes it here, b must be pointing to an instance.
		
		//By using "this", I can differential because our
		//instance of box, and the one given to us.
		if((this.length == b.length)&&(this.height == b.height)&&(this.width == b.width))
		{
			//if our length, height and width are the same as b's, they are the same
			return true;
		}
		
		//otherwise if the code get this far, at least one of the attributes was not the same
		return false;
	}
	

}
