//Done
/**
 * Responsible for manipulating the lists values and orders.
 *
 * @author Troy Jeffery
 * @version 5/25/2019
 */
public class DLinkedList<T>
{
    private Node start;
    private Node end;
    private int size;
    
    public void main (String[] args){ 
    DLinkedList<T> list = new DLinkedList<>();
    
    }
    
    public DLinkedList()
    {
        start = null;
        end = null;  
    }
    
    //=====================================================================================
    //Add Methods
    //=====================================================================================
    /**
     * Takes an object and sets it as the first entry in the list.
     * @param type Object to insert.
     */
    void addFirst(T type)
    {
        Node<T> node = new Node<T>(type, null, null);

        if(getStart() == null){
            makeFirst(type);
        }
        else{
            node.setNext(start);
            node.setPrev(start.getPrev());
            
            start.setNext(start.getNext());
            start.setPrev(node);
           
            start = node;
        }
       size++;
    }
    
    /**
     * Takes an object and inserts it at the end of the list.
     * @param type The item to be inserted.
     */
    void addLast(T type)
    {
        Node<T> node = new Node<T>(type, null, null);
        
        if(getStart() == null){
            makeFirst(type);
        }
        else{
            Node temp = getStart().getPrev();
            
            //Sets next reference to the old end node.
            temp.setNext(node);
            //Sets previous refeerence to the new node.
            node.setPrev(temp);
            //Sets next reference for the new node.
            node.setNext(start);
            //Sets previous reference for the start node.
            start.setPrev(node);
            //Updates end node for the list.
            end = node;
        }
        size++;
    }  
    
    /**
     * Helper method that will create the first item if no items are found.
     * @param type Object to be inserted.
     */
    private void makeFirst(T type)
    {
        Node<T> node = new Node<T>(type, null, null);
        
        if(getStart() == null){
            node.setNext(node);
            node.setPrev(node);
                
            start = node;
            end = node;
        }
    }
    
    /**
     * Takes an object and puts it at a specific index.
     * @param index The index value you want the item placed.
     * @param type The object to insert there.
     */
    void add(int index, T type)
    {
       if(getSize() < index || index < 0){
           System.err.println("Must add within index.\n" + 
                              "Current Size is :" + getSize());
                            }
       else if(index == 0){addFirst(type);}
       else if(index == getSize()){addLast(type);}
       else{
             Node i = getStart();
             int count = 0;
            
             while(count!=index){
                 i = i.getNext();
                 count++;
             }
             Node iminus1 = i.getPrev();
             Node iplus1 = i.getNext();
                
             Node newNode = new Node(type, iminus1, i);
                
             iminus1.setNext(newNode);
             i.setPrev(newNode);
                
             size++;
            }
    }
    //=====================================================================================
    //Delete Methods
    //=====================================================================================
    /**
     * Helper method that removes an item if it is the last one.
     */
    private void deleteOne()
    {
            if(getSize() == 1){
            Node x = getStart();
            erase(x);
            
            start = null;
            end = null;
            size = 0;
        }
        else{
            System.err.println("List size is not one!" + getSize());
        }  
    }
    
    /**
     * Set's all of a nodes values to null, calls the garbage collector and reduces size.
     * Helper method to reduce code duplication.
     * @param i The node to be erased.
     */
    private void erase(Node i)
    {
        i.setNext(null);
        i.setPrev(null);
        i.setType(null);
        System.gc();
        size--;
    }
    
    /**
     * Allows the user to remove a node and updates it's neighbors pointers.
     * @param index The index value to delete.
     */
    void delete(int index)
    {
        if(getSize() < index || index < 0){
            System.err.println("Must add within index.\n" + 
                               "Current Size is :" + getSize());
            return;
        }
        else if(index == 0){
            deleteFirst();
        }
        else if(getSize() == 1){
            deleteOne();
        }
        else if(getSize() == index){
            deleteLast();
        }
        else{
            Node i = moveForward(getStart(), index);
            Node iMinus1 = i.getPrev();
            Node iPlus1 = i.getNext();
            
            iMinus1.setNext(iPlus1);
            iPlus1.setPrev(iMinus1);
            erase(i);
        }   
    }
    
