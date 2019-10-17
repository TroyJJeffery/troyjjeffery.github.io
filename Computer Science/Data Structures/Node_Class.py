"""
This is a Node to hold person objects in the list.
@author Troy Jeffery
@version 5/25/2019
"""

class Node:

    # A pointer for the previous Node in the list.
    # A pointer for the next Node in the list. 
    # The data type inserted in the Node.
    
	def __init__(prev,next,object):
        prev = this;
        next = this;
        this.type = type;

    
    """
     * Constructor for Node.
     * @param type Data type
     * @param prev The previous Node.
     * @param next The next Node.
     """
    public Node(T type, Node prev, Node next)
    {
        this.prev = prev;
        this.next = next;
        this.type = type;
    }
    
    #Setters
    """
     * Set's the previous Node.
     * @param prev The node used to set.
     """
    public void setPrev(Node prev){this.prev = prev;}
    
    """
     * Set's the next Node.
     * @param next The next node.
     """
    public void setNext(Node next){this.next = next;}
    
    """
     * Set's the data type.
     * @param type The data type.
     """
    public void setType(T type){this.type = type;}
    
    #Getters
    """
     * Returns the assigned previous node.
     * @return The Nodes prev Node.
     """
    public Node getPrev(){return prev;}
    
    """
     * Returns the assigned next node.
     * @return The Nodes next Node.
     """
    public Node getNext(){return next;}
    
    """
     * Returns the nodes data type.
     * @return The nodes data.
     """
    public T getType(){return type;}
    
    """
     * Returns the string value for the data type.
     * @override
     * @return The string value of the Nodes type.
     """
    public String toString(){return "Type" + type.toString();}   
}
