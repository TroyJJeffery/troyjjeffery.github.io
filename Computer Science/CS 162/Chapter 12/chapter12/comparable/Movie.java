
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Movie implements Comparable<Movie> 
{
    private int rank;
    private String name;
    private int length;
    
    public Movie(int rank, int length, String name)
    {
        this.rank = rank;
        this.length = length;
        this.name = name;
        
    }
    public Movie()
    {
        rank = 0;
        length = 0;
        name ="";
    }
    
    public int getRank()
    {
        return rank;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    public void setLength(int newLength)
    {
        length = newLength;
    }
    
    public void setRank(int newRank)
    {
        rank = newRank;
    }
    
    @Override
    public int compareTo(Movie otherMovie)
    {
        return (this.getRank() - otherMovie.getRank());
    }
}

