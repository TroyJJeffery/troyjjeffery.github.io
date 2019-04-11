import java.util.ArrayList;
import java.util.Iterator;



/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    public Club club;
    public ArrayList<Membership> members;
    
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        members = new ArrayList<>();
        //club = new Club();       
    }

    /**
     * Determine the number of members who joined in the given
     * month.
     * @param month The month we are interested in.
     * @return The number of members who joined in that month. 
     */
    public int joinedInMonth(int month)
    {
        int monthReq = month;
        int count = 0;
        
        if(month < 1 || month > 12) {
            System.out.println("Month request must be between 1 and 12.");
            return 0;
        }
        
        for(Membership membership : members){
            if(membership.getMonth() == monthReq){
                count += 1;
            }
        }
        return count;   
    }
    
    /**
     * Remove from the club's collection all members who
     * joined in the given month,
     * and return them stored in a separate collection object.
     * @param month The month of the membership.
     * @param year Theyear of the membership.
     * return The members who joined in the given month and year.
     */
    public ArrayList<Membership> purge(int month, int year)
    {
        ArrayList removedMembers = new ArrayList<Membership>();
        
        int rmvMonth = month;
        int rmvYear = year;
        int count = 0;
        
        if(month < 1 || month > 12) {
            System.out.println("Month request must be between 1 and 12.");
            return removedMembers;
        }
        
        for(Membership membership : members){
            
            if(membership.getMonth() == rmvMonth && membership.getYear() == rmvYear){
                removedMembers.add(members.toString());
                members.remove(count);
            }
            else{
                count += 1;
            }
            if(members.size() < 1){
                break;
            }
        }
        System.out.println(removedMembers.size());
        return removedMembers;
    }
    
    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
       members.add(member); 
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return members.size();
    }
}
