/**
 * Concrete class that is a descendant of class Animal, and implements the features within that class.
 * Offers an array of strengths that correspond to age, ability to increment age, to check maximum age,
 * and to return the strength of the object Bear.
 * 
 * @author Walter Ogozaly, Carly Hoffman, and Amy Grouse
 * @version 1.0
 *
 */

public class Bear extends Animal {
	
	private int strength[] = {1, 2, 3, 4, 4, 4, 3, 2, 1, 0};
	public final static int MAX_AGE = 9;
	
	/**
	 * Constructor that sets up a random Bear object by calling the super constructor.
	 */
	public Bear() {
		super();
	}
	
	
	/**
	 * Constructor that sets up a Bear object with the parameters passed, age and gender.
	 * 
	 * @param age
	 * @param g
	 */
	public Bear(int age, Gender g) {
		super(age,g);
	}
	
	/**
	 * Method that checks if the Bear object's age is less than the max,
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
	 * Checks if the Bear object's age is the maximum, and if so returns true. 
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
	 * Function required by super class Animal that returns this
	 * class' unique maximum age for use within the super class.
	 * 
	 * @return int
	 */
	public int getMaxAge() {
		return MAX_AGE;
	}
	
	/**
	 * Returns the strength (0-4) of the bear by retrieving its age
	 * and returning the index of the strength array that cooresponds
	 * to that age.
	 * 
	 * @return int
	 */
	public int getStrength() {
		return strength[getAge()];
	}


}
