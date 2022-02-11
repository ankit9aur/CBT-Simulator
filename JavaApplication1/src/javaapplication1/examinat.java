package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class examinat extends JFrame implements Runnable, ActionListener {

    int x;
    public static int count = 0,count1=0,obt_marks,y[]=new int[30];
    Object obj;
    ResultSet rs;
    JFrame frm;
    JPanel p, p2, p3;
    JLabel l, l1, l2, l3, lbl4, lbl5, lbl6, lbl7, lbl, lq, lid;
    JTextArea ta;
    JButton pre, s, n, m, e, btn1, btn2, btn3, btn4;
    JButton[] btn = new JButton[30];
    JRadioButton rb1, rb2, rb3, rb4;
    int qmark;
    Thread th;
    boolean b = true;
    int hour = 0, minute = 59, second = 59;
    String str;
    ButtonGroup bg;
    String[][] user = new String[30][2];
    
    

    public examinat() {
        for (int k = 0; k < 30; k++) {
            for (int t = 0; t < 2; t++) {
                user[k][t] = "";
                y[k]=0;
            }
        }
        frm = new JFrame("Main");
        frm.setSize(790, 710);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frm.setLocation(dim.width / 2 - frm.getSize().width / 2, dim.height / 2 - frm.getSize().height / 2);
        frm.setVisible(true);
        frm.setResizable(false);
        p = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p.setBackground(Color.yellow);
        p2.setBackground(Color.lightGray);
        bg = new ButtonGroup();
        pre = new JButton("PREVIOUS");
        s = new JButton("START");
        n = new JButton("NEXT");
        m = new JButton("MARK");
        e = new JButton("END EXAM");
        e.addActionListener(this);
        m.addActionListener(this);
        btn1 = new JButton("");
        btn2 = new JButton("");
        btn3 = new JButton("");
        btn4 = new JButton("");
        btn1.setBackground(Color.orange);
        btn2.setBackground(Color.green);
        btn3.setBackground(Color.red);
        btn4.setBackground(Color.yellow);
        l2 = new JLabel("QTEXT: ");
        l1 = new JLabel();
        lq = new JLabel();
        lid = new JLabel();
        ta = new JTextArea();
        l3 = new JLabel("Total marks: 120");
        lbl = new JLabel("INDEX:");
        lbl4 = new JLabel("1. Viewed but not attempted");
        lbl5 = new JLabel("2. Viewed and attempted");
        lbl6 = new JLabel("3. Not viewed and not attempted");
        lbl7 = new JLabel("4. Viewed but booked");
        pre.addActionListener(this);
        n.addActionListener(this);
        s.addActionListener(this);
        frm.add(p);
        p.setLayout(null);
        p2.setLayout(null);
        p3.setLayout(null);
        p.setBounds(0, 0, 390, 380);
        p2.setBounds(390, 0, 380, 310);
        p3.setBounds(390, 310, 380, 350);
        p.add(p2);
        p.add(p3);
        p.add(l1);
        p.add(l2);
        p.add(lid);
        p.add(l3);
        p.add(pre);
        p.add(s);
        p.add(n);
        p.add(m);
        p.add(e);
        p2.add(lbl);
        p2.add(lbl4);
        p2.add(lbl5);
        p2.add(lbl6);
        p2.add(lbl7);
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btn4);
        lbl.setBounds(5, 10, 40, 20);
        l1.setBounds(10, 10, 100, 30);
        l2.setBounds(10, 50, 80, 30);
        lid.setBounds(100, 50, 80, 30);
        l3.setBounds(10, 90, 100, 30);
        s.setBounds(5, 150, 75, 30);
        pre.setBounds(85, 150, 105, 30);
        n.setBounds(195, 150, 75, 30);
        m.setBounds(280, 150, 105, 30);
        e.setBounds(280, 20, 105, 30);
        lbl4.setBounds(50, 20, 200, 50);
        lbl5.setBounds(50, 100, 200, 50);
        lbl6.setBounds(50, 180, 200, 50);
        lbl7.setBounds(50, 260, 200, 50);
        btn1.setBounds(300, 20, 70, 50);
        btn2.setBounds(300, 100, 70, 50);
        btn3.setBounds(300, 180, 70, 50);
        btn4.setBounds(300, 260, 70, 50);
        l = new JLabel("QUESTION: ");
        l.setBounds(5, 200, 70, 20);
        ta.setBounds(2, 230, 350, 150);
        ta.setEditable(false);
        ta.setBackground(Color.yellow);
        ta.setForeground(Color.black);//lq.setPreferredSize(new Dimension(200,200));
        ta.setFont(new Font("Comic Sans", 1, 16));
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        rb1 = new JRadioButton("");
        rb1.setBounds(5, 430, 375, 50);
//rb1.setBackground(Color);
        rb1.addActionListener(this);
        rb2 = new JRadioButton("");
        rb2.setBounds(5, 490, 375, 50);
//rb2.setBackground(Color.blue);
        rb2.addActionListener(this);
        rb3 = new JRadioButton("");
        rb3.setBounds(5, 550, 375, 50);
//rb3.setBackground(Color.blue);
        rb3.addActionListener(this);
        rb4 = new JRadioButton("");
        rb4.setBounds(5, 610, 375, 50);
//rb4.setBackground(Color.blue);
        rb4.addActionListener(this);
        p.add(l);
        p.add(ta);
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        p.add(rb4);
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        p3.setLayout(new GridLayout(6, 5));
        sql();
        int x = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 5; j++) {
//JButton btn=new JButton(""+x);
                btn[x] = new JButton((x + 1) + "");
                p3.add(btn[x]);
                btn[x].addActionListener(this);
                btn[x].setBackground(Color.red);
                x++;
            }
        }
        /*th=new Thread(this,"mythread");
th.start();
         */
        frm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void run() {
        int hours = 00, minutes = 59, seconds = 59;
        str = "TIME : " + hours + ":" + minutes + ":" + seconds;
        l1.setText(str);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            seconds--;
            if (seconds == 00 && minutes == 00 && hours == 00) {
                endbox obj = new endbox();
                frm.setVisible(false);
                break;
            }
            if (seconds == 00) {
                minutes--;
                seconds = 59;
            }
            if (minutes == 00) {
                hours = 00;
            }
            str = "TIME : " + hours + ":" + minutes + ":" + seconds;
            l1.setText(str);
        }
    }

    public void sql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cbt", "root", "");
            String query = "select * from exams";
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(query);
            setdata();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public void setdata() throws Exception {
        lid.setText(rs.getString("qid"));
        ta.setText(rs.getString("question"));
        rb1.setText(rs.getString("op1"));
        rb2.setText(rs.getString("op2"));
        rb3.setText(rs.getString("op3"));
        rb4.setText(rs.getString("op4"));
    }

    public void reseted() {
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Object obj = ae.getSource();
            if (obj == s) {
                th = new Thread(this, "mythread");
                th.start();
                reseted();
                rs.next();
                setdata();
            }
            if (obj == n) {
                bg.clearSelection();
                rs.next();
                setdata();

            } else if (obj == pre) {
                rs.previous();
                setdata();

            }
            String z = lid.getText();
            int a = Integer.parseInt(z) - 1;
           
            if (obj == rb1) {
                if("".equals(user[a][1])){
                    count1++;
                }
                user[a][0] = "" + (a + 1);
                user[a][1] = rb1.getText();
                
            }
            if (obj == rb2) {
                if("".equals(user[a][1])){
                    count1++;
                }
                user[a][0] = "" + (a + 1);
                user[a][1] = rb2.getText();
            }
            if (obj == rb3) {
                if("".equals(user[a][1])){
                    count1++;
                }
                user[a][0] = "" + (a + 1);
                user[a][1] = rb3.getText();
            }
            if (obj == rb4) {
                if("".equals(user[a][1])){
                    count1++;
                }
                user[a][0] = "" + (a + 1);
                user[a][1] = rb4.getText();
            }
            if (obj == rb1 || obj == rb2 || obj == rb3 || obj == rb4) {
                btn[a].setBackground(Color.green);
            }
            if (obj == m) {
                btn[a].setBackground(Color.yellow);
            }
            for (int j = 0; j <= btn.length - 1; j++) {
                if (obj == btn[j]) {
                    try {
                        rs.absolute(j + 1);
                        setdata();
                        
                        btn[j].setBackground(Color.orange);
                    } catch (Exception tf) {
                        System.out.print(tf);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        String str = ae.getActionCommand();
        if (str.equals("END EXAM")) {
            exitbox obj = new exitbox();
            for (int j = 0; j < 30; j++) {
                try {
                    int c=Integer.parseInt(user[j][0]);
                    rs.absolute(j + 1);
                    if (c == rs.getInt("qid") && (user[j][1] == null ? rs.getString("cop") == null : user[j][1].equals(rs.getString("cop")))) {
                        count++;
                        y[j]=1;
                    }
                    else
                            y[j]=0;
                } catch (NumberFormatException | SQLException tf) {
                    System.out.print(tf);
                }
            }
            obt_marks=count*4-(count1-count);
            System.out.println(obt_marks);
            System.out.println(count);
            
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cbt", "root", "");
            PreparedStatement stat = con.prepareStatement("INSERT INTO `result`(`student_name`,`username`,`obtained_marks`,`maximum_marks`) VALUES (?,?,?,?)");
            stat.setString(1, signin.sName);
            stat.setString(2, signin.username);
            stat.setInt(3, obt_marks);
            stat.setInt(4, 120);
            
            int rowi = stat.executeUpdate();
            if (rowi > 0) {
                JOptionPane.showMessageDialog(this, "Data inserted...............");
                frm.dispose();
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(this, "Data not inserted..............." + e1);
        }
        }
    }

    public static void main(String[] args) {
        examinat obj = new examinat();
    }
}
