package javaapplication1;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class editQuestion extends JFrame implements ActionListener {

    JFrame frm = new JFrame();
    TextField t1, t2, t4, t5, t6, t7, t8;
    Button b1, b2;

    public editQuestion() {
        Panel pnl = new Panel();
        pnl.setSize(600, 450);
        pnl.setVisible(true);
        pnl.setBackground(Color.gray);
        pnl.setLayout(null);
        frm.setSize(610, 460);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);
        Label lb1, lb2, lb4, lb5, lb6, lb7, lb8;
        lb1 = new Label("Question Number ");
        lb2 = new Label("Question");
        lb4 = new Label("Option1");
        lb5 = new Label("Option2");
        lb6 = new Label("Option3");
        lb7 = new Label("Option4");
        lb8 = new Label("Currect Option");
        t1 = new TextField(90);
        t2 = new TextField(90);
        t4 = new TextField(90);
        t5 = new TextField(13);
        t6 = new TextField(3);
        t7 = new TextField(10);
        t8 = new TextField(250);

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
        lb4.setBounds(100, 120, 110, 30);
        t4.setBounds(300, 120, 150, 30);
        pnl.add(lb4);
        lb5.setBounds(100, 170, 110, 30);
        pnl.add(t4);
        t5.setBounds(300, 170, 150, 30);
        pnl.add(lb5);
        lb6.setBounds(100, 220, 110, 30);
        pnl.add(t5);
        t6.setBounds(300, 220, 150, 30);
        pnl.add(lb6);
        lb7.setBounds(100, 270, 110, 30);
        pnl.add(t6);
        t7.setBounds(300, 270, 150, 30);
        pnl.add(lb7);
        lb8.setBounds(100, 320, 110, 30);
        pnl.add(t7);
        t8.setBounds(300, 320, 150, 30);
        pnl.add(lb8);
        pnl.add(t8);
        pnl.add(b1);
        b1.setBounds(180, 380, 60, 30);
        b1.addActionListener(this);
        pnl.add(b2);
        b2.setBounds(310, 380, 60, 30);
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
            PreparedStatement stat = con.prepareStatement("UPDATE exams SET question=?,op1=?,op2=?,op3=?,op4=?,cop=? WHERE qid=?");
           
            stat.setString(1, t2.getText());
            stat.setString(2, t4.getText());
            stat.setString(3, t5.getText());
            stat.setString(4, t6.getText());
            stat.setString(5, t7.getText());
            stat.setString(6, t8.getText());
            stat.setString(7, t1.getText());
           
            int rowi = stat.executeUpdate();
            if (rowi > 0) {
                JOptionPane.showMessageDialog(this, "Data updated...............");
                frm.dispose();
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(this, "Data not updated..............." + e1);
        }
    }

    class WindowAdapter implements WindowListener {

        public void windowOpened(WindowEvent e) {
        }

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
        editQuestion obj = new editQuestion();
    }
}
