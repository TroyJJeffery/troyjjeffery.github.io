//Done
/**
 * This class just holds a list of people in a static method so they can be called.
 *
 * @author Troy Jeffery
 * @version 5/26/2019
 */
public class Person implements Comparable<Person>
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
    
    public int compareTo(Person obj)
    {
        return this.getID().compareTo(obj.getID());
    }
    
    public boolean equals(Object object)
    {
        boolean b;
        
        //If the item is a deep copy, return true.
        if(this==object){b=true;}
        //If the item isn't of the same type, return false;
        else if(!(object instanceof Person)){b=false;}
        //compares the values of the two items, if they are equal return true;
        else if(firstName.equals(((Person)object).firstName)){b=true;}
        //For all other cases, return false;
        else{b=false;}
        return b;
    }
}
