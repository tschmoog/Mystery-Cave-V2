

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MonsterTest.
 *
 * @author 163318
 * @version 2.0
 */
public class MonsterTest
{
    /**
     * Default constructor for test class MonsterTest
     */
    public MonsterTest()
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
     * Tests monsters health is being manipulated correctly and also it's damage. 
     */
    @Test
    public void MonsterTest()
    {
        Monster monster1 = new Monster("James", 100, 300);
        monster1.decreaseHealth(50);
        assertEquals(50, monster1.getHealth());
        monster1.increaseHealth(40);
        assertEquals(90, monster1.getHealth());
        assertEquals(300, monster1.getDamage());
        monster1.setDamage(40);
        assertEquals(40, monster1.getDamage());
    }
}

