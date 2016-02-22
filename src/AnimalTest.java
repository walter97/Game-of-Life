import static org.junit.Assert.assertEquals;

import junit.framework.*;
import junit.*;


	public class AnimalTest extends TestCase {
	
		private Bear b1,b2;//test fixtures
		private Fish f1,f2;//test fixtures
		
		/*Called AUTOMATICALLY before each testXXX() is run*/
		protected void setUp(){
			b1 = new Bear();
			b2 = new Bear(4,Animal.Gender.MALE);
			f1 = new Fish();
			f2 = new Fish(2,Animal.Gender.FEMALE);
		}
		
		/* Called AUTOMATICALLY after each testXXX() method is run */
		protected void tearDown() {
			b1 = null;
		    b2 = null;
		    f1 = null;
		    f2 = null;
		}
		
		/** Test case 1.1: verify that default constructor sets 
	    default instance variable values correctly
		 */
		public void testDefaultInstance() {
			assertTrue(0 <= b1.getAge() && b1.getAge() <= 9);
			assertTrue(b1.getGender().equals(Animal.Gender.FEMALE) || 
					b1.getGender().equals(Animal.Gender.MALE));
			
			assertEquals(4,b2.getAge());
			assertEquals(Animal.Gender.MALE,b2.getGender());
			
			assertTrue(0 <= f1.getAge() && f1.getAge() <= 4);
			assertTrue(f1.getGender().equals(Animal.Gender.FEMALE) || 
					f1.getGender().equals(Animal.Gender.MALE));
		
			assertEquals(2,f2.getAge());
			assertEquals(Animal.Gender.FEMALE, f2.getGender());
		}
		
		/** Test case 1.2: verify that default constructor sets 
	    default instance variable values correctly 
		*/
		public void testToString(){
			int age;
			
			String b1String = b1.toString();
			assertTrue(b1String.substring(0,1).equals("B"));
			assertTrue(b1String.substring(1, 2).equals("M") || b1String.substring(1, 2).equals("F"));
			age = Integer.parseInt(b1String.substring(2));
			assertTrue(0 <= age && age <= 9);
			
			assertEquals("BM4",b2.toString());
					
			String f1String = f1.toString();
			assertTrue(f1String.substring(0,1).equals("F"));
			assertTrue(f1String.substring(1, 2).equals("M") || f1String.substring(1, 2).equals("F"));
			age = Integer.parseInt(f1String.substring(2));
			assertTrue(0 <= age && age <= 9);
			
			assertEquals("FF2",f2.toString());
		}
		
		/** Test case 1.3: verify that Bear and Fish classes return
		 * correct boolean value after incrementing age.
		*/
		public void testIncrAge() {
			assertTrue(true == b1.incrAge() || false == b1.incrAge());
			assertEquals(true || false, b2.incrAge());
			assertTrue(true == f1.incrAge() || false == f1.incrAge());
			assertEquals(true , f2.incrAge());
		}
		
		/** Test case 1.4: verify that Bear and Fish classes return 
		 * false if not at max age, and true if at max age.
		*/
		public void testMaxAge() {
			assertTrue(true == b1.maxAge() || false == b1.maxAge());
			assertEquals(false, b2.maxAge());
			assertTrue(true == f1.maxAge() || false == f1.maxAge());
			assertEquals(false, f2.maxAge());
		}
		
		/** Test case 1.5: verify that the Bear objects return the correct
		 * strength for their age.
		*/
		public void testGetStrength() {
			assertTrue(0 <= b1.getStrength() && b1.getStrength() <= 4);
			assertEquals(4, b2.getStrength());
		}
		
		
		/** Run AnimalTest as a text console application */
		public static void main(String args[]) {
		   junit.textui.TestRunner.main(new String[] {"RectangleTester"});
		}
		 
}
