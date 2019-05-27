
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private String description;
    private int weight;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight)
    {
        this.name = name;
        this.weight = weight;
        this.description = description;
    }

    /**
     * Returns the item name.
     *
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * Returns an items weight.
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Returns an items description.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Prints all the items information.
     */
    public void getInfo()
    {
        System.out.println(name);
        System.out.println("Weight: " + weight);
        System.out.println(description);
    }
}
