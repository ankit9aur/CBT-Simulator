package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class first extends JFrame implements ActionListener {

    JFrame frm;
    JPanel pnl;
    JLabel lbl;
    JButton btn1;
    JLabel jlb;

    public first() {
        frm = new JFrame("Welcome");
        pnl = new JPanel();
        jlb=new JLabel();
        
        
//        jlb.setForeground(Color.green);
        pnl.setLayout(null);
        pnl.setBackground(Color.black);
        jlb.setBounds(100,10,200,60);
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\uit.jpg").getImage().getScaledInstance(jlb.getWidth(),jlb.getHeight(),Image.SCALE_SMOOTH));
        jlb.setIcon(imageIcon);
        
        btn1 = new JButton("WELCOME TO CBT EXAM APPLICATION");
      
        frm.setVisible(true);
        frm.setSize(400, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setResizable(false);
        addWindowListener(new first.WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        validate();
        btn1.setBackground(Color.green);
        btn1.setForeground(Color.black);
        btn1.setBounds(50, 80, 300, 60);
        btn1.addActionListener(this);
        frm.add(pnl);
        pnl.add(btn1);
        pnl.add(jlb);
    }

    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == btn1) {
            MSIP obj = new MSIP();
            frm.setVisible(false);
        }
    }

    class WindowAdapter implements WindowListener {
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
        first obj = new first();
    }
}
