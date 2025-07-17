import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UI_Connection extends JFrame implements ActionListener {

    // UI Components
    JLabel L1, L2, L3;
    JTextField tf1, tf2, tf3;
    JButton b1, b2, b3, b4;

    // JDBC
    Connection cn;
    Statement st;
    ResultSet res;

    UI_Connection() {
        setLayout(null);

        // Labels
        L1 = new JLabel("Name");
        L2 = new JLabel("Mobile Number");
        L3 = new JLabel("Salary");

        // Text fields
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();

        // Buttons
        b1 = new JButton("First");
        b2 = new JButton("Next");
        b3 = new JButton("Previous");
        b4 = new JButton("Last");

        // Set bounds
        L1.setBounds(100, 50, 100, 30);
        tf1.setBounds(220, 50, 150, 30);

        L2.setBounds(100, 100, 100, 30);
        tf2.setBounds(220, 100, 150, 30);

        L3.setBounds(100, 150, 100, 30);
        tf3.setBounds(220, 150, 150, 30);

        b1.setBounds(50, 220, 100, 40);
        b2.setBounds(160, 220, 100, 40);
        b3.setBounds(270, 220, 100, 40);
        b4.setBounds(105, 280, 200, 40);

        // Add components
        add(L1); add(tf1);
        add(L2); add(tf2);
        add(L3); add(tf3);
        add(b1); add(b2); add(b3); add(b4);

        // Add listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        // Frame settings
        setTitle("Employee Navigation");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // JDBC setup
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/college", "root", "@ycce2025placed");
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            res = st.executeQuery("SELECT * FROM employee");

            if (res.next()) {
                loadData();
            }
        } catch (Exception e) {
    e.printStackTrace(); // shows detailed error in terminal
    JOptionPane.showMessageDialog(this, "Connection Error: " + e.getMessage());
}

    }

    // Load current row data
    private void loadData() {
        try {
            tf1.setText(res.getString("name"));  // Use column names for clarity
            tf2.setText(res.getString("mobile"));
            tf3.setText(res.getString("salary"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Load Error: " + e.getMessage());
        }
    }

    // Button actions
    public void actionPerformed(ActionEvent obj) {
        try {
            JButton b = (JButton) obj.getSource();

            if (b == b1 && res.first()) loadData();
            else if (b == b2 && !res.isLast() && res.next()) loadData();
            else if (b == b3 && !res.isFirst() && res.previous()) loadData();
            else if (b == b4 && res.last()) loadData();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Action Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new UI_Connection();
    }
}
