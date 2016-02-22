import static org.junit.Assert.assertEquals;

import junit.framework.*;
import junit.*;

public class RiverTest extends TestCase {
	
	private River r1; // test fixtures
	
	/*Called AUTOMATICALLY before each testXXX() is run*/
	protected void setUp(){
		r1 = new River(12);
	}
	
	/* Called AUTOMATICALLY after each testXXX() method is run */
	protected void tearDown() {
		r1 = null;
	}
	
	
	/** Test case 1.1: verify that default constructor sets 
    default instance variable values correctly
	 */
	public void testDefaultInstance() {
		assertEquals(12, r1.getLength());
	}
	
	
	/** Test case 1.2: verify that length function
	 * correctly returns length of River.
	 */
	public void testGetLength() {
		assertEquals(12, r1.getLength());
	}
	
	
	/** Test case 1.3: verify that Add Random function
	 * correctly adds an animal of the type passed to it
	 * to the list.
	 */
	public void testAddRandom() {

	}
	
	
	/** Run RiverTest as a text console application */
	public static void main(String args[]) {
	   junit.textui.TestRunner.main(new String[] {"RectangleTester"});
	}
}
