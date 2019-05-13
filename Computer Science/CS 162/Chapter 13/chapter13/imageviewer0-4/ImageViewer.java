import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ImageViewer is the main class of the image viewer application. It builds and
 * displays the application GUI and initialises all other components.
 * 
 * To start the application, create an object of this class.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 0.4
 */
public class ImageViewer
{
    private JFrame frame;
    private ImagePanel imagePanel;
    private JLabel filenameLabel;
    private JLabel statusLabel;
    private JMenu Filter;
    
    /**
     * Create an ImageViewer show it on screen.
     */
    public ImageViewer()
    {
        makeFrame();
    }


    // ---- implementation of menu functions ----
    
    /**
     * Open function: open a file chooser to select a new image file.
     */
    private void openFile()
    {
        OFImage image = ImageFileManager.getImage();
        imagePanel.setImage(image);
        frame.pack();
    }
    
    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
    
    // ---- swing stuff to build the frame and all its components ----
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");
        makeMenuBar(frame);
        
        Container contentPane = frame.getContentPane();
        
        contentPane.setLayout(new BorderLayout(6, 6));
        
        filenameLabel = new JLabel();
        contentPane.add(filenameLabel, BorderLayout.NORTH);
        
        imagePanel = new ImagePanel();
        contentPane.add(imagePanel, BorderLayout.CENTER);
        
        statusLabel = new JLabel("Version 1.0");
        contentPane.add(statusLabel, BorderLayout.SOUTH);
        
        // building is done - arrange the components and show        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();


        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File manu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        
        JMenuItem openItem = new JMenuItem("Open");
            openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
            openItem.addActionListener(e -> openFile());
        fileMenu.add(openItem);

        JMenuItem quitItem = new JMenuItem("Quit");
            quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            quitItem.addActionListener(e -> quit());
        fileMenu.add(quitItem);

        JMenu filterMenu = new JMenu("Filter");
        menubar.add(filterMenu);
        
        JMenuItem darkerItem = new JMenuItem("Darker");
            darkerItem.addActionListener(e -> makeDarker());
        filterMenu.add(darkerItem);
        
        JMenuItem lighterItem = new JMenuItem("Lighter");
            lighterItem.addActionListener(e -> makeLighter());
        filterMenu.add(lighterItem);
        
        JMenuItem thresholdItem = new JMenuItem("Threshold");
            thresholdItem.addActionListener(e -> threshold());
        filterMenu.add(thresholdItem);
            
    }
    
    public void makeDarker()
    {
    }
    
    public void makeLighter()
    {
    }
    
    public void threshold()
    {
    }
}
