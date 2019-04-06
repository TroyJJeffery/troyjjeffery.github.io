import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;
    private Auction auction1;
    private Lot chindo;
    private Lot keyfi;
    private Lot taco;

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }

    /**
     * 
     */
    public void createScenario()
    {
        int n = 1;
        Person jack = new Person("Jack");
        Person jill = new Person("Jill");
        
        Lot chindo = new Lot((n++), "Used Chindo");
        Lot taco = new Lot((n++), "Taco");
        Lot keyfi = new Lot((n++), "Keyfi Meow Meow");

        auction1.enterLot("chindo");
        auction1.enterLot("taco");
        auction1.enterLot("keyfi");
        
        auction1.makeABid(1, jack, 569);
        auction1.makeABid(3, jill, 4545);
        
        close();
        
    }
    
    /**
     * Return a list of the unsold lots.
     */
    public ArrayList<Lot> getUnsold()
    {
        ArrayList<Lot> unsold = new ArrayList<Lot>();
        for(Lot lot: lots){
            Bid bid = lot.getHighestBid();
            
            if(bid == null){
                unsold.add(lot);
            }
        }
        return unsold;
    }
    
    
    /**
     * This method checks each lot item in the lots list for the highest bid.
     * If the bid returned is not null, then the item's information will be printed.
     * If null is returned the item is added to a list and printed.
     */
    public void close()
    {
        ArrayList noBid = new ArrayList<Lot>();
        System.out.println("The results of the auction are as follows:");
        
        System.out.println("*********************************************");
        for(Lot lot : lots){
            Bid bid = lot.getHighestBid();
            if(bid != null){
                System.out.println("Item Number: " + lot.getNumber());
                System.out.println("Item Description: " + lot.getDescription());
                System.out.println("We have a winner!");
                System.out.println("Bidder: " + bid.getBidder());
                System.out.println("*********************************************");
            }
        }
        System.out.println("The following items received no bids:");
        System.out.println(getUnsold());
    }

   
    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
    */
   
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }
 
    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            //Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(new Bid(bidder,value));
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Remove the lot with the given lot number.
     * @param number The number of the lot to be removed.
     * @return The Lot with the given number, or null if
     * there is no such lot.
     */
    public Lot removeLot(int lotToRemove)
    {
        int index = 0;
        int rmvLot = lotToRemove;
        boolean found = false;
        
        if(lotToRemove >= lots.size()){
            return null;
        }      
        else{            
            while(index <= lots.size() && index <= (lotToRemove - 1) && found == false){
                Lot lot = lots.get(index);
                     
                if((lots.get(index) == lots.get(rmvLot -1))){
                    found = true;
                }
                else{
                    index += 1;
                }        
            }       
        }
        return lots.get(index);
    }   

    
    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber)
    {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            return lots.get((lotNumber-1));
        }
        else {
            System.out.println("Lot number: " + lotNumber +
                               " does not exist.");
            return null;
        }
    }
}
