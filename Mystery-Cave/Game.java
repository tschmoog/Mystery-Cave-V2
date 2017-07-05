import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 *  This class is the main class of the "Mystery Cave" application. 
 *  "Mystery Cave" is a very simple, text based adventure game. Users explore a cave
 *  in which they are unsure of how they got there.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  163318
 * @version 2.0
 */

public class Game extends JFrame 
{
    private Parser parser;
    public Room currentRoom;
    private Character player;
    private Item sword;
    private Monster ogre;
    private Chests chest;
    private UserLog log;

    //GUI components
    private GUI gui;

    /**
     * Create the game, parser character and initialise its internal map .
     */
    public Game() 
    {
        createRooms();
        createItems();

        parser = new Parser();
        player = new Character(100,0,0,0,0,10);
        ogre = new Monster("Ragnjk", 200, 20);
        chest = new Chests(250);
        log = new UserLog();
        
        //puts the game into play
        
    }

    /**
     * Create all the rooms and link their exits together.
     * Cave rooms ending in a number (e.g. cave3, cave5) lie along the main path to the final challenge.
     */
    private void createRooms()
    {
        Room cave_start, cave1, cave2, cave3, cave4, cave5, cave6, cave7, cave8, cave9, cave10, bossBattle,
        treasureRoom, armoury, deadEnd1, deadEnd2, deadEnd3, chestRoom1;

        // create the rooms
        cave_start = new Room("in a dark and damp smelling room, peering into the darkness \ndoes not bring anything into focus");
        cave1 = new Room("in a room which seems to resemble the last, a musty smell fills your nostrils.");
        cave2 = new Room("in a room similar to the ones previously, you cannot see much and the smell remains \npungent as ever");
        cave3 = new Room("overwhelmed by how musty the room is. You notice a small hole in the corner of the room");
        cave4 = new Room("starting to get a feel for the darkness and the layout of the cave");
        cave5 = new Room("growing acustomed to the smell and dim light");
        cave6 = new Room("starting to wonder how you got here in the first place. You see a ladder");
        cave7 = new Room("suprised as the smell worsens but the lighting improves");
        cave8 = new Room("in a dome shaped room, noticibly larger than the ones previously");
        cave9 = new Room("in what appears to be a dining room, you notice an ornate table in the centre");
        cave10 = new Room("terrified by loud grunts and the sound of cracking bones. Are you sure you want to continue?");
        bossBattle = new Room("BOSS BATTLE");
        treasureRoom = new Room("in a dimply lit room, a glint catches your eye"); 
        armoury = new Room("startled as you notice a man in full plate armour. 'You're alive?!' he booms \n 'You looked pretty beat up when the ogre dragged you in here'. \n I'm a merchant, I sell swords for killing beasts. \n They're good but they dont come cheap. 100 gold pieces please." );
        deadEnd1 = new Room("in a room that appears to be a dead end");
        deadEnd2 = new Room("in a tiny room, you notice a key lying on the floor");
        deadEnd3 = new Room("in a room that seems to lead nowhere");
        // initialise room exits
        cave_start.setExit("north", cave1);

        cave1.setExit("north", cave2);
        cave1.setExit("south", cave_start);

        cave2.setExit("north", cave3);
        cave2.setExit("south", cave1);

        cave3.setExit("down", deadEnd1);
        cave3.setExit("west", cave4);
        cave3.setExit("south", cave2);

        deadEnd1.setExit("up", cave3);

        cave4.setExit("east", cave3);
        cave4.setExit("south", cave5);
        cave4.setExit("west", deadEnd2); 

        deadEnd2.setExit("east", cave4);
        deadEnd2.setKey(true);

        cave5.setExit("north", cave4);
        cave5.setExit("west", cave6);

        cave6.setExit("east", cave5);
        cave6.setExit("up", cave7);
        cave6.setExit("west", deadEnd3);

        deadEnd3.setExit("east", cave6);

        cave7.setExit("down", cave6);
        cave7.setExit("up", cave8);
        cave7.setExit("east", armoury);

        armoury.setExit("west", cave7);
        armoury.setShop(true);

        cave8.setExit("down", cave7);
        cave8.setExit("west", cave9);

        cave9.setExit("east", cave8);
        cave9.setExit("south", treasureRoom);
        cave9.setExit("north", cave10);

        treasureRoom.setExit("north", cave9);
        treasureRoom.setChest(chest);

        cave10.setExit("south", cave9);
        cave10.setExit("up", bossBattle);

        bossBattle.setMonster(ogre);

        currentRoom = cave_start;  // start game at the starting cave section
    }

    /**
     * Creates items for play
     */
    private void createItems()
    {
        Item sword;
        sword = new Item("Sword");
        sword.setStat("damage", 40);

    }

    /**
     *  Main play routine. Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        
       



        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Mystery Cave");
        System.out.println("Mystery Cave is a game where you awaken dirty, tired and confused in a dark cave");
        System.out.println("You must find your way around a labyrinth of annoyingly similar rooms");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println("Your current health is: " + player.getHealth());
        System.out.println(currentRoom.getLongDescription());

    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.HEALTH){
            printHealth();
        }
        else if (commandWord == CommandWord.OPEN){
            openChest();
        }
        else if (commandWord == CommandWord.TAKE){
            takeItem();
        }
        else if (commandWord == CommandWord.BUY){
            buyItem();
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }

        // else command not recognised.
        return wantToQuit;
    }

    /**
     * Prints out the players inventory contents
     */
    private void printInventory()
    {
        System.out.println(player.getInventory());
    }

