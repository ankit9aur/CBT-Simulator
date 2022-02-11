package javaapplication1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class exitbox extends JFrame implements ActionListener{

    JFrame frm = new JFrame();
    Button b1, b2;

    public exitbox() {
        Panel pnl = new Panel();
        pnl.setSize(200, 150);
        pnl.setVisible(true);
        pnl.setLayout(null);
        frm.setSize(210, 170);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);
        frm.setResizable(false);
        Label l = new Label("Do you want to finish right now?");
        b1 = new Button("SUBMIT");
        b2 = new Button("NO");
        pnl.add(l);
        l.setBounds(10,20,250,50);
        pnl.add(b1);
        b1.setBounds(20, 80, 60, 30);
        b1.addActionListener((ActionListener) this);
        pnl.add(b2);
        b2.setBounds(100, 80, 60, 30);
        b2.addActionListener((ActionListener) this);
        frm.add(pnl);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == b1) {
            endbox obj = new endbox();
            frm.dispose();
        } else if (src == b2) {
            frm.dispose();
        }
    }

    public static void main(String args[]) {
        exitbox obj = new exitbox();
    }
}
