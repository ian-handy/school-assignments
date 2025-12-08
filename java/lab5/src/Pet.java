//Ian Handy 10/6/25

public class Pet {
	
	//Class Private Data Members
	private String petName;
	private int petAge;
	private String petType; //Cat, Dog, Ferret, etc
	private String petOwner;
	
	//Constructor
	public Pet() {}

	//Public Methods
	public String getPetName() {
		return petName;
	}

	public void setPetName(String name) {
		petName = name;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int age) {
		petAge = age;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String type) {
		petType = type;
	}

	public String getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(String owner) {
		petOwner = owner;
	}

	
	

}
