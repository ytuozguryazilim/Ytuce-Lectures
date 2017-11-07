package vtlab_java_form_yapimi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class DepInfo {
    
    public static void main (String args []) throws SQLException, IOException {
        String user, pass;
        user = "raj";
        pass = "raj";
        try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/tubebaby", user,pass);
        
	JFrame frame = new TDFrame(conn);
	frame.setVisible(true);
    }
}
