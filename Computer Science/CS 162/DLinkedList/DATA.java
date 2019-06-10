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
    public static ArrayList data;
    
    public DATA()
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
    
    public static void main(String[] args)
    {

    }
    public static ArrayList getPeeps()
    {
        return peeps;
    }
    
    
    public static Person getPerson(int index)
    {
        return peeps.get(index);
    }
    
    public static ArrayList getList() throws Exception
    {
        ArrayList al = new ArrayList();
        ReadFrom rf = new ReadFrom();
        
        al.add(rf.readData());
        return al;
    }
    
}