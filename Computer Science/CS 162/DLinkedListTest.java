import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DLinkedListTest.
 *
 * @author  Troy Jeffery
 * @version 5/26/2019
 */
public class DLinkedListTest extends DLinkedList
{
    private DLinkedList test = new DLinkedList<Person>();
    private Person troy = DATA.getPerson(0);
    private Person ryan = DATA.getPerson(1);
    private Person maddy = DATA.getPerson(2);
    private Person israel = DATA.getPerson(3);
    private Person brown = DATA.getPerson(4);
    
    /**
     * Default constructor for test class DLinkedListTest
     */
    public DLinkedListTest()
    {
    }
        
    /**
     * This test checks to make sure the updated contains method works.
     */
    @Test
    public void contains()
    {
        //setup
        test.addFirst(troy);
        Person shallowTroy = troy;
        Person deepTroy = new Person("deepTroy", "Jeffery");
        test.addFirst(deepTroy);
        test.addFirst(maddy);
        test.contains("Troy");
        test.contains("Ryan");
        
        assertEquals(test.contains("Maddy"), true);
        assertEquals(test.contains("Troy"), true);
        assertEquals(test.contains("Ryan"), false);
        assertEquals(test.contains("troy"), false);
        assertEquals(test.contains("deepTroy"), true);
        
    }
    //=====================================================================================
    //Add Tests
    //=====================================================================================
    /**
     * Runs all the add methods consecutively.
     */
    @Test
    public void testAddMethods()
    {
        addFirst();
        test.clear();
        
        addFirstx3();
        test.clear();
        
        addLast();
        test.clear();
        
        addLastx3();
        test.clear();
        
        first_last();
        test.clear();
    }
    
    /**
     * Tests putting a single item in the start position.
     */
    public void addFirst()
    {    
        final Person expected = troy;
        final int size = 1;
        //Act
        test.addFirst(troy);
        //Assert
        assertEquals(test.getStart().getType(), troy);
        assertEquals(test.getSize(), 1);    
    }
    
    /**
     * Tests adding 3 entries to the start position.
     */
    public void addFirstx3()
    {
        //Actors
        final Person end = troy;
        final Person mid = ryan;
        final Person start = maddy;
        final int size = 3;
        //Actions
        test.addFirst(troy);
        test.addFirst(ryan);
        test.addFirst(maddy);
        //Assert
        assertEquals(test.getStart().getType(), start);
        assertEquals(test.getStart().getNext().getType(), mid);
        assertEquals(test.getEnd().getType(), end);
        assertEquals(test.getSize(), size);    
    }
    
    /**
     * Tests adding an entry to the last place in the list.
     */
    public void addLast()
    {
        final Person expected = ryan;
        final int size = 1;
        //Action
        test.addLast(ryan);
        //Assertion
        assertEquals(test.getStart().getType(), ryan);
        assertEquals(test.getSize(), 1);
    }
   
    /**
     * Tests adding 3 entries to the last place on the list.
     */
    public void addLastx3()
    {
        //Actors
        final Person end = maddy;
        final Person mid = ryan;
        final Person start = troy;
        final int size = 3;
        //Actions
        test.addLast(troy);
        test.addLast(ryan);
        test.addLast(maddy);
        //Assert
        assertEquals(test.getStart().getType(), start);
        assertEquals(test.getStart().getNext().getType(), mid);
        assertEquals(test.getEnd().getType(), end);
        assertEquals(test.getSize(), size); 
    }
    
    /**
     * Tests adding an item to the first positon, then to the last.
     */
    public void first_last()
    {
        final Person end = ryan;
        final Person start = troy;
        final int size = 2;
        //Action
        test.addFirst(troy);
        test.addLast(ryan);
        //Assertions
        //Makes sure elements are in the right place.
        assertEquals(test.getStart().getType(), troy);
        assertEquals(test.getEnd().getType(), ryan);

        //Makes sure elements relationships are correct.
        assertEquals(test.getStart().getNext().getType(), ryan);
        assertEquals(test.getEnd().getNext().getType(), troy);
        assertEquals(test.getStart().getPrev().getType(),ryan);
        assertEquals(test.getStart().getPrev().getType(), ryan);
        //Checks the total number of elements.
        assertEquals(test.getSize(), 2);
    }
    