    /**
     * Delete's the last item in the list.
     */
    void deleteLast()
    {
        try {
            int i = 1/getSize();        
        }
        catch (Exception e) {
            System.out.println("The list is empty!");
            return;
        }
        
        if(getSize() ==1){
            deleteOne();
        }      
        else{
            Node i = getEnd();
            Node iMinus1 = getEnd().getPrev();
            Node iPlus1 = getStart();
            
            setEnd(iMinus1);
            iMinus1.setNext(getStart());
            iPlus1.setPrev(getEnd());
            
            erase(i);
        } 
    }
    
    /**
     * Deletes the first item in the list.
     */
    void deleteFirst()
    {
        try {
            int i = 1/getSize();        
        }
        catch (Exception e) {
            System.out.println("The list is empty!");
            return;
        }
        
        if(getSize() ==1){
            deleteOne();
        }      
        else{
            Node i = getStart();
            Node iMinus1 = getEnd();
            Node iPlus1 = i.getNext();
            
            setStart(iPlus1);
            iMinus1.setNext(start);
            iPlus1.setPrev(getEnd());
            
            erase(i);
        } 
    }
  
    /**
     * Deletes each node and sets the lists values to null.
     */
    void clear()
    {
        int count = 0;
        while(count!=getSize()){
            deleteFirst();
        }
        
        setStart(null);
        setEnd(null);
        System.gc();
    }
    //=====================================================================================
    //Misc. Methods
    //=====================================================================================
        
    /**
     * Takes an initial node, gets the next node steps times and returns the new object.
     * @param origin The location you want to start from (usually start).
     * @param steps How many Nodes forward you would like to move.
     * @return The object you end up at after taking the steps.
     */
    protected Node moveForward(Node origin, int steps)
    {
        int count = 0;
        if(getStart() != null){
           while(count!=steps){
               origin = origin.getNext();
               count++;
            }
        }
        return origin;
    }
    
    /**
     * Takes an initial node, gets the node before it steps times and returns the new object.
     * @param origin The Node you want to start from (usually start).
     * @param steps The amount of nodes backwards you want to go.
     * @return The node you end up after moving.
     */
    protected Node moveBackward(Node origin, int steps)
    {
        int count = 0;
        if(getStart() != null){
            while(count!=steps){
                origin = origin.getPrev();
                count++;
            }
        }
        return origin;
    }
    
    /**
     * Takes a value and checks each node for it's existence in the list.
     * - This is removed from get methods to distinguish against primary methods.
     * @param type The object that you want to search for.
     * @return boolean True if found, false if not.
     */
    boolean contains(String name)
    {
        int count = 0;
        while(count!=getSize()){
            Node x = moveForward(getStart(), count);
            Object i = ((Person)x.getType()).getFirstName();
            
            if(i.equals(name)){
                return true;
            }
            count++;
        }  
        return false;
    }
    //=====================================================================================
    //Set Methods
    //=====================================================================================    
    /**
     * Allows the user to change the start value of the list.
     * - May be unnecessary.
     * @param node The node you would like to set the start value to.
     */
    private void setStart(Node node){start = node;}
    
    /**
     * Allows the user to change the end value of the list.
     * - May be unnecessary.
     * @param node The node you would like to set the end value to.
     */
    private void setEnd(Node node){end = node;}
    //=====================================================================================
    //Get Methods
    //=====================================================================================
    /**
     * Moves through the list and returns the object at the index.
     * @param index Index value for the item you want.
     * @return The object at the selected index value.
     */
    Object get(int index){return moveForward(getStart(), index);}
    
    /**
     * Returns the size of the list.
     * @return The current value of the size variable.
     */
    public int getSize(){return size;}
    
    /**
     * Returns the last item in the list.
     * @return The value of the end variable.
     * - replaces getLast()
     */
    public Node<T> getEnd(){return end;}
    
    /**
     * Returns the first item in the list.
     * @return The value of the start variable.
     * - replaces getFirst()
     */
    public Node<T> getStart(){return start;}
    
    /**
     * Returns the string value of the first and last Nodes.
     * @return The string for the first and last Node.
     */
    public String toString(){return  getStart().toString() +  getEnd().toString();}
}