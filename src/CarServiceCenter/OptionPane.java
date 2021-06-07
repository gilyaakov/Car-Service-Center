package CarServiceCenter;
import javax.swing.*;

public class OptionPane {  
       JFrame f;
       String option;
       OptionPane(String menu){  
                 f = new JFrame(); 
                 option = JOptionPane.showInputDialog(f,menu);
       }  
} 