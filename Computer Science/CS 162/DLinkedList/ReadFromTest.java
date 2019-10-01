

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ReadFromTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ReadFromTest
{
    ReadFrom rf;
    
    /**
     * Default constructor for test class ReadFromTest
     */
    public ReadFromTest()
    {
        ReadFrom rf = new ReadFrom();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        ReadFrom rf = new ReadFrom();
    }

    public void read() throws Exception
    {
        rf.readData();
        assertEquals(rf.readData().Equals("Finished."));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
