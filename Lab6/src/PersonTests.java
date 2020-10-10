
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;


public class PersonTests {
    
    ArrayList<Person> list = new ArrayList<Person>();
	Person p1;
	Person p2;
	Person p3;
	
	Person e1;
    
    Student s1;
	
	@Before
	public void setUp()
	{
		p1 = new Person("Mai", "3156 Grove Rd, Somewhere");
		p2 = new Person("Steve", "001 Terrace Road, Streetsville");
		p3 = new Person("Jimmy", "12345 Six Street, Right here");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		e1 = new Employee("Don", "6562 Trask Way, Elsewhere", "Front Desk", 2110);
		list.add(e1);
        
        // UNCOMMENT THIS LINE AND FILL IN THE STUDENT CONSTRUCTOR AFTER CREATING YOUR STUDENT CLASS
         s1 = new Student();
         list.add(s1);
	}
	
	@Test
	public void testPersonEmployee() 
	{	
		// This test makes sure that the toString() methods for the provided classes work as intended.
		assertEquals("toString", "{Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|", list.get(0).toString());
		assertEquals("toString", "{Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}", list.get(3).toString());
	}
	
	@Test
	public void testPersonEmployeeStudent() 
	{
		boolean control = true;
		
		for (Person person: list) {
			if (!(person instanceof Person)){
				control = false;
			}
		}
		assertTrue("Is every object in the list a Person", control);
	}
	
	@Test
	public void testCollectionsSort() 
	{
		// TODO: Use Collections.sort(/*List*/) to sort the list of Person objects.
		/* Hint: make sure you've implemented Comparable and Comparator, as those are important
         * for Collections.sort(List) to use.
         */
		
		
		String sortedList;
		sortedList = "[{Person: name=?, homeAddress=?|, {Empl: n=Don, ha=6562 Trask Way, Elsewhere, wa=Front Desk, id=2110}, {Person: name=Jimmy, homeAddress=12345 Six Street, Right here|, {Person: name=Mai, homeAddress=3156 Grove Rd, Somewhere|, {Person: name=Steve, homeAddress=001 Terrace Road, Streetsville|]";
		Collections.sort(list);
		
		assertEquals("test", sortedList, list.toString());
	
	}
	
	public void testCollectionsSortAddress() {
		Collections.sort(list, new CmpByAddress());
		System.out.println("Sorted alphabetically by address: " + list);
	}
	
    // ACTIVITY 5
     @Test
     public void testGetClass() {
          System.out.println("p3.getName(): " + p3.getClass().getName());
    		System.out.println("p3.getSimpleName(): " + p3.getClass().getSimpleName());
    		System.out.println("p3.getCanonicalName(): " + p3.getClass().getCanonicalName());
     }
}