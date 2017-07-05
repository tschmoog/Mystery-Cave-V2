import java.util.ArrayList;
import java.util.HashMap;
/**
 * The Character class stores and returns data about the status of the Character.
 * This is updated as the game progresses by external events such as getting items
 * or taking damamge from a monster
 * 
 * @author 163318 
 * @version 2.0
 */
public class Character
{
    // stats belonging to the player character at the start of the game
    private int health;
    private int armour;
    private int mana;
    private int hunger;
    private int money;
    private int damage;
    private boolean hasKey;
    ArrayList<Item> inventory = new ArrayList<Item>(); //stores items the player has obtained
    
    public Character(int health, int armour, int mana, int hunger, int money, int damage)
    {
        this.health = health;
        this.armour = armour;
        this.mana = mana;
        this.hunger = hunger;
        this.money = money;
        this.damage = damage;
        hasKey = false; 
    }
   
    /**
     * Returns current health of the character
     * @return players health
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Returns current mana of the character
     * @return players mana
     */
    public int getMana()
    {
        return mana;
    }
    
    /**
     * Returns damamge of the player
     * @return players damage
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * Returns if the player has a key or not
     * @return whether the player has a key or not
     */
    public boolean gotKey()
    {
        return hasKey;
    }
    
    /**
     * Sets the value of hasKey()
     * @param a boolean. True if the player has a key, false otherwise
     */
    public void setKey(boolean x)
    {
        hasKey = x;
    }

    /**
     * Increases mana of the character
     * @param x increases the mana by x amount
     */
    public void increaseMana(int x)
    {
        mana = mana + x;
    }

    /**
     * Returns current hunger of the character
     * @return players hunger
     */
    public int getHunger()
    {
        return hunger;
    }

    /**
     * Increases the players health
     * @param x the value to increase the players health by
     */
    public void increaseHealth(int x)
    {
        health = health + x;
    }
    
    /**
     * Decreases the players health
     * @param x the value to decrease the players health by
     */
    public void decreaseHealth(int x)
    {
        health = health - x;
    }
    
    /**
     * Returns how much money the character has
     * @return player's money
     */
    public int getMoney()
    {
        return money;
    }

    /**
     * Increases characters money
     * @param x an int to increase players money by x amount 
     */
    public void increaseMoney(int x)
    {
        money = money + x;
    }

    /**
     * Decreases characters money
     * @param x an int for how much to decrease the money by
     */
    public void decreaseMoney(int x)
    {
        money = money - x;
    }

    /**
     * Adds item to inventory and adds items statistics to the character class 
     * @param x the item to be added to the list
     */
    public void addInventory(Item x)
    {
        inventory.add(x);
        damage = damage + 40;
    }
    
    /**
     * Returns the items in the inventory
     * @return an arraylist of the items in the inventory
     */
    public ArrayList getInventory()
    {
        return inventory;
    }

    /**
     * increases or decreases damage
     * @param x changes the characters dmamage by x amount 
     */
    public void changeDamage(int x)
    {
        damage = damage + x;
    }
}
