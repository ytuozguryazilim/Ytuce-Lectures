package vtlabdene;
import java.sql.*;
import java.io.*;
/**
 * @author furkan
 * bu ornekte, numarasi verilen bir departmanda calisanlarin bilgileri listeleniyor
 */
public class Main {
    public static void main (String args []) throws SQLException, IOException {
	String user, pass;
        user = "postgres";
        pass = "1234";
        Connection conn =
	DriverManager.getConnection("jdbc:postgresql://localhost:5432/company", user,pass);
        
        String dno = readEntry("Departman no'su giriniz: ");
                
        String query = "SELECT lname, salary FROM employee WHERE dno = " + dno;
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery(query);
        
        while (r.next()) {
            String lname = r.getString(1);
            String salary = r.getString(2);
            System.out.println(lname + " " + salary);
        }
        
        s.close(); 
        
        conn.close();
    }
    
    static String readEntry(String prompt) {
        try {
            StringBuffer buffer;
            buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while(c != '\n' && c != -1) {
                buffer.append((char)c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }
}