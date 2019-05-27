//Done
/**
 * This class just holds a list of people in a static method so they can be called.
 *
 * @author Troy Jeffery
 * @version 5/26/2019
 */
public class Person
{
    //The Persons first name.
    private String firstName;
    //The Persons last name.
    private String lastName;
    // I made this a String using the first and last name.
    private String id;
    
    public Person(String first, String last)
    {
        firstName = first;
        lastName = last;
        setID();
    }
    
    //Setters
    public void setFirstName(String newName){firstName = newName;}
    public void setLastName(String newName){lastName = newName;}
    public void setID(){id = firstName.charAt(0)+ lastName;}
    
    //Getters
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getID(){return id;}
    
    public String toString()
    {
        return firstName + ", " + lastName + ", " + id;
    }
}
