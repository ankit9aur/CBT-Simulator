package javaapplication1;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class signin extends JFrame implements ActionListener {

    JFrame frm = new JFrame();
    TextField t1;
    JTextField t2;
    Button b1, b2;
    Label lb1, lb2;
    public static String sName,username;

    public signin() {
        Panel pnl = new Panel();
        pnl.setSize(400, 200);
        pnl.setVisible(true);
        pnl.setBackground(Color.gray);
        pnl.setLayout(null);
        frm.setSize(400, 240);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);
        lb1 = new Label("USERNAME");
        lb2 = new Label(" Password");
        t1 = new TextField(30);
        t2 = new JPasswordField(30);
        b1 = new Button("SUBMIT");
        b2 = new Button("CANCEL");
        frm.add(pnl);
        pnl.add(lb1);
        lb1.setBounds(80, 40, 110, 30);
        pnl.add(t1);
        t1.setBounds(210, 40, 90, 30);
        pnl.add(lb2);
        lb2.setBounds(80, 90, 110, 30);
        pnl.add(t2);
        t2.setBounds(210, 90, 90, 30);
        b1.setBounds(120, 160, 60, 30);
        b1.addActionListener(this);
        pnl.add(b1);
        pnl.add(b2);
        b2.setBounds(210, 160, 60, 30);
        b2.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
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
    }

    public void insert() {
        ResultSet rs1, rs2;
        String username1 = t1.getText();
        String password1 = String.valueOf(t2.getText());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cbt", "root", "");
            PreparedStatement stat = con.prepareStatement("select Person_name, username from registration where username=? and password=?");
            PreparedStatement stat1 = con.prepareStatement("select * from admin where username=? and password=?");
            stat.setString(1, username1);
            stat.setString(2, password1);
            stat1.setString(1, username1);
            stat1.setString(2, password1);
            rs1 = stat.executeQuery();
            rs2 = stat1.executeQuery();
            if (rs2.next()) {
                MSIP1 obj = new MSIP1();
                frm.dispose();
            } else if (rs1.next()) {
                MSIP2 obj = new MSIP2();
                sName=rs1.getString("Person_name");
                username=rs1.getString("username");
                frm.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "invalid ID and Password");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String args[]) {
        signin obj = new signin();
    }
}