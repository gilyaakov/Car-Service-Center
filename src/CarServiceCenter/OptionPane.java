package CarServiceCenter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;

public class OptionPane {  
       JFrame f;
       static JFrame f2;
       static volatile String option = "None";
       static Vector<String> arr;
       OptionPane(){
    	         arr = new Vector<String>();
                 f = new JFrame("Car Service Center");
                 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 BufferedImage img = null;
                 try {
                     img = ImageIO.read(new File("icone0.png"));
                 } catch (IOException e) {
                 }
                 f.setIconImage(img);
                 f.setSize(500, 500);
                 f.setVisible(true);
       }
       public String waitForOption(String menu){
    	   JPanel MyPanel = new JPanel();
           MyPanel.setLayout(new GridLayout(3,3));  // 4x3 Grid
           JButton btn;
           String[] arrOfStr = menu.split("\n");
           int i = 1;
           for (String a : arrOfStr) {
                   btn = new JButton(a);
                   btn.setFont(new Font("Serif", Font.BOLD, 20));
                   btn.addActionListener(new Listener());
                   String s = String.valueOf(i);
                   btn.setActionCommand(s);
                   i++;
                   MyPanel.add(btn);
           }  
           f.getContentPane().add(MyPanel, "Center"); // Paste MyPanel into JFrame
           f.setVisible(true);
           while(OptionPane.option.equals("None")) {}
           String temp = OptionPane.option;
           OptionPane.option = "None";
           f.remove(MyPanel);
           return temp;
       }
       public void simulation() {
    	   f2 = new JFrame("Car Service Center");
           BufferedImage img = null;
           try {
               img = ImageIO.read(new File("icone0.png"));
           } catch (IOException e) {
           }
           f2.setIconImage(img);
       }
       public synchronized void add(String s){
           // create a label to display text
    	   arr.add(s);
    	   JPanel p = new JPanel();
    	   for(String temp: arr) {
    		   JLabel l = new JLabel();
               l.setText(temp);
               // add label to panel
               p.add(l);
    	   }
           // add panel to frame
           f2.add(p);
           // set the size of frame
           f2.setSize(300, 1100);
           f2.setVisible(true);
       }
       public void simulationEnd() {
    	   f2.setVisible(false); //you can't see me!
    	   f2.dispose(); //Destroy the JFrame object
    	   arr.clear();
       }
       public void close() {
    	   f.setVisible(false); //you can't see me!
    	   f.dispose(); //Destroy the JFrame object
       }
} 