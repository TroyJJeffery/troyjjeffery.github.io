import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        //if(index >= 0 && index < files.size()) 
        validIndex(index);
        if(validIndex(index)==true){
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        //if(index >= 0 && index < files.size()) {
          if(validIndex(index) == true){
            files.remove(index);
        }
    }
    
    /**
     * 
     */
    public void checkIndex(int index)
    {
        //if(index >=0 && index < files.size()){
          if( 0 >= index && index >= (files.size() - 1)){
        }
        else{
            System.out.println("Your input is outside the range of the index.");
            System.out.println("Current Index Size = " + files.size());
        }
    }
    
    /**
     * 
     */
    public boolean validIndex(int index)
    {
        if(index >=0 && index < files.size()){
            return true;
        }
        else{
            return false;
        }
    }
}
