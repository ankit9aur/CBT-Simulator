package javaapplication1;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Registration extends JFrame implements ActionListener {

    JFrame frm = new JFrame();
    TextField t1, t2, t4, t5, t6, t7, t8, t9;
    JTextField t3;
    Button b1, b2;

    public Registration() {
        Panel pnl = new Panel();
        pnl.setSize(600, 550);
        pnl.setVisible(true);
        pnl.setBackground(Color.gray);
        pnl.setLayout(null);
        frm.setSize(610, 560);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);
        Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9;
        lb1 = new Label("STUDENT NAME ");
        lb2 = new Label("USERNAME");
        lb3 = new Label(" PASSWORD ");
        lb4 = new Label(" FATHER'S NAME ");
        lb5 = new Label(" MOBILE NO. ");
        lb6 = new Label(" AGE ");
        lb7 = new Label(" DATE OF BIRTH ");
        lb8 = new Label(" ADDRESS ");
        lb9 = new Label("COURSE");
        t1 = new TextField(90);
        t2 = new TextField(90);
        t3 = new JPasswordField(90);
        t4 = new TextField(90);
        t5 = new TextField(13);
        t6 = new TextField(3);
        t7 = new TextField(10);
        t8 = new TextField(250);
        t9 = new TextField(50);
        b1 = new Button("SUBMIT");
        b2 = new Button("CANCEL");
        frm.add(pnl);
        pnl.add(lb1);
        lb1.setBounds(100, 20, 110, 30);
        pnl.add(t1);
        t1.setBounds(300, 20, 150, 30);
        pnl.add(lb2);
        lb2.setBounds(100, 70, 110, 30);
        pnl.add(t2);
        t2.setBounds(300, 70, 150, 30);
        pnl.add(lb3);
        lb3.setBounds(100, 120, 110, 30);
        pnl.add(t3);
        t3.setBounds(300, 120, 150, 30);
        pnl.add(lb4);
        lb4.setBounds(100, 170, 110, 30);
        pnl.add(t4);
        t4.setBounds(300, 170, 150, 30);
        pnl.add(lb5);
        lb5.setBounds(100, 220, 110, 30);
        pnl.add(t5);
        t5.setBounds(300, 220, 150, 30);
        pnl.add(lb6);
        lb6.setBounds(100, 270, 110, 30);
        pnl.add(t6);
        t6.setBounds(300, 270, 150, 30);
        pnl.add(lb7);
        lb7.setBounds(100, 320, 110, 30);
        pnl.add(t7);
        t7.setBounds(300, 320, 150, 30);
        pnl.add(lb8);
        lb8.setBounds(100, 370, 110, 30);
        pnl.add(t8);
        t8.setBounds(300, 370, 150, 30);
        pnl.add(b1);
        lb9.setBounds(100, 420, 110, 30);
        pnl.add(lb9);
        t9.setBounds(300, 420, 150, 30);
        pnl.add(t9);
        b1.setBounds(180, 470, 60, 30);
        b1.addActionListener(this);
        pnl.add(b2);
        b2.setBounds(310, 470, 60, 30);
        b2.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == b1) {
            insert();

        } else if (src == b2) {
            frm.dispose();
        }
    }

    public void reseted() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
    }

    public void insert() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cbt", "root", "");
            PreparedStatement stat = con.prepareStatement("INSERT INTO `registration`(`Person_name`,`username`,"
                    + " `password`,`father_name`, `mob_no`, `age`, `dob`, `address`, `course`) VALUES (?,?,?,?,?,?,?,?,?)");
            System.out.println(t1.getText());
            stat.setString(1, t1.getText());
            stat.setString(2, t2.getText());
            stat.setString(3, t3.getText());
            stat.setString(4, t4.getText());
            stat.setString(5, t5.getText());
            stat.setString(6, t6.getText());
            stat.setString(7, t7.getText());
            stat.setString(8, t8.getText());
            stat.setString(9, t9.getText());
            int rowi = stat.executeUpdate();
            if (rowi > 0) {
                JOptionPane.showMessageDialog(this, "Data inserted...............");
                exitreg obj = new exitreg();
                frm.dispose();
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(this, "Data not inserted..............." + e1);
        }
    }

    class WindowAdapter implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            frm.dispose();
        }

        public void windowClosed(WindowEvent e) {
        }

        public void windowIconified(WindowEvent e) {
        }

        public void windowDeiconified(WindowEvent e) {
        }

        public void windowActivated(WindowEvent e) {
        }

        public void windowDeactivated(WindowEvent e) {
        }
    }

    public static void main(String args[]) {
        Registration obj = new Registration();
    }
}
