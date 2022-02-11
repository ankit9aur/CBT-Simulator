package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


class MSIP1 extends JFrame implements ActionListener {

    JFrame frm;
    JPanel pnl;
    JLabel lbl1, lbl2;
    JButton btn1, btn2, btn3;

    public MSIP1() {
        frm = new JFrame("Admin Panel");
        pnl = new JPanel();
        pnl.setLayout(null);
        pnl.setBackground(Color.black);
        btn1 = new JButton("Add Question");
        btn2 = new JButton("Edit Question");
        btn3 = new JButton("See Results");
        frm.setVisible(true);
        frm.setSize(400, 170);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setResizable(false);
        
        btn1.setBackground(Color.green);
        btn2.setBackground(Color.green);
        btn3.setBackground(Color.green);
        btn1.setForeground(Color.black);
        btn2.setForeground(Color.black);
        btn3.setForeground(Color.black);
        btn1.setBounds(20, 30, 150, 30);
        btn2.setBounds(210, 30, 150, 30);
        btn3.setBounds(100, 80, 170, 30);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        frm.add(pnl);
        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(btn3);
        addWindowListener(new MSIP1.WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btn1) {
            addQuestion obj = new addQuestion();
        } else if (src == btn2) {
            editQuestion obj = new editQuestion();
        } else if (src == btn3) {
            try {
                ShowResult obj = new ShowResult();
            } catch (SQLException ex) {
                Logger.getLogger(MSIP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    class WindowAdapter implements WindowListener {
        @Override
        public void windowClosing(WindowEvent e) {
            frm.dispose();
        }

        @Override
        public void windowOpened(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowClosed(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowIconified(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowActivated(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    public static void main(String args[]) {
        MSIP1 obj = new MSIP1();
    }
}
