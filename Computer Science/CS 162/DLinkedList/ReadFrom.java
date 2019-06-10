import java.io.*;

/**
 * Write a description of class FileWriter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReadFrom
{
public static void main(String[] args) throws Exception
{

}
//This reads each line and then returns finished when it's complete.
public static String readData() throws Exception
{
    File file = new File("C:\\Users\\Troy\\Desktop\\text.txt");
    
    BufferedReader br = new BufferedReader(new FileReader(file));
    
    String st, sn;
    while((st = br.readLine()) != null){
        System.out.println(st);
    }
    br.close();
    return "Finished.";
}

}
