
/**
 * The chest class creates chests that will appear in rooms, chests can hold items and gold 
 * for the player to use and pick up. Chests may require a key to be opened. 
 * 
 * @author 163318
 * @version 2.0
 */
public class Chests
{
    private boolean locked;
    private boolean isEmpty;
    private int money;
    
    /**
     * Constructor for objects of class Chests
     */
    public Chests(int money)
    {
        isEmpty = false;
        locked = true;
        this.money = money;
    }

    /**
     * Checks if the chest is locked 
     * @return if the chest is locked or not 
     */
    public boolean isLocked()
    {
        return locked;
    }
    
    /**
     * Unlocks the chest
     */
    public void unlockChest()
    {
        locked = false;
    }
    
    /**
     * Empties the chest
     */
    public void emptyChest()
    {
        isEmpty = true;
        money = 0;
    }

    /**
     * Returns how much money is in the chest and empties
     * @return number of gold pieces in the chest
     */
    public int moneyInside()
    {
        return money;
    }
    
}
