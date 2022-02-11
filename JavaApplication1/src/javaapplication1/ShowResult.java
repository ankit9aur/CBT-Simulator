package javaapplication1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ShowResult extends JFrame implements ActionListener {

    JTable table;
    ResultSet rs;
    int a;

    ShowResult() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cbt", "root", "");
            String query = "select * from result";
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(query);
            rs.last();
            a = rs.getRow();
            rs.beforeFirst();
            
        } catch (Exception e) {
            System.out.print(e);
        }

        setSize(500, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        int b = 0;
        Object[][] data1 = new Object[a][4];
        String[] columnName = {"Student Name", "Username", "Marks Obtained", "Maximum Marks"};
        while (rs.next()) {
            if (b < a) {
                
                data1[b][0] = rs.getString(1);
                data1[b][1] = rs.getString(2);
                data1[b][2] = rs.getString(3);
                
                data1[b++][3] = rs.getString(4);
               
            }
        }

        DefaultTableModel model = new DefaultTableModel(data1, columnName);

        table = new JTable(model);

        add(new JScrollPane(table));
        validate();
    }

    public static void main(String args[]) throws SQLException {
        ShowResult obj = new ShowResult();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
