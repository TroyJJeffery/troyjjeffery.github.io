import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class MovieSorter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MovieSorter
{
    public static void main(String[] args){
        
        List<Movie> favMovies = new ArrayList<>();
        Movie hp1 = new Movie(1, 25, "Sorcerer's Stone");
        Movie hp2 = new Movie(2, 18, "Chamber of Secrets");
        Movie hp3 = new Movie(3, 21, "Prisoner of Azkaban");
        
        favMovies.add(hp1);
        favMovies.add(hp2);
        favMovies.add(hp3);
        
        System.out.println("Before : " + favMovies);
        Collections.sort(favMovies);
        System.out.println("After : " + favMovies);
        
    }   
}
