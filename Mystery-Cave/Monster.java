
/**
 * Write a description of class Monster here.
 * 
 * @author 163318
 * @version 2.0
 */
public class Monster
{
    private String name;
    private int health;
    private int damage;
    private boolean isDead;

    /**
     * Constructor for objects of class Monster
     * Monsters have a name, a given health and can do a given amount of damage.
     */
    public Monster(String name, int health, int damage)
    {
        this.name = name;
        this.health = health;
        this.damage = damage;
        isDead = false;
    }

    /**
     * A method to set the damage that a monster can deal
     * @param  x an int to set the damamge of the monster 
     */
    public void setDamage(int x)
    {
        damage = x;
    }
    
    /**
     * Returns the health of the monster
     * @return the monsters health
     */
    public int getHealth(){
        return health;
    }
    
    /**
     * Returns the damage of the monster
     * @return the monsters damage
     */
    public int getDamage()
    {
        return damage;
    }
    
    /**
     * A method to set the health of the monster
     * @param  x an int to set the health of the monster 
     */
    public void setHealth(int x)
    {
        health = x;
    }
    
    /**
     * Decreases the monsters health and checks the value of the health remaining
     * if the health is decreased to 0 the monster will die. 
     * @param x value to decrease the health of the monster 
     *
     */
    public void decreaseHealth(int x)
    {
        health = health - x;
        if (health < 1){
            isDead = true; 
        }
    }
    
    /**
     *Increases the monsters health
     *@param x value to decrease the health of the monster  
     */
    public void increaseHealth(int x)
    {
        health = health + x;
    }
    
}
