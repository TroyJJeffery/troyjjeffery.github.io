import java.util.ArrayList;

/**
 * This class stores information about a news feed post in a 
 * social network. Posts can be stored and displayed. This class
 * serves as a superclass for more specific post types.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.3
 */
public class Post 
{
    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    /**
     * Constructor for objects of class Post.
     * 
     * @param author    The username of the author of this post.
     */
    public Post(String author)
    {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }

    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }
    
    protected String getTimeString()
    {
        return timeString(getTimeStamp());
    }
        
    protected String getLikeDisplay()
    {
      String like = new String();
   
      if(likes > 0) {
          like = like.concat("  -  " + likes + " people like this.");
      }
      else{
          like = like.concat("Be the first to like this post!");
        }
        
        return like;
    }
    
    protected String getComments()
    {
      String comment;
      comment = new String();

      if(comments.isEmpty()) {
          comment = comment.concat("   No comments.");
      }
      else {
          comment = comment.concat("   " + comments.size() + " comment(s). Click here to view.");
      }
      
      return comment;
    }
        
    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        System.out.println(username);
        System.out.print(timeString(timestamp));
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    
    /**
     * Returns the author.
     * @return The author of the post.
     */
    public String getAuthor()
    {
        String author;
        author = username;
        
        return author;
    }
    
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    
    protected String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
