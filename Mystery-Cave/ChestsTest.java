

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ChestsTest. Tests chest functionality
 *
 * @author 163318
 * @version 2.0
 */
public class ChestsTest
{
    /**
     * Default constructor for test class ChestsTest
     */
    public ChestsTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
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

    
     /**
     * Tests if the chest is locked 
     */
    @Test
    public void LockedTest()
    {
        Chests chests1 = new Chests(100);
        assertEquals(true, chests1.isLocked());
    }

    /**
     * Tests if the chest can be empited of all it's wonderful bounty 
     */
    @Test
    public void EmptyChest()
    {
        Chests chests1 = new Chests(100);
        chests1.emptyChest();
        assertEquals(0, chests1.moneyInside());
    }

    /**
     * Calls chest unlock command and 
     * tests if the chest is unlocked 
     */
    @Test
    public void UnlockChest()
    {
        Chests chests1 = new Chests(100);
        chests1.unlockChest();
        assertEquals(false, chests1.isLocked());
    }
}



