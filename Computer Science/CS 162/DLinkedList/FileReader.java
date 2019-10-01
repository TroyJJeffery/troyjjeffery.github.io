import java.io.*;

/**
 * Write a description of class FileWriter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileReader
{
public static void main(String[] args)
{
    File file = new File("C:\\Users\\troyjjeffery\\Desktop\\text.txt");
    
    BufferedReader br = new BufferedReader(new FileReader(file));
    
    
}
}
