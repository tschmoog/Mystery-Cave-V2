import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Class Room - a room in an adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  163318
 * @version 2.0
 */

public class Room 
{
    private String description;
    private boolean hasKey;
    private boolean hasShop;
    private HashMap<String, Room> exits;// stores exits of this roomm
    private ArrayList<Monster> mobs = new ArrayList<Monster>(); //stores monsters in the room 
    private ArrayList<Chests> treasureChests = new ArrayList<Chests>(); //stores chests of the room
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a dark room" or
     * "an alcove".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        hasKey = false;
        hasShop = false; 
        exits = new HashMap<String, Room>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Checks to see wether the room has a key or not
     * @returns boolean 
     */
    public boolean isKey()
    {
        return hasKey;
    }
    
    /**
     * Sets the boolean as to wether the room contains a key to be found or not
     * @param x a boolean to set if the room contains a key or not
     */
    public void setKey(Boolean x)
    {
        hasKey = x; 
    }
    
    /**
     * Checks to see wether the room has a shop.
     * @returns boolean true if the room contains a shop, else false
     */
    public boolean hasShop()
    {
        return hasShop;
    }
    
    /**
     *  Sets the room to contain a shop
     *  @param x boolean true or false
     */
    public void setShop(Boolean x)
    {
        hasShop = x; 
    }
    
    /**
     * Adds a monster to the room
     * @param monster a monster object to be added to the room
     */
    public void setMonster(Monster monster)
    {
        mobs.add(monster);
    }
    
    /**
     * Adds a chest to the room
     * @param chest a chest object to be added to the room
     */
    public void setChest(Chests chest)
    {
        treasureChests.add(chest);
    }
    
    /**
     * Checks the room for chests
     * @return a boolean stating if the room contains any chests
     */
    public boolean checkRoomChest()
    {
        if (treasureChests.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Checks the room for monsters
     * @return a boolean stating if the room contains any monsters
     */
    public boolean checkRoomMonster()
    {
        if (mobs.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    
}

