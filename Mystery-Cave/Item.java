import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * This class creates items and sets their attributes. These attributes are passed onto the player
 * when an item is added to the players inventory. 
 * 
 * @author 163318
 * @version 2.0
 */
public class Item
{
    private String name;
    private HashMap<String, Integer> stats = new HashMap<String, Integer>();//stores the statistics of the item and their value 
     
    /**
     * Constructor for objects of class Items
     */
    public Item(String name)
    {
        this.name = name;
        stats = new HashMap<String, Integer>(); 
    } 
    
    /**
     * Get the name of the item 
     * @return the name of the item 
     */
    public String getName()
    {
        return name;
    }
        
    /**
     * Define a stat for this item 
     * @param stat the type of stat
     * @param value the value of the stat
     */
    public void setStat(String stat, int value)
    {
        stats.put(stat, value);
    }
    
    /**
     * Gets the statistics of the item
     * @return the hashmap containing the type of stat as key and an int for the value of the stat.
     */
    public HashMap getStat()
    {
        return stats;
    }
    
}
