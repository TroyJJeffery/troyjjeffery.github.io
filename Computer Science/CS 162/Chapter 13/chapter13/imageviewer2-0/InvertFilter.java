import java.awt.Color;

/**
 * Write a description of class InvertFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InvertFilter extends Filter
{

    /**
     * Constructor for objects of class InvertFilter
     */
    public InvertFilter(String name)
    {
        super(name);

    }

    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                
                Color pixel = new Color(image.getRGB(x, y));
                Color invert = new Color(255-pixel.getRed(), 
                                         255-pixel.getGreen(), 
                                         255-pixel.getBlue());
    
                image.setPixel(x, y, invert);
            }
        }
    }
}
