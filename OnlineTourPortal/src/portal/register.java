package portal;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("psw");
        
        try {
        
            
            Class.forName("com.mysql.jdbc.Driver");
            
            
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/tourist","root","Tommy@123");

            PreparedStatement ps = con.prepareStatement
                        ("insert into register(fname,lname,email,psw)"+"values(?,?,?,?)");

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, pass);
            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("You are sucessfully registered");
                RequestDispatcher rs= request.getRequestDispatcher("login.html");
                rs.forward(request,response);
            }
        con.close();
        }
        catch(Exception se) {
            throw new ServletException("Login failed",se);
        }
	
    }
}
