package portal;


	import java.io.*;
	
	import javax.servlet.*;
	import javax.servlet.http.*;

	public class login extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String email = request.getParameter("email");
	        String psw = request.getParameter("psw");
	        
	        if(validate.checkUser(email,psw))
	        {
	            RequestDispatcher rs = request.getRequestDispatcher("tourist.html");
	            rs.forward(request, response);
	        }
	        else
	        {
	        	out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("register.html");
	           rs.include(request, response);
	        }
	      out.close();
	    }    
	}

