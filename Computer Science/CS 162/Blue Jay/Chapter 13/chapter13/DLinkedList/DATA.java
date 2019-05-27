import java.util.ArrayList;
//Done
/**
 * This class just holds a list of people in a static method so they can be called.
 *
 * @author Troy Jeffery
 * @version 5/26/2019
 */
public class DATA
{
    public static ArrayList<Person> peeps;
    
    public static void main(String[] args)
    {
        peeps = new ArrayList<>();
        Person troy = new Person("Troy", "Jeffery");
        Person ryan = new Person("Ryan", "Harris");
        Person maddy = new Person("Maddy", "Jeffery");
        Person israel = new Person ("Israel", "Adesanya");
        Person dog = new Person("Brown", "Dog");
        peeps.add(troy);
        peeps.add(ryan);
        peeps.add(maddy);
        peeps.add(israel);
        peeps.add(dog);
    }
    
    public static Person getPerson(int index)
    {
        peeps = new ArrayList<>();
        Person troy = new Person("Troy", "Jeffery");
        Person ryan = new Person("Ryan", "Harris");
        Person maddy = new Person("Maddy", "Jeffery");
        Person israel = new Person ("Israel", "Adesanya");
        Person dog = new Person("Brown", "Dog");
        peeps.add(troy);
        peeps.add(ryan);
        peeps.add(maddy);
        peeps.add(israel);
        peeps.add(dog);
        return peeps.get(index);
    }
    
}
