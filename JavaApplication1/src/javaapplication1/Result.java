package javaapplication1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Result implements ActionListener {

    JFrame frm;
    JPanel pnl, pnl1, pnl2;
    Panel pnlgrid;
    JLabel slbl;
    JLabel plbl1, plbl2, plbl3, plbl4, plbl5, plbl6;
    JLabel pnlbl1, pnlbl2;
    JButton btn;

    public Result() {
        frm = new JFrame("Result");
        
        pnl = new JPanel();
        pnl1 = new JPanel();
        pnl2 = new JPanel();
        pnl1.setBackground(Color.red);
        pnl2.setBackground(Color.green);
        pnl.setLayout(null);
        slbl = new JLabel("Username : "+signin.sName);
        pnlgrid = new Panel();
        pnlgrid.setLayout(new GridLayout(5, 6));
        int x = 1;
        for (int i = 0; i < 30; i++) {

            Button bt = new Button(" " + x);
            if (examinat.y[i] == 0) {
                bt.setBackground(Color.red);
            } else {
                bt.setBackground(Color.green);
            }
            pnlgrid.add(bt);
            x++;

        }
        pnlgrid.setBounds(10, 150, 200, 200);
        pnlbl1 = new JLabel("Incorrect Answer");
        pnlbl2 = new JLabel("Correct Answer");
        plbl1 = new JLabel("Total Questions : 30");
        plbl2 = new JLabel("Correct : " + examinat.count);
        plbl3 = new JLabel("Incorrect : " + (examinat.count1 - examinat.count));
        plbl4 = new JLabel("Attempt : " + examinat.count1);
        plbl5 = new JLabel("Not Attempt : " + (30 - examinat.count1));
        plbl6 = new JLabel("Percentage : " + (examinat.obt_marks * 100) / 120);
        btn = new JButton("Close");
        frm.setSize(600, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);
        
        frm.setResizable(false);
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        slbl.setBounds(10, 10, 300, 30);
        pnlbl1.setBounds(400, 10, 100, 15);
        pnlbl2.setBounds(400, 30, 100, 15);
        pnl1.setBounds(520, 10, 15, 15);
        pnl2.setBounds(520, 30, 15, 15);
        plbl1.setBounds(400, 50, 100, 15);
        plbl2.setBounds(400, 70, 80, 15);
        plbl3.setBounds(400, 90, 80, 15);
        plbl4.setBounds(400, 110, 80, 15);
        plbl5.setBounds(400, 130, 100, 15);
        plbl6.setBounds(400, 150, 100, 15);
        btn.setBounds(400, 220, 80, 30);
        btn.addActionListener(this);
        frm.add(pnl);
        pnl.add(slbl);
        pnl.add(btn);
        pnl.add(plbl1);
        pnl.add(plbl2);
        pnl.add(plbl3);
        pnl.add(plbl4);
        pnl.add(plbl5);
        pnl.add(plbl6);
        pnl.add(pnlgrid);
        pnl.add(pnlbl1);
        pnl.add(pnlbl2);
        pnl.add(pnl1);
        pnl.add(pnl2);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object e = ae.getSource();
        if (e == btn) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        Result obj = new Result();
    }
}
