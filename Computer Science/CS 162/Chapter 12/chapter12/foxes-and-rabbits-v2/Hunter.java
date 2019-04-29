import java.util.List;
import java.util.Random;
import java.util.Iterator;
import java.util.Random;

/**
 * Write a description of class Hunter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hunter implements Actor
{
    private boolean alive;
    private List<Actor> actors;
    private Field field;
    private Location location;
    
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    
    public Hunter(Field field, Location location)
    {
        this.field = field;
        this.location = location;
    }
    
    public boolean isActive()
    {
        return alive;
    }
    
    protected Location getLocation()
    {
        return location;
    }
    
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    public void act(List<Actor> hunters)
    {
        Random rand = new Random();
        int width =rand.nextInt(field.getWidth());
        int depth = rand.nextInt(field.getDepth());
        Location newLoc = new Location(width, depth);
        setLocation(newLoc);
        sickBalls();
            
    }
    
    private void sickBalls()
    {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);   
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                rabbit.setDead();
                }
            }
            
        }
    }

    
