/**
 * Program that simulates a river ecosystem with an array of object Animal with object Fish and object Bear and null.
 * Generates cells with random Animal objects or null, returns length of River (the array), updates the state of river,
 * adds random object Animal to river, and outputs in readable String.
 * 
 * @author Walter Ogozaly, Amy Grouse, and Carly Hoffman
 * @version 1.0
 *
 */

public class River {

	public Animal river[];
	private int length;
	private String riverCopy[];
	
	/**
	 * Constructor initializing a river (Animal[] array), and calling a method populateRiver(). 
	 * @param length
	 * @see populateRiver()
	 */
	public River(int length){
		// enable file access DON'T FORGET
		
		this.length=length;
		river=new Animal[length];
		int k = 0;
		populateRiver(river);
	}
	
	
	/**
	 * Works in conjunction with constructor to fill an Animal[] array river with object Fish, Bear, or null.
	 * Returns array river comprised of all Animal objects.
	 * @param river
	 * @return river array representing all the Animal objects within a river
	 */
	private Animal[] populateRiver(Animal [] river) {
		for(int i=0;i<this.length;i++){
			int k=(int)(Math.random()*3);
			if(k==0){
				river[i]=null;
			}
			else if(k==1){
				river[i]=new Bear();
			}
			else{
				river[i]=new Fish();
			}
		}
		return river;
	}
	
	
	/**
	 * Returns int variable length of river array
	 * @return int variable length representing length of river
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Simple function that returns the number of null cells within the river.
	 * 
	 * @return int
	 */
	public int numEmpty(){
		int count=0;
		for(int i=0; i<length; i++){
			if(river[i]==null){
				count++;
			}	
		}
		return count;
	}
	
	
	/**
	 * This method takes an Animal object and creates a random Animal of that type.
	 * It then places it in a random empty cell within the river array.
	 * 
	 * @param animal
	 * @return boolean
	 */
	public boolean addRandom(Animal animal){
		if (numEmpty() == 0) {
			return false;
		}
		
		int randomEmpty = (int)(Math.random() * numEmpty() + 1);
		int j = 0;
		while (randomEmpty > 0) {
			if(river[j]==null){
				randomEmpty--;
			}
			j += 1;
		}
		
		Animal.Gender gend = getRandGender();
			
		if (animal instanceof Bear) {
			river[j] = new Bear(0, gend);
		}
		else {
			river[j] = new Fish(0, gend);
		}
		
		riverCopy[j] = "complete";
		return true;
	}
	
	/**
	 * Helper function that generates a random gender for the addRandom function.
	 * 
	 * @return Gender
	 */
	public Animal.Gender getRandGender() {
		int randNum = (int)(Math.random() * 2);
		if (randNum == 0) {
			return Animal.Gender.FEMALE;
		}
		else {
			return Animal.Gender.MALE;
		}
	}
	
