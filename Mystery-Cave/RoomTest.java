

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 *
 * @author 163318
 * @version 2.0
 */
public class RoomTest
{
    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
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
     * Tests the room is displaying shops, keys and describing itself correctly. 
     */
    @Test
    public void RoomTest()
    {
        Room room1 = new Room("Generic Description");
        room1.setShop(true);
        Room room2 = new Room("Generic Description");
        room1.setExit("east", room2);
        room1.setKey(false);
        assertEquals(true, room1.hasShop());
        assertEquals("You are Generic Description.\nExits: east", room1.getLongDescription());
        assertEquals("Generic Description", room1.getShortDescription());
    }
}

