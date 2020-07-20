package portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class validate {
    public static boolean checkUser(String email,String psw) 
    {
        boolean st =false;
        try {

            
            Class.forName("com.mysql.jdbc.Driver");

            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourist","root","Tommy@123");
            PreparedStatement ps = con.prepareStatement("select * from register where email=? and psw=?");
            ps.setString(1, email);
            ps.setString(2, psw);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
