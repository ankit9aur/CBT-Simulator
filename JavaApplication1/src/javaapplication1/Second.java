package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MSIP implements ActionListener {

    JFrame frm;
    JPanel pnl;
    JLabel lbl1, lbl2;
    JButton btn1, btn2, btn3;
    
    public MSIP() {
        frm = new JFrame("Main Sign In Page");
        pnl = new JPanel();
        pnl.setLayout(null);
        pnl.setBackground(Color.black);
        btn1 = new JButton("Administrator Login");
        btn2 = new JButton("Student Login");
        btn3 = new JButton("Student Registration");
        frm.setVisible(true);
        frm.setSize(400, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setResizable(false);
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btn1.setBackground(Color.green);
        btn2.setBackground(Color.green);
        btn3.setBackground(Color.green);
        btn1.setForeground(Color.black);
        btn2.setForeground(Color.black);
        btn1.setBounds(20, 30, 150, 30);
        btn2.setBounds(210, 30, 150, 30);
        btn3.setBounds(100, 100, 170, 30);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        frm.add(pnl);
        pnl.add(btn1);
        pnl.add(btn2);
        pnl.add(btn3);
    }

    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == btn1) {
            signin obj = new signin();
        } else if (e == btn2) {
            signin obj = new signin();
        } else if (e == btn3) {
            Registration obj = new Registration();
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
        MSIP obj = new MSIP();
    }
}
