import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    private Product test;
    
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        int count = 0;
        Product newItem = item;
                if(stock.size() == 0){
                    stock.add(item);
                }
                else{
                        Product comparison = stock.get(count);   
                    if(item.getID() == comparison.getID()){
                        System.out.println("This ID is already in use");
                    }
                    else{
                        stock.add(item);
                }
            }   
        }
    
    /**
    * 
    */
    public Product findProduct(String name)
    {
        boolean found = false;
        int index = 0;
        
        while(index < stock.size()){
            if((stock.get(index).getName() == name)){           
            return stock.get(index);
        }
        }
        return null;
    }
    
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        if(findProduct(id) == null){
            System.out.println("No product found.");
        }
        else{
            findProduct(id).increaseQuantity(amount);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        int currentItem = 0;
        int searchedItem = id;
        boolean found = false;
        
            if(searchedItem < 1 || searchedItem > stock.size()){
                System.out.println("Item index out of index range.");
                System.out.println("1 - " + stock.size());
            }
            else{    
                while(currentItem < stock.size() && found == false){
                    if(stock.get(currentItem) == stock.get(searchedItem - 1)){
                        System.out.println(stock.get(currentItem).getID());
                        found = true;
                        return stock.get(currentItem);
                    }
                    else{
                        currentItem =+ 1;
                    }
                }
            }
            return null;
        }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        if(findProduct(id) == null){
            return 0;
        }
        else{
            
            return findProduct(id).getQuantity();
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product product : stock){
            System.out.println("*******************************");
            System.out.println(product.toString());   
        }
    }
    
    
    /**
     * 
     */
    public void checkInventory(int inventoryThreshold)
    {
        
        for(Product product : stock){
            if(product.getQuantity() < inventoryThreshold){
                System.out.println(product.toString());
            }
    }
    }
}
