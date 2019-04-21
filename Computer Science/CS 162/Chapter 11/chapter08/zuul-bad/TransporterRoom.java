import java.util.Random;
import java.util.ArrayList;

/**
 * Write a description of class TransporterRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TransporterRoom extends Room
{
    private Random rnd;
    
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(String description)
    {
        super(description);
        rnd = new Random();
        
    }
    
    public Room getExit(String direction)
    {
        
        return findRandomRoom();
    }
    
    /**
     * Finds a random room.
     */
    public Room findRandomRoom()
    {
        System.out.println("You have been teleported!");
        ArrayList<Room> rooms = getRooms();
        
        return rooms.get(rnd.nextInt(rooms.size()));
    }
}
