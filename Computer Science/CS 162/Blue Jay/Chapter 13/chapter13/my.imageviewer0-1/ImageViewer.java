import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ImageViewer is the main class of the image viewer application. It builds
 * and displays the application GUI and initialises all other components.
 * 
 * To start the application, create an object of this class.
 * 
 * @author Michael Kölling and David J. Barnes.
 * @version 0.1
 */
public class ImageViewer
    implements ActionListener
{
    private JFrame frame;
    
    /**
     * Create an ImageViewer show it on screen.
     */
    public ImageViewer()
    {
        makeFrame();
    }
    
    // ---- swing stuff to build the frame and all its components ----
    
    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");        
        Container contentPane = frame.getContentPane();
        
        JLabel label = new JLabel("I am a label. I can display some text.");
        contentPane.add(label);
        
        //JButton button = new JButton("Red Pill");
        //contentPane.add(button);
        
        //JButton button2 = new JButton("Blue Pill");
        //contentPane.add(button2);
        
        makeMenuBar();
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * This method creates the menu bar and is called in the MakeFrame method.
     */
    private void makeMenuBar()
    { 
        // Builds bar to contain items.
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
             //Adds File button to the menu bar.
             JMenu fileMenu = new JMenu("File");
             menubar.add(fileMenu);
        
                  //Adds Open, Quit and Save to the File Menu.
                  JMenuItem openItem = new JMenuItem("Open");
                  openItem.addActionListener(e -> openFile());
                  fileMenu.add(openItem);
                  
                  JMenuItem quitItem = new JMenuItem("Quit");
                  quitItem.addActionListener(e -> quit());
                  fileMenu.add(quitItem);
        
                  JMenuItem saveItem = new JMenuItem("Save");
                  saveItem.addActionListener(e -> saveFile());
                  fileMenu.add(saveItem);
                  
             //Adding Help to the Menu Bar
             JMenu helpMenu = new JMenu("Help");
             menubar.add(helpMenu);
        
                  // Adds About item to the Help Menu.
                  JMenuItem aboutItem = new JMenuItem("About ImageViewer");
                  aboutItem.addActionListener( e -> about());
                  helpMenu.add(aboutItem);
        
        
    }
    
    /**
     * @override
     * Receive notifications of an action.
     * @param event Details of the action.
     */
    public void actionPerformed(ActionEvent event)
    {
      
        System.out.println("Menu item: " + event.getActionCommand());
        
    }
    
    /**
     * Makes the frame visible again if it's been closed.
     */
    public void makeVisible()
    {
        frame.setVisible(true);
    }
    
    /**
     * Allows the user to open a file.
     */
    private void openFile()
    {
    }
    
    /**
     * Allows the user to save a file.
     */
    private void saveFile()
    {
    }
    
    /**
     * Allows the user to quit the application.
     */
    private void quit()
    {
    }
    
    /**
     * Provides the user with information about the window.
     */
    private void about()
    {
    }
    public void addLabels()
    {
        Container contentPane = frame.getContentPane();
        JLabel filenameLabel = new JLabel();
        contentPane.add(filenameLabel);
        imagePanel imagePanel = new ImagePanel();
        
        
        }
        
}
