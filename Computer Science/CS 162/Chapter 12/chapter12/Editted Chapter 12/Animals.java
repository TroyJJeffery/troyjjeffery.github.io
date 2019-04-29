import java.util.Random;
import java.util.List;

/**
 * Abstract class Animals - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Animals
{
    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.12;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    // The animal's age.
    private int age;
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's position.
    private Location location;
    // The field occupied.
    private Field field;
    
    /**
     * Check whether the fox is alive or not.
     * @return True if the fox is still alive.
     */
    public boolean isAlive()
    {
        return alive;
    }
    
    /**
     * Return the fox's location.
     * @return The fox's location.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the fox at the new location in the given field.
     * @param newLocation The fox's new location.
    */
    private void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Increase the age. This could result in the fox's death.
     */
    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }
    
        /**
     * Check whether or not this fox is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newFoxes A list to return newly born foxes.
    */
    private void giveBirth(List<Fox> newFoxes)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        List<Location> free = field.getFreeAdjacentLocations(location);
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Fox young = new Fox(false, field, loc);
            newFoxes.add(young);
        }
    }
        
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }

    /**
     * A fox can breed if it has reached the breeding age.
     */
    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }

    /**
     * Indicate that the fox is no longer alive.
     * It is removed from the field.
     */
    private void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
}
