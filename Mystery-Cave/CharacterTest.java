

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CharacterTest This tests the Character class
 *
 * @author  163318
 * @version 2.0
 */
public class CharacterTest
{
    /**
     * Default constructor for test class CharacterTest
     */
    public CharacterTest()
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
     * Increments and decrements characters health and tests values 
     */
    @Test
    public void TestHealth()
    {
        Character characte1 = new Character(100, 0, 0, 0, 100, 100);
        characte1.decreaseHealth(99);
        assertEquals(1, characte1.getHealth());
        characte1.increaseHealth(101);
        assertEquals(102, characte1.getHealth());
    }

    /**
     * Increments and decrements characters money and tests values 
     */
    @Test
    public void TestMoney()
    {
        Character characte1 = new Character(100, 0, 0, 0, 50, 100);
        characte1.increaseMoney(50);
        assertEquals(100, characte1.getMoney());
        characte1.decreaseMoney(10);
        assertEquals(90, characte1.getMoney());
    }

    
    /**
     * Increments characters damage and tests values 
     */    
    @Test
    public void TestDamage()
    {
        Character characte1 = new Character(10, 0, 0, 0, 0, 100);
        characte1.changeDamage(30);
        assertEquals(130, characte1.getDamage());
    }
}




