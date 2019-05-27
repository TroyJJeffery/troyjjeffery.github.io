import java.awt.Color;

/**
 * Write a description of class Smooth here.
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

 
   *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SmoothFilter extends Filter
{

    /**
     * Constructor for objects of class Smooth
     */
    public SmoothFilter(String name)
    {   super(name);
    }

    public void apply(OFImage image)
    {
       OFImage copy = new OFImage(image);
       
        int height = image.getHeight();
        int width = image.getWidth();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {

            }
        }
    }
}
