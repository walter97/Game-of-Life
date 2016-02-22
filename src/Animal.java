/**
 * Abstract class representing animals, with universal characteristics such as age and gender. Offers ability to retrieve
 * age, retrieve gender, produce a random gender, and increment age. Also allows for user-friendly String visualization.
 * 
 * @author Walter Ogozaly, Carly Hoffman and Amy Grouse
 * @version 1.0
 *
 */

public abstract class Animal {

	private Gender gender;
	private int age;
	
	
	public enum Gender {
		FEMALE, MALE
	}

	/**
	 * First constructor for the object Animal. Randomizes age and gender for the user.
	 */
	public Animal() {
		this.gender = getRandomGender();
		if (this instanceof Bear) {
			this.age = (int)(Math.random() * getMaxAge());
		}
		if (this instanceof Fish) {
			this.age = (int)(Math.random() * getMaxAge());
		}
	}
	
	/**
	 * Second constructor for the object Animal, which takes a fixed input of age and gender.
	 * 
	 * @param age
	 * @param gender
	 */
	public Animal (int age,  Gender gender) {
		this.age = age;
		this.gender = gender;
	}
	
	
	/**
	 * Simple function that returns the int age of the object Animal.
	 * 
	 * @return age
	 */
	public int getAge () {
		return age;
	}
	
	/**
	 * Simple function that returns the strength of the object Animal.
	 * 
	 * @return int
	 */
	abstract int getStrength();
	
	/**
	 * Simple function that returns the gender of type Gender of the object Animal.
	 * 
	 * @return gender
	 */
	protected Gender getGender() {
		return gender;
	}
	
	/**
	 * Function selects a gender at random and returns that gender.
	 * 
	 * @return gender
	 */
	public Gender getRandomGender() {
		int randNum = (int)(Math.random() * 2);
		if (randNum == 0) {
			return Gender.FEMALE;
		}
		else {
			return Gender.MALE;
		}
	}
	
	
	/**Abstract function that child classes will implement 
	 * to determine if the Animal is at its max age.
	 * 
	 * @return boolean
	 */
	abstract boolean maxAge();
	
	
	/**
	 * Abstract function that child classes will implement
	 * to increment the age of an animal if needed.
	 * 
	 * @return boolean
	 */
	abstract boolean incrAge();
	
	
	/**
	 * Increments age by one, and returns nothing.
	 */
	public void addAge() {
		++ age;
	}
	
	/**
	 * Abstract function that will have to be implemented, in which
	 * the animal returns its unique maximum age.
	 * 
	 * @return int
	 */
	abstract int getMaxAge();
	
	
	/**
	 * Returns a String representation of the animal. 
	 * @return String
	 */
	@Override
	public String toString() {
		String genderLetter;
		if (gender == Gender.MALE) {
			genderLetter = "M";
		}
		else {
			genderLetter = "F";
		}
		
		String animalLetter = this.getClass().getSimpleName().substring(0,1);
				
		return animalLetter + genderLetter + age;
	}
	
}