    /**
     * Adds items to players inventory
     * @param Item x the Item to be added to the inventory
     */
    private void addInventory(Item x)
    {
        player.addInventory(x);
    }

    /**
     * Returns the players current money
     */
    private int getMoney()
    {
        return player.getMoney(); 
    }

    /**
     * Adds health to the player
     * Prints out current health
     * @param x a value to increase the players health by
     */
    private void incHealth(int x)
    {
        player.increaseHealth(x);
        System.out.println("You have increased your HP by " + x);
        printHealth();
    }

    /**
     * Adds mana to the player 
     * Prints out current mana
     * @param x a value to increase players mana by
     * 
     */
    private void incMana(int x)
    {
        player.increaseMana(x);
        System.out.println("You have increased your mana by " + x);
        printMana();
    }

    // implementations of user commands:
    /**
     * Print out the players current health
     */
    private void printHealth()
    {
        System.out.println("You have " + player.getHealth() + " health");
    }

    /**
     * Print out the players current mana
     */
    private void printMana()
    {
        System.out.println("You have " + player.getMana() + " mana");
    }

    /**
     * Print out some help information.
     * Here we print the players current predicament and the 
     * command words that can be used.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You find yourself in a dark, damp cave");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room. 
     * 
     * Otherwise print an error message.
     * 
     * When entering the new room, the method checks for monsters and chests and prints according dialogue. 
     * Users journey information is also tracked within this method, printing to an external file
     * 
     * @param command the user command detailing which direction to take
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        
        //Write the direction the player has moved to an external file using the UserLog class.
        log.writeToFile(direction);

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;

            System.out.println(currentRoom.getLongDescription());
            System.out.println("");

            if (currentRoom.checkRoomMonster() == true){
                System.out.println("A huge ogre looms before you");
                battle();

            }
            if (currentRoom.checkRoomChest() == true){
                System.out.println("You see a beautiful treasure chest");

            }
        }
    }

    /**
     * Tries to take the key if one is in the room  
     * If there is nothing in the room an error message is returned
     */
    private void takeItem()
    {
        if (currentRoom.isKey() == true ){
            player.setKey(true);
            System.out.println("You picked up a key! Who knows what it will open?");
            currentRoom.setKey(false);
        }
        else{
            System.out.println("There is nothing to take.");
        }
    }

    /**
     * Tries to purchase goods from a shop
     * If the room does not contain a shop, an error is returned.
     */
    private void buyItem()
    {
        if (currentRoom.hasShop() == true){
            if (player.getMoney() > 100){
                addInventory(sword);
                player.decreaseMoney(100);
                System.out.println("Many thanks pal, that'll add another 40 damage to ya");
                System.out.println("You have " + getMoney() + " gold pieces left");

            }
            else{
                System.out.println("Ha-Ha-Ha, come back when you're not so broke matey");
            }
        }
        else{
            System.out.println("There is nothing to buy here!?");
        }
    }

    /**
     * Tries to open a chest if there is a chest in the room and player has a key.
     * Otherwise, prints an error message 
     */
    private void openChest()
    {
        if (currentRoom.checkRoomChest() == true){
            if (player.gotKey() == true){
                player.increaseMoney(chest.moneyInside());
                System.out.println("You hit the jackpot! You now have " + getMoney() + " gold pieces!!!");
                chest.emptyChest();

            }
            else{
                System.out.println("You need a key to open this");
            }

        }
        else
        {
            System.out.println("There is nothing to open in here!");
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     * @param command the command given by the user
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Method to get the players money
     * @return how much gold the player currently has
     */
    private int getPlayerMoney()
    {
        return player.getMoney();
    }

    /**
     * Decreases the players money
     * @param x how much to deduct from the player
     */
    private void decreasePlayerMoney(int x)
    {
        player.decreaseMoney(x);
    }

    /**
     * Adds an item to the players inventory
     * @param x an Item object to be added to the players inventory
     */
    private void addPlayerInventory(Item x)
    {
        player.addInventory(x);
    }

    /**
     * Method used to find out how much damage the player can do
     * @return player's damage
     */
    private int getPlayerDmg()
    {
        return player.getDamage();
    }

    /**
     * Gets the damage that the monster object can deal
     * @return the damage of the monster
     */
    private int getMonsterDmg()
    {
        return ogre.getDamage();
    }

    /**
     * Initiates a battle between a player and monster
     */ 
    private void battle()
    {
        while (ogre.getHealth() > 0 && player.getHealth() > 0)
        {
            System.out.println();

            System.out.println("The monster atacks you for " + ogre.getDamage() + " damage!");
            player.decreaseHealth(getMonsterDmg());
            printHealth();

            System.out.println();

            System.out.println("You attack the monster for " + getPlayerDmg() + " damage!");
            ogre.decreaseHealth(getPlayerDmg());
            System.out.println("The ogre has " + ogre.getHealth() + " health remaining");
        }
        if (ogre.getHealth() == 0 || ogre.getHealth() < 0)
        {
            System.out.println("Congratulations! You have slain the ogre and may exit the cave.\n Type 'quit' to end");
        }

        if (player.getHealth() == 0 || player.getHealth() < 0)
        {
            System.out.println("You have been slain. Maybe try coming back with a weapon? \nType 'quit' to end and try again");
        }

    }

}
