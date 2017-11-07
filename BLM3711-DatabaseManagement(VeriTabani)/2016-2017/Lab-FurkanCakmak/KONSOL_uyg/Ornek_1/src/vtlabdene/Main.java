package vtlabdene;
import java.sql.*;
import java.io.*;
/**
 * @author furkan
 * bu ornekte, numarasi verilen bir calisanin isim ve maas bilgileri gosteriliyor
 */
public class Main {
    public static void main (String args []) throws SQLException, IOException {
        String user, pass;
        user = "postgres";
        pass = "1234";
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company", user,pass);
        
        String query = "SELECT lname, salary FROM employee WHERE ssn = ?";
        PreparedStatement p = conn.prepareStatement(query);
        
        String ssn = readEntry("Çalışanın SSN no'sunu giriniz: ");
        
        p.clearParameters();
        p.setString(1,ssn);
        
        ResultSet r = p.executeQuery();
        
        if (r.next ()) {
            String lname = r.getString(1);
            double salary = r.getDouble(2);
            System.out.println(lname + " " + salary);
        }
        
        p.close();
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