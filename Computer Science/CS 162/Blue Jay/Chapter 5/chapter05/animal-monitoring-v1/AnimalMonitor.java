import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Collection;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (imperative)
 */
public class AnimalMonitor 
{
    // Records of all the sightings of animals.
    private ArrayList<Sighting> sightings;
    
    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
    }
    
    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    public void addSightings()
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings("sightings.csv"));
    }
    
    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        sightings.forEach(record->System.out.println(record.getDetails()));
    }
    
    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        sightings.stream()
                 .filter(sighting -> animal.equals(sighting.getAnimal()))
                 .forEach(sighting -> System.out.println(sighting.getDetails()));
    }
    
    /**
     * Print all the sightings by the given spotter.
     * @param spotter The ID of the spotter.
     */
    public void printSightingsBy(int spotter)
    {
        sightings.stream()
                 .filter(s -> spotter == s.getSpotter())
                 .map(s -> s.getDetails())
                 .forEach(System.out::println);            
    }
    
    /**
     * Creats an ArrayList of all the animals that have been monitored.
     */
    public ArrayList<String> animalList()
    {
        ArrayList<String> animals = new ArrayList<>();
        
        sightings.stream()
                 .map(s -> s.getAnimal())
                 .forEach(s -> animals.add(s));
                 
        return animals;
                 
    }

    /**
     * Print a list of the types of animal considered to be endangered.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(int dangerThreshold)
    {
        HashMap<String,Integer> hashMap = new HashMap<>();  // Declares a hashMap for later.

        ArrayList<String> animals = animalList(); // Calls a method above that puts all
                                                  //animal names into an arrayList.
        
        for(String animal : animals){ //Stream to get total sightings for each animal.
            int x = 0;// Declares x and resets it each loop.
            x = sightings.stream()
                         .filter(s -> animal.equals(s.getAnimal()))// Filter by animal.
                         .map(s -> s.getCount())// Pull out count values.
                         .reduce(0, (a, b) -> a+b); // Reduce to a single int with a sum.
                         
            if(x<=dangerThreshold){// If the total for the animal is less than the
                                   //Threshold it adds it to the map.
                hashMap.put(animal, x);
                    }
                }
        System.out.println(hashMap.entrySet()); // Prints all entrys in the map.
    }
    
    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        int total = 0;
        for(Sighting sighting : sightings) {
            if(animal.equals(sighting.getAnimal())) {
                total = total + sighting.getCount();
            }
        }   
        return total;
    }
    
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        sightings.removeIf(sighting -> sighting.getCount() == 0);
    }
    
    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    public ArrayList<Sighting> getSightingsInArea(String animal, int area)
    {
        ArrayList<Sighting> records = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                if(record.getArea() == area) {
                    records.add(record);
                }
            }
        }
        return records;
    }
    
    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public ArrayList<Sighting> getSightingsOf(String animal)
    {
        ArrayList<Sighting> filtered = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                filtered.add(record);
            }
        }
        return filtered;
    }
           
        
    /**
     * Returns a list of all the sightings during a particular period.
     * @param period The index of the period.
     */
    public void printSightingsOn(int period)
    {
        sightings.stream()
                .filter(s -> s.getPeriod() == period)
                .forEach(s -> System.out.println(s.getDetails()));
    }
            
    /**
     * Prints all sightings of x animal on y period.
     * @param animal The animal you want data for. 
     * @param period On what period you want.
     */
    public void printAnimalSightingByPeriod(String animal, int period)
    {
        sightings.stream()
                 .filter(s -> animal.equals(s.getAnimal()))
                 .filter(s -> s.getPeriod() == period)
                 .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Prints the total count of the sightings of one animal.
     * @param animal The animal that you would like the count for.
     */
    public void printTotalSightingsOf(String animal)
    {
        sightings.stream()
                 .filter(s -> animal.equals(s.getAnimal()))
                 .map(s -> s.getCount())
                 .forEach(System.out::println);
                 
    }
   
    
    /**
     * Takes two paramters and returns the result.
     * @param spotter The spotter
     * @param period   The period
     */
    public String dayAndSpotter(int spotter, int period)
    {
                return
                        sightings.stream()
                                 .filter(s -> spotter == s.getSpotter())
                                  .filter(s -> period == s.getPeriod())
                                  .filter(s -> s.getCount() > 0)
                                  .map(s -> s.getAnimal())
                                  .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                                  .toString();      
    }
    
    
    /**
     * Returns a count of how many sightings were given for an animal, on a day, by a specific spotter.
     * @param animal The animal to get data for.
     * @param period The period to get data for.
     * @param spotter The spotter to get data for.
     * @return Returns a spotter's sightings of an animal on a specific day.
     */
    public int getSpottingsBySpotterByDayByAnimal(String animal, int period, int spotter)
    {
        int result = 
                sightings.stream()                                     // Type = Object
                         .filter(s -> animal.equals(s.getAnimal()))    // Removes everything but our animal.
                         .filter(s -> period == s.getPeriod())         // Removes everything but our period.
                         .filter(s -> spotter == s.getSpotter())       // Removes everything but our spotter.
                         .map(s -> s.getCount())                       // Reduces Sighting object to one variable.
                         .reduce(0, (a,b) -> a+b);                     // Combines "remaining" item into an int.
                 
        return result;     
    }         
    
    /**
     * Removes all records from a specificspotter.
     * @param spotter The spotter who's records you'd like to remove.
     */
    public void removeSpotter(int spotter)
    {
        sightings.removeIf(s -> spotter == s.getSpotter());
    }
    
    /**
     * Takes a spotter ID and counts up their total count.
     * @param spotter Spotter's ID to count for.
     * @return total Total sightings for the spotter.
     */
    public long getTotalSpots(int spotter)
    {
        return
        sightings.stream()
                 .filter(s -> spotter == s.getSpotter())
                 .count();
        }
    
        /**
         * Takes an animal as a and returns the highest count it had.
         * @param animal The animal who's records we need.
         * @return count The highest count.
         */
    public long highestCount(String animal)
    {
        return
                sightings.stream()
                         .filter(s -> animal.equals(s.getAnimal()))
                         .map(s -> s.getCount())
                         .max(Integer::compare)
                         .get();                        
        }
    
    /**
     * Takes a spotter and an animal name and returns the corresponding sighting record.
     * @param animal The animal who's record to use.
     * @param spotter the spotter to use.
     * @return record The sighting record that corresponds to the animal and spotter.
     */
    public Sighting animalSpotterIntersection(String animal, int spotter)
    {
        return
                sightings.stream()
                         .filter(s -> animal.equals(s.getAnimal()))
                         .filter(s -> spotter == s.getSpotter())
                         .findFirst()
                         .get();
    }
}
    