	/**
	 * Processes the object at cell i, and the action will depend on if
	 * the cell contains a bear or a fish or null.
	 * 
	 * @param i
	 */
	public void updateCell(int i) { // this could REALLY be cleaned up
		if (river[i] == null) {
			return;
		}
		
		river[i].incrAge();
		int move = (int)(Math.random() * 3);
		boolean didMove = false;
		
		// Test line
		System.out.println("Cell " + i + " is being updated now.");
		//
		
		
		if (move == 1) { // should be (move == 1)
			if (peekLeft(i) == null) {
				if (i == 0) {
					river[length - 1] = river[i];
					river[i] = null;
				}
				else {
					river[i-1] = river[i];
					river[i] = null;
				}
				
				// Test line
				System.out.println("Cell " + i + " moved to the left, filling a null.");
				//
				
			}
			else if(sameGender(river[i], peekLeft(i))) { // if they are the same gender, they must fight
				if (i == 0) {
					fight(i, length-1);
				}
				else {
					fight(i, i-1);
				}
				
				// Test line
				System.out.println("Cell " + i + " tried to move to the left, and fought with the animal it encountered.");
				//
				
			}
			else { // we know they are both animals of opposite genders
				if (sameSpecies(river[i], peekLeft(i))) { // if they are the same species they mate
					addRandom(river[i]);
					
					// Test line
					System.out.println("Cell " + i + " moved to the left and mated.");
					//
				}
				else { // otherwise they fight
					if (i == 0) {
						fight(i, length-1);
					}
					else {
						fight(i, i-1);
					}
					
					// Test line
					System.out.println("Cell " + i + " tried to move to the left, and fought with the animal it encountered.");
					//
				}
			}
		}
		
		else if (move == 2) { // should be (move == 2)
			if (peekRight(i) == null) {
				if (i == (length-1)) {
					river[0] = river[i];
					river[i] = null;
				}
				else {
					river[i+1] = river[i];
					river[i] = null;
					didMove = true;
				}
				
				// Test line
				System.out.println("Cell " + i + " moved to the right, filling a null.");
				//
				
			}
			else if(sameGender(river[i], peekRight(i))) { // if they are the same gender, they must fight
				if (i == (length-1)) {
					didMove = fight(i, 0);
				}
				else {
					didMove = fight(i, i+1);
				}
				
				// Test line
				System.out.println("Cell " + i + " tried to move to the right, and fought with the animal it encountered.");
				//
				
			}
			else { // we know they are both animals of opposite genders
				if (sameSpecies(river[i], peekRight(i))) { // if they are the same species they mate
					addRandom(river[i]);
					
					// Test line
					System.out.println("Cell " + i + " moved to the left and mated.");
					//
					
				}
				else { // otherwise they fight
					if (i == (length-1)) {
						didMove = fight(i, 0);
					}
					else {
						didMove = fight(i, i+1);
					}
					
					// Test line
					System.out.println("Cell " + i + " tried to move to the right, and fought with the animal it encountered.");
					//
					
				}
			}
			
		}
		
		// test thing here
		else if (move == 0) {
			// Test line
			System.out.println("Cell " + i + " stayed where it was.");
			//
		}
		
		riverCopy[i] = "complete";
		if (didMove) {
			riverCopy[i+1] = "complete";
		}
		
		// still have to implement maxAge();
	}
	
	private boolean fight(int i, int j) {
		if (river[i].getStrength() > river[j].getStrength()) {
			river[j] = river[i];
			river[i] = null;
			return true;
		}
		else if (river[i].getStrength() < river[j].getStrength()) {
			river[i] = null;
		}
		return false; // for didMove
	}
	
	private boolean sameGender(Animal animal, Object other) {
		String genderOne = animal.getGender().toString();
		String genderTwo = ((Animal)other).getGender().toString();
		
		return genderOne.equals(genderTwo);
	}
	
	private boolean sameSpecies(Animal animal, Object other) {
		String speciesOne = animal.getClass().getSimpleName();
		String speciesTwo = other.getClass().getSimpleName();
		
		return speciesOne.equals(speciesTwo);
	}
	
	private Object peekLeft(int i) {
		if (i == 0) {
			return river[length - 1];
		}
		return river[i-1];
	}
	
	private Object peekRight(int i) {
		if (i == (length - 1)) {
			return river[0];
		}
		return river[i+1];
	}
	
	
	/**
	 * Performs one cycle of the simulation, going through the cells of the river,
	 * updating ages, moving animals, creating animals, and killing animals.
	 */
	public void updateRiver() {
		//setting riverCopy
		riverCopy = new String[river.length];
		for(int i = 0; i<length; ++i) {
			riverCopy[i] = "incomplete";
		}
		
		for(int i = 0; i<length; ++i) {
			if (riverCopy[i].equals("incomplete")) {
				// Test print
				System.out.println("To confirm, we believe that index " + i + " is incomplete.");
				//
				updateCell(i);
			}
			else{
				System.out.println("Index " + i + " is complete.");
			}
		}
	}
	
	
	/**
	 * Standard toString() function that visualizes the river as an easily
	 * readable String.
	 */
	public String toString() {
		String rep = "";
		for (int i = 0; i < length; ++i) {
			rep += "[" + river[i] + "] ";
		}
		return rep;
	}

	
}
