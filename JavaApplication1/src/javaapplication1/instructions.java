package javaapplication1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class instructions extends JFrame implements ActionListener {

    JFrame frm = new JFrame();
    Button b1;
    JLabel jlb;

    public instructions() {
        jlb = new JLabel();
        jlb.setForeground(Color.green);
        jlb.setBounds(0, 0, 430, 100);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\uit.jpg").getImage().getScaledInstance(jlb.getWidth(), jlb.getHeight(), Image.SCALE_SMOOTH));
        jlb.setIcon(imageIcon);
        Panel pnl = new Panel();
        pnl.setBounds(100, 70, 300, 200);
        pnl.setBackground(Color.black);
        pnl.setVisible(true);
        pnl.setLayout(null);
        pnl.add(jlb);
        frm.setSize(450, 400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);

        JLabel l = new JLabel("Instruction Set");
        JLabel l1 = new JLabel("<html><p>This is a simple user friendly software developed using Java."
                + " <br> It can be applied to schools, colleges etc to conduct exams. <br>"
                + " The procedure for using this software is very easy. Select one <br> "
                + "of the exams listed in the menu. After selecting the choice <br> "
                + "the exam will be started by clicking continue button. The questions <br"
                + " and options are displayed on the screen. We can choose one of <br> the answer."
                + " After completing the exam the results are displayed.<p><html>");
        b1 = new Button("START EXAM");
        pnl.add(l);
        l.setBounds(170, 80, 250, 50);
        l.setForeground(Color.red);
        pnl.add(l1);
        l1.setBounds(30, 100, 400, 210);
        l1.setForeground(Color.white);
        pnl.add(b1);
        b1.setBounds(160, 320, 100, 30);
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
            examinat obj = new examinat();
            frm.dispose();
        }
    }

    public static void main(String args[]) {
        instructions obj = new instructions();
    }
}
