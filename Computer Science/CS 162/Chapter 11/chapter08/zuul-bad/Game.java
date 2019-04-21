import java.util.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private HashMap<String, String> revExits; // Contains a table with reverse exits.
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
        revExits = new HashMap<>();
        revExits();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room start, weaponStore, magicShop, armory, cathedral, path;
        TransporterRoom portal;
        
        // create the rooms
        start = new Room("You find yourself in a small outpost.");
        weaponStore = new Room("The entrance sign reads: Boris' Blades");
        magicShop = new Room("Many magical artifacts litter the room.");
        armory = new Room("The room shines with the reflection of well polished armor.");
        cathedral = new Room("Many people lay here in various states of illness.");
        path = new Room("A well worn path.");
        portal = new TransporterRoom("You goin for a ride, dawg.");
        
        // initialise room exits
        //start
        start.setExit("north", weaponStore);
        start.setExit("south", armory);
        start.setExit("west", path);
        //weaponStore
        weaponStore.setExit("south", start);
        //magicShop
        magicShop.setExit("south", path);
        //armory
        armory.setExit("north", start);
        //cathedral
        cathedral.setExit("north", path);
        //path
        path.setExit("north", magicShop);
        path.setExit("south", cathedral);
        path.setExit("east", start);
        path.setExit("west", portal);
        //transporter
        

        currentRoom = start;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
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
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")){
            look();
        }
        else if (commandWord.equals("inventory")){
            inventory();
        }
        else if (commandWord.equals("back")){
            Command back = new Command ("go",revExits.get(player.getLastDirection()));
            goRoom(back);
        }
        
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        
        if (nextRoom == null) {
            System.out.println("There is no exit!");
        }  
        if (nextRoom instanceof TransporterRoom){
            
        else {
            player.lastDirection(direction);
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
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
     * Prints the location info.
     */
    public void printLocationInfo()
    {
        System.out.print(currentRoom.getLongDescription());
        
    }    
    
    /**
     * Prints a description of the room that you are currently in.
     */
    public void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
        
    /**
     * Prints the players current inventory.
     */
    public void inventory()
    {
        System.out.print(player.getInventory());
    }
    
    /**
     * A table of reverse room values.
     */
    public void revExits()
    {
        revExits.put("north", "south");
        revExits.put("south", "north");
        revExits.put("east", "west");
        revExits.put("west", "east");
        
        }
        
}
