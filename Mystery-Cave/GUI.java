import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The GUI Class draws and displays the GUI for the user and takes  user commands
 * 
 * @author 163318
 * @version 2.0
 */
public class GUI extends JFrame implements ActionListener  
{
    //GUI components
    Game g1;
    private JFrame gui;
    private JTextArea gameText;
    private JPanel panel; 
    private JLayeredPane lpane;
    private Parser parser;
    private boolean finished = false;
    private JLabel backgroundPic;
    /**
     * Creates the GUI for the current room
     * 
     */
    public GUI()
    {
        g1 = new Game();
        parser = new Parser();
        drawGUI();
        g1.play();

    
    }
    
    
    /**
     * Draws all the elements present in the GUI, such as JLabels, images and buttons
     */
    public void drawGUI()
    {
        //create the intial GUI
        gui = new JFrame("Mystery Cave!");
        panel = new JPanel();
        //panelBackground = new JPanel();

        //panelBackground.setLayout

 
        //Set panel to boxlayout so text and pictures can be displayed within the same window. 
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

        
        //add the background image to the game 
        JLabel backgroundPic = new JLabel(new ImageIcon("images/CaveBackground.jpg"));
        backgroundPic.setLayout(null);
        panel.add(backgroundPic);
        
        //Add JMenuBar help feature
        JMenuBar menuBar = new JMenuBar();
        gui.setJMenuBar(menuBar);
        JMenuItem helper = new JMenuItem("Help");
        menuBar.add(helper);
        helper.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showHintDialogue();
                String commandText = "help";
                Command command = parser.getCommand(commandText);
                g1.processCommand(command);
            
            }
        });
        
        
        
        //Add JMenu shop feature
        JMenu shopMenu = new JMenu("Shop");
        menuBar.add(shopMenu);
        JMenuItem buy = new JMenuItem("Buy Sword");
        shopMenu.add(buy);
        buy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 String commandText = "buy sword";
                 Command command = parser.getCommand(commandText);
                 g1.processCommand(command);
                }
        
        });
        
        

        //ADD BUTTON. The following image icon buttons follow the same pattern as this initial one. 
        ImageIcon upArrow = new ImageIcon("images/upArrow.png"); //add image
        JButton goNorthButton = new JButton(upArrow); //make image JButton
        goNorthButton.setBounds(325,0, 124,124); //Position image and set size
        //goNorthButton.setOpaque(false);
        //goNorthButton.setContentAreaFilled(false);
        goNorthButton.setBorderPainted(false); //Get rid of the white edges around image
        goNorthButton.addActionListener(new ActionListener(){ //add functionality for button
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == goNorthButton)
                    {
                        String commandText = "go north";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                        
                    }
                }
        
        });
        
        backgroundPic.add(goNorthButton);
  


        //add go south button
        ImageIcon downArrow = new ImageIcon("images/downArrow.png");
        JButton goSouthButton = new JButton(downArrow);
        goSouthButton.setBounds(325,425, 124,124);
        goSouthButton.setBorderPainted(false);
        
        goSouthButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == goSouthButton)
                    {
                        String commandText = "go south";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                    }
                }
        
        });
        backgroundPic.add(goSouthButton);


        

        //add east
        ImageIcon rightArrow = new ImageIcon("images/rightArrow.png");
        JButton goEastButton = new JButton(rightArrow);
        goEastButton.setBounds(670,170, 124,124);
        goEastButton.setBorderPainted(false);
        
        goEastButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == goEastButton)
                    {
                        String commandText = "go east";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                    }
                }
        
        });
        
        backgroundPic.add(goEastButton);

        //add west
        ImageIcon leftArrow = new ImageIcon("images/leftArrow.png");
        JButton goWestButton = new JButton(leftArrow);
        goWestButton.setBounds(0,170, 124,124);
        goWestButton.setBorderPainted(false);
        
        goWestButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == goWestButton)
                    {
                        String commandText = "go west";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                    }
                }
        
        });
        
        backgroundPic.add(goWestButton);

        //add down 
        ImageIcon downStairs = new ImageIcon("images/stairs_down.png");
        JButton goDown = new JButton(downStairs);
        goDown.setBounds(600,285, 124,124);
        goDown.setBorderPainted(false);
        
        goDown.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == goDown)
                    {
                        String commandText = "go down";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                    }
                }
        
        });
        
        backgroundPic.add(goDown);

        //add up
        ImageIcon upStairs = new ImageIcon("images/stairs_up.png");
        JButton goUp = new JButton(upStairs);
        goUp.setBounds(500,160, 124,124);
        goUp.setBorderPainted(false);
        
        goUp.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == goUp)
                    {
                        String commandText = "go up";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                    }
                }
        
        });
        
        backgroundPic.add(goUp);

        //add chest
        ImageIcon chest = new ImageIcon("images/chest.png");
        JButton chestButton = new JButton(chest);
        chestButton.setBounds(0,310, 124,124);
        chestButton.setBorderPainted(false);
        
        chestButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == chestButton)
                    {
                        String commandText = "open chest";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                    }
                }
        
        });
        
        backgroundPic.add(chestButton);        

        //add key
        ImageIcon goldKey = new ImageIcon("images/key.png");
        JButton keyButton = new JButton(goldKey);
        keyButton.setBounds(100,320, 124,124);
        keyButton.setBorderPainted(false);
        
        keyButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)

                {
                    if (e.getSource() == keyButton)
                    {
                        String commandText = "take key";
                        Command command = parser.getCommand(commandText);
                        g1.processCommand(command);
                    }
                }
        
        });
        
        backgroundPic.add(keyButton);     

        //add troll
        ImageIcon troll = new ImageIcon("images/trol.png");
        JButton trollButton = new JButton(troll);
        trollButton.setBounds(350,275, 124,124);
        trollButton.setBorderPainted(false);
        backgroundPic.add(trollButton);             
        
        
        
        

        //add the text area in a box underneath
        //Box box1 = Box.createHorizontalBox();
        //gameText = new JTextArea(800, 100);
        //JScrollPane scroll = new JScrollPane(gameText,
        //        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        //        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //box1.add(scroll);
        //panel.add(box1);
        //add box to gui
        gui.add(panel);

        
        
        
        //set gui initial size
        gui.setSize(800,570);
        //close on exit
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        //Make visible
        gui.setVisible(true);
        



    }
    
    /**
     * showHintDialogue displays a pop up window with some text instructing the player how to play the game
     */
    private void showHintDialogue()
    {
        JOptionPane.showMessageDialog(null, "Click the icons to move and interact with the environment!");
    }
 
    public void actionPerformed(ActionEvent e){}
}
