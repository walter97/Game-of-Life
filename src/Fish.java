/**
 * Concrete class that is a descendant of class Animal, and implements the features within that class.
 * Offers an array of strengths that correspond to age, ability to increment age, and to check maximum age.
 * 
 * @author Walter Ogozaly, Amy Grouse, and Carly Hoffman
 * @version 1.0
 *
 */

public class Fish extends Animal {
	
	int strength = -1;
	public final static int MAX_AGE = 4; 
	
	/**
	 * Constructor that creates a random Fish by
	 * calling the super constructor that does
	 * that in the Animal class.
	 */
	public Fish() {
		super();
	}

	/**
	 * Constructor that uses the parameters it is passed
	 * to create a Fish object with a predetermined age and
	 * gender.
	 * 
	 * @param age
	 * @param gender
	 */
	public Fish(int age, Gender gender) {
		super(age,gender);
	}
	
	/**
	 * Method that checks if the Fish object's age is less than the max,
	 * and returns True if that's the case. Otherwise, returns false.
	 * 
	 * @return boolean
	 */
	public boolean incrAge() {
		if (getAge() < MAX_AGE) {
			addAge();
			return true;
		}
		return false;
	}

	/**
	 * Checks if the Fish object's age is the maximum, and if so returns true. 
	 * Otherwise, returns false.
	 * 
	 * @return boolean
	 */
	public boolean maxAge() {
		if (getAge() == MAX_AGE) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the strength (always -1) of the fish. In reality this is used
	 * only to make it easier for the fish to be eaten by the bears.
	 * Fish never fight.
	 * 
	 * @return int
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * Function required by super class Animal that returns this
	 * class' unique maximum age for use within the super class.
	 * 
	 * @return int
	 */
	public int getMaxAge() {
		return MAX_AGE;
	}
	
}
