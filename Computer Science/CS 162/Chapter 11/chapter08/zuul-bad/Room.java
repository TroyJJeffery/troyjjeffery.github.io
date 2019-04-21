import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;  // Stores exits of this room.
    private ArrayList<Item> items;
    private ArrayList<Room> roomList;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>(1);
        roomList = new ArrayList<>();
        roomList.add(this);
        
    }

    public ArrayList<Room> getRooms()
    {
        return roomList;
    }
    
    /**
     * List the items in the room (if any);
     */
    public void listItems()
    {
        System.out.println("You notice " + items + " here.");
    }
    
    /**
     * Add an item to the room.
     */
    public void addItem(Item name)
    {
        items.add(name);
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neightbor The room in the given direction 
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
        
    }

    /**
     * 
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
    
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }   
    
    /**
     * Return a description of the room's exits,
     * for example, "Exits: north west"
     * @return A description of the available exits.
     */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    /**
     * Return a long description of this room, of the form:
     *  You are in hte kitchen.
     *  Exits: north west
     *  @return String getLongDescription()
     */
    public String getLongDescription()
    {
        String desc = "You are " + description + System.lineSeparator();
        
        if(items.size() > 0){
            desc += "You notice " + items + " on the ground" + System.lineSeparator();
        }
        desc += getExitString();
        
        return desc;
    }

}