    /**
     * Tests adding to the first entry in a pre existing list.
     */
    public void addIndex0()
    {
        final Person end = ryan;
        final Person start = troy;
        final Person add = maddy;
        final int size = 3;
        
        //Actions
        test.addFirst(troy);
        test.addLast(ryan);
        test.add(0, maddy);
        //Assertions
        assertEquals(test.getStart().getType(), maddy);
        assertEquals(test.getEnd().getType(), ryan);
        assertEquals(test.getStart().getNext().getType(), troy);
        assertEquals(test.getEnd().getPrev().getType(), troy);
        assertEquals(test.getSize(), 3);
    }
    
    /**
     * Tests adding an entry to the first index of a list.
     */
    public void addIndex1()
    {       
        final Person end = ryan;
        final Person start = troy;
        final Person add = maddy;
        final int size = 3;
        
        //Actions
        test.addFirst(troy);
        test.addLast(ryan);
        test.add(1, maddy);
        //Assertions
        //Checks the start, end, and middle value.
        assertEquals(test.getStart().getType(), troy);
        assertEquals(test.getEnd().getType(), ryan);
        assertEquals(test.getStart().getNext().getType(), maddy);
        assertEquals(test.getEnd().getPrev().getType(), maddy);
        assertEquals(test.getSize(), 3);
    }   
    
    /**
     * Tests adding an item to the second index position.
     */
    public void addIndex2()
    {
        //Setup   
        DLinkedList test = new DLinkedList<Person>();
        Person ryan = new Person("Ryan", "Harris");
        Person troy = new Person("Troy", "Jeffery");
        Person maddy = new Person("Madison", "Jeffery");
        Person israel = new Person("Israel", "Adesanya");
        
        //Actors
        final Person end = ryan;
        final Person start = troy;
        final Person addI = israel;
        final Person addM = maddy;
        final int size = 4;
        
        //Actions
        test.addFirst(troy);
        test.addLast(ryan);
        test.add(1, maddy);
        test.add(2, israel);
        
        //Assertions
        //Checks the start, end, and middle value.
        assertEquals(test.getStart().getType(), start);  //i
        assertEquals(test.getEnd().getType(), end); //i-1
        assertEquals(test.getStart().getNext().getType(), addM);//i+1
        assertEquals(test.getStart().getNext().getNext().getType(), addI);//i+2
        assertEquals(test.getEnd().getPrev().getType(), addI);//i-2
        assertEquals(test.getSize(), size);
    }   
    
    //=====================================================================================
    //Add Tests
    //=====================================================================================
    /**
     * Runs all of the delete tests.
     */
    @Test
    public void deleteTest()
    {
        deleteFirst();
        test.clear();
        
        deleteFirst_Empty();//edge case
        test.clear();
        
        deleteLast();
        test.clear();
        
        deleteIndex0();
        test.clear();
        
        deleteIndex1();
        test.clear();
        
        deleteIndex2();
        test.clear();
        
        deleteIndexLast();
        test.clear();
        
        
    }
    
    /**
     * Tests adding two items and then deleting the first one.
     */
    public void deleteFirst()
    {
        //Actors
        final Person start = troy;
        final Person end = maddy;
        final int size = 2;
        //Actions
        test.addFirst(troy);
        test.addFirst(ryan);
        test.addLast(maddy);
        test.deleteFirst();
        
        //Assertions
        assertEquals(test.getStart().getType(), start);
        assertEquals(test.getStart().getNext().getType(), end);
        assertEquals(test.getEnd().getType(), end);
        assertEquals(test.getSize(), 2);
    }
    
    /**
     * Tests adding an item and then trying to remove the first item twice.
     */
    public void deleteFirst_Empty()
    {
        //Actions
        test.addFirst(troy);
        test.deleteFirst();
        test.deleteFirst();
        //Assert
        assertEquals(test.getStart(), null);
        assertEquals(test.getSize(), 0);
    }
    
    /**
     * Adds 3 items, deletes the last entry and checks relationships.
     */
    public void deleteLast()
    {
        //Actors
        final Person start = ryan;
        final Person end = troy;
        final int size = 2;
        //Actions
        test.addFirst(troy);
        test.addFirst(ryan);
        test.addLast(maddy);
        test.deleteLast();
        
        //Assertions
        assertEquals(test.getStart().getType(), start);
        assertEquals(test.getStart().getNext().getType(), end);
        assertEquals(test.getEnd().getType(), end);
        assertEquals(test.getSize(), 2);
    }
    
