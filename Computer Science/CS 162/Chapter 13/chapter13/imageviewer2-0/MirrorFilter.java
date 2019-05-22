import java.awt.Color;

/**
 * Write a description of class MirrorFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MirrorFilter extends Filter
{

    /**
     * Constructor for objects of class MirrorFilter
     */
    public MirrorFilter(String name)
    {
        super(name);
    }
        
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color left = image.getPixel(x, y);
                image.setPixel(x, y, image.getPixel(width - 1 - x, y));
                image.setPixel(width - 1 - x, y, left);
            }
        }
    }
    
}
