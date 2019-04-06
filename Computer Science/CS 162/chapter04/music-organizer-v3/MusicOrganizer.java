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
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
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
        if(validIndex(index)) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
       // for(String filename : files) {
       //     System.out.println(filename);
        //}
        for(int i = 0; i < files.size(); i++)
            listFile(i);

                
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.startPlaying(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play a file in the collection. Only return once playing has finished.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index)
    {
        if(validIndex(index)) {
            String filename = files.get(index);
            player.playSample(filename);
        }
    }

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        boolean valid;
        
        if(index < 0) {
            System.out.println("Index cannot be negative: " + index);
            valid = false;
        }
        else if(index >= files.size()) {
            System.out.println("Index is too large: " + index);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
    
        /**
     * 
     */
    public void addDefaultFiles()
    {
        files.add("../audio/BlindBlake-EarlyMorningBlues.mp3");
        files.add("../audio/BigBillBroonzy-BabyPleaseDontGo1.mp3");
        files.add("../audio/BlindLemonJefferson-matchBoxBlues.mp3");
        files.add("../audio/BlindLemonJefferson-OneDimeBlues.mp3");
    }
    
    /**
     * 
     */
    public void listMatching(String searchString)
    {
        boolean match;
        match = false;
            
        for(String filename : files){
            if(filename.contains(searchString)) {
                //A match.
                System.out.println(filename);
                match = true;
            }
        }
        if(match == true) {
            System.out.println("No match found.");
        } 
    }
    
    public void playArtist(String artistName){
        for(String filename : files){
            if(filename.contains(artistName)){
                player.playSample(filename);
            }
        }
    }
    
    /**
     * 
     */
    public void multiplesOfFive()
    {
        int x = 10;
        while(x >= 10 && x <= 95){
            System.out.println(x);
            x = x + 5;
        }
    }
    
    public void addOneToTen()
    {
        int sum = 0;
        int index = 1;
        
        while(index<=10){
            sum = sum + index;
            index++;
        }
        System.out.println(sum);
    }
       
    public void sum(int lowNum, int highNum)
    {
        int sum = 0;
        int index = lowNum;
        
        
        while(index<=highNum){
            sum = sum + index;
            index++;   
            //System.out.println(sum);
        }
        if(index==(highNum+1)){          
            System.out.println(sum);
        }   
    
    }
    
    public void isPrime(int number)
    {
        int n = number;
        int x = 2;
        
        while(x < n){
            if((n % x) != 0){
                int rem = n%x;              
                System.out.println("Divisor: " + x + " Remainder: " + rem);
                x++;
                //System.out.println(x);
            }
            else{
                //((n % x) == 0){
                System.out.println("The number can be divided by " + x + ".") ;
                System.out.println("Therefore, it cannot be a prime number.");
                break;
            }
        }
        if(n == x){
            System.out.println("Your number, " + n + ", is prime!");
        }
    }
    
}
