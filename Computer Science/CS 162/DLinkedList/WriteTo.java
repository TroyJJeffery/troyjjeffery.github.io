import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Write a description of class FileWriter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WriteTo
{
    private String fileName;
    private PrintWriter outputStream;
    
    public WriteTo() throws Exception
    {
        this.fileName = fileName;
        outputStream = new PrintWriter("out.txt");
    }
    
    /*public static void main(String[] args)
    {
        String fileName = "out.txt";
        
        try {
            PrintWriter outputStream = new PrintWriter(fileName);
            outputStream.println("test"); //stores in RAM first.
            outputStream.close();// pushes data
        }
        catch (FileNotFoundException e) {
            
        }
    }
    */
    //This takes people objects from my Data class and prints the details to a text file.
    public void write() throws Exception
    {
        DATA d = new DATA();
        ArrayList p = new ArrayList<Person>(d.getPeeps());
        
        try {
              PrintWriter outputStream = new PrintWriter(fileName);
              outputStream.println("test");
              outputStream.close();
            }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
            return;
        }
        
       for(int i =0; i<p.size();i++)
       {
           outputStream.println(p.get(i).toString());
           //outputStream.println("*");
        }
    outputStream.close();
}

//This is a simpler test that just prints the numbers 1-0.
public void writeNumbers() throws Exception
    {

       for(int i =0; i<10;i++){
            outputStream.println(i);
        }
        
        outputStream.close();
    }
}
