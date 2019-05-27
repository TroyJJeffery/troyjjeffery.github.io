import java.util.*;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private ArrayList<String> inventory;
    private String lastDirection;
    
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        inventory = new ArrayList<>();
        lastDirection = null;
    }

    /**
     * Returns the contents of the players inventory.
     *
     */
    public ArrayList getInventory()
    {
        return inventory;
    }
    
    /**
     * Set's last direction.
     */
    public void lastDirection(String direction)
    {
        lastDirection = direction;
    }
    
    /**
     * Returns the last room the player was in.
     */
    public String getLastDirection()
    {
        return lastDirection;
    }
    
}
