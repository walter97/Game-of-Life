/**
 * Program that simulates the river and acts a base for the main() function and all major commands.
 * 
 * @author Walter Ogozaly, Carly Hoffman, and Amy Grouse
 *
 */
public class RiverSimulator {

	public static void main(String[] args) {
		
		Bear bear = new Bear(0, Animal.Gender.FEMALE); // convenience object
		Fish fish = new Fish(); // convenience object
		
		River our_river = new River(12);
		System.out.println(our_river.toString());
		
		

		our_river.updateRiver();
		
		System.out.println(our_river.toString());
		
		
	}
}
