package vtlab_java_form_yapimi;

import java.sql.*;
import javax.swing.*;

public class TDFrame extends JFrame {
    public TDFrame (Connection conn) {

	setTitle("Department Information");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(750, 500);
	setLocation(200, 200);
	getContentPane().add(new TDPanel(conn));		
    }
}