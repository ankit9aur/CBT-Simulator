package javaapplication1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class endbox extends JFrame implements ActionListener{
    JFrame frm = new JFrame();
    Button b1;

    public endbox() {
        Panel pnl = new Panel();
        pnl.setSize(300, 200);
        pnl.setVisible(true);
        pnl.setLayout(null);
        frm.setSize(250, 150);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);
        
        Label l = new Label("Successfully Submitted");
        b1 = new Button("VIEW RESULT");
        pnl.add(l);
        l.setBounds(40,10,250,50);
        pnl.add(b1);
        b1.setBounds(40, 60, 140, 30);
        b1.addActionListener((ActionListener) this);
        frm.add(pnl);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == b1) {
            Result obj = new Result();
            frm.dispose();
        }
    }

    public static void main(String args[]) {
        endbox obj = new endbox();
    }
}
