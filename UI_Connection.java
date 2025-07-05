import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.RecursiveTask;
public class UI_Connection extends JFrame {

    //UI
    JLabel L1, L2, L3;
    JTextField tf1,tf2,tf3;
    JButton b1,b2,b3,b4;

    //JDBC
    Connection cn;
    Statement st;
    ResultSet res;

    UI_Connection(){
         setLayout(null);
         L1= new JLabel("Name");
         L2 = new JLabel("Mobile Number");
         L3 = new JLabel("Salary");
         
         tf1 = new JTextField();
         tf2 = new JTextField();
         tf3 = new JTextField();

         b1 = new JButton("First");
         b2 = new JButton("Next");
         b3 = new JButton("Prev");
         b4 = new JButton("Last");

         L1.setBounds(100,100,100,30);
         tf1.setBounds(220,100,100,30);
         L2.setBounds(100,140,100,30);
         tf2.setBounds(220,100,100,30);

         b1.setBounds(100,220,100,30);
         b2.setBounds(220,220,100,30);
         b3.setBounds(100,220,100,30);
         b4.setBounds(220,220,100,30);

    }
    public static void main(String[] args) {
        
    }
}
