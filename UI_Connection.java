
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.concurrent.RecursiveTask;
public class UI_Connection extends JFrame implements ActionListener{

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
         L1=new JLabel("Name");
        L2=new JLabel("Mobile Number");
        L3=new JLabel("Salary");

        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();

        b1=new JButton("First");
        b2=new JButton("Next");
        b3=new JButton("Prev");
        b4=new JButton("Last");

        L1.setBounds(100, 100, 100, 30);
        tf1.setBounds(220, 100, 100, 30);

        L2.setBounds(100, 140, 100, 30);
        tf2.setBounds(220, 140, 100, 30);

        L3.setBounds(100, 180, 100, 30);
        tf3.setBounds(220, 180, 100, 30);

        b1.setBounds(100,220,100,40);
        b2.setBounds(220,220,100,40);
        
        b3.setBounds(100,220,100,30);
        b4.setBounds(220,220,100,30);

        add(L1);
        add(tf1);
        add(L2);
        add(tf2);
        add(L3);
        add(tf3);

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        // Button Listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setSize(400,400);
        setVisible(true);

         try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcConnection", "root", "@ycce2025placed");
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = st.executeQuery("select * from employee;");
            res.next();

            tf1.setText(res.getString(1));
            tf2.setText(res.getString(2));
            tf3.setText(res.getString(3));
         }catch(Exception e){

         }
    }
    public void actionPerformed(ActionEvent obj){
        try{
           JButton b = (JButton)obj.getSource();

           if(b == b1){
            res.first();
            tf1.setText(res.getString(1));
            tf2.setText(res.getString(2));
            tf3.setText(res.getString(3));
           }
           if(b == b2){
            res.next();
            tf1.setText(res.getString(1));
            tf2.setText(res.getString(2));
            tf3.setText(res.getString(3));
           }
           if(b == b3){
            res.previous();
            tf1.setText(res.getString(1));
            tf2.setText(res.getString(2));
            tf3.setText(res.getString(3));
           }
           if(b == b4){
            res.last();
            tf1.setText(res.getString(1));
            tf2.setText(res.getString(2));
            tf3.setText(res.getString(3));
           }
        }
        catch(Exception e){

        }
    }
    public static void main(String[] args) {
        new UI_Connection();
    }
}