    /**
     * Tests adding 5 items and then deleting the first one.
     */
    public void deleteIndex0()
    {
        //Actors
        final Person start = troy;
        final Person second = ryan;
        final Person third = maddy;
        final Person fourth = israel;
        final Person end = brown;
        final int size = 4;
        //Actions
        test.addFirst(brown);
        test.addFirst(israel);
        test.addFirst(maddy);
        test.addFirst(ryan);
        test.addFirst(troy);
        test.delete(0);
        //Assert
        assertEquals(test.getStart().getType(), ryan);
        assertEquals(test.moveForward(test.getStart(), 1).getType(), maddy);
        assertEquals(test.moveForward(test.getStart(), 2).getType(), israel);
        assertEquals(test.moveForward(test.getStart(), 3).getType(), brown);
        assertEquals(test.moveBackward(test.getStart(), 1).getType(), brown);
        assertEquals(test.moveBackward(test.getStart(), 2).getType(), israel);
        assertEquals(test.moveBackward(test.getStart(), 3).getType(), maddy);
        assertEquals(test.getSize(), 4);
    }
    
    /**
     * Tests adding five items and then deleting the first index.
     */
    public void deleteIndex1()
    {
        //Actors
        final Person start = troy;
        final Person second = ryan;
        final Person third = maddy;
        final Person fourth = israel;
        final Person end = brown;
        final int size = 4;
        //Actions
        test.addFirst(brown);
        test.addFirst(israel);
        test.addFirst(maddy);
        test.addFirst(ryan);
        test.addFirst(troy);
        test.delete(1);
        //Assert
        assertEquals(test.getStart().getType(), troy);
        assertEquals(test.moveForward(test.getStart(), 1).getType(), maddy);
        assertEquals(test.moveForward(test.getStart(), 2).getType(), israel);
        assertEquals(test.moveForward(test.getStart(), 3).getType(), brown);
        assertEquals(test.moveBackward(test.getStart(), 1).getType(), brown);
        assertEquals(test.moveBackward(test.getStart(), 2).getType(), israel);
        assertEquals(test.moveBackward(test.getStart(), 3).getType(), maddy);
        assertEquals(test.getSize(), 4);
    }

    /**
     * Tests adding 5 items and then deleting the second index value.
     */
    public void deleteIndex2()
    {
        //Actors
        final Person start = troy;
        final Person second = ryan;
        final Person third = maddy;
        final Person fourth = israel;
        final Person end = brown;
        final int size = 4;
        //Actions
        test.addFirst(brown);
        test.addFirst(israel);
        test.addFirst(maddy);
        test.addFirst(ryan);
        test.addFirst(troy);
        test.delete(2);
        //Assert
        assertEquals(test.getStart().getType(), troy);
        assertEquals(test.moveForward(test.getStart(), 1).getType(), ryan);
        assertEquals(test.moveForward(test.getStart(), 2).getType(), israel);
        assertEquals(test.moveForward(test.getStart(), 3).getType(), brown);
        assertEquals(test.moveBackward(test.getStart(), 1).getType(), brown);
        assertEquals(test.moveBackward(test.getStart(), 2).getType(), israel);
        assertEquals(test.moveBackward(test.getStart(), 3).getType(), ryan);
        assertEquals(test.getSize(), 4);
    }
    
    /**
     * Tests adding 5 items and then deleting the value at getSize()
     */
    public void deleteIndexLast()
    {
        //Actors
        final Person start = troy;
        final Person second = ryan;
        final Person third = maddy;
        final Person fourth = israel;
        final Person end = brown;
        final int size = 4;
        //Actions
        test.addFirst(brown);
        test.addFirst(israel);
        test.addFirst(maddy);
        test.addFirst(ryan);
        test.addFirst(troy);
        test.delete(test.getSize());
        //Assert
        assertEquals(test.getStart().getType(), troy);
        assertEquals(test.moveForward(test.getStart(), 1).getType(), ryan);
        assertEquals(test.moveForward(test.getStart(), 2).getType(), maddy);
        assertEquals(test.moveForward(test.getStart(), 3).getType(), israel);
        assertEquals(test.moveBackward(test.getStart(), 1).getType(), israel);
        assertEquals(test.moveBackward(test.getStart(), 2).getType(), maddy);
        assertEquals(test.moveBackward(test.getStart(), 3).getType(), ryan);
        assertEquals(test.getSize(), 4);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
      test.clear();  
    }
}
