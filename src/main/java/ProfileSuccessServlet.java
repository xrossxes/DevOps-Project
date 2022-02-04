

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileSuccessServlet
 */
@WebServlet("/ProfileSuccessServlet")
public class ProfileSuccessServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public ProfileSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//step1 - initialize a printwriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		
		//step2 - retrieve the 4 parameters from the request from web form
		String a = request.getParameter("firstname");
		String b = request.getParameter("lastname");
		String d = request.getParameter("gender");
		
		//step3 - attempt connection to database using JDBC 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/profile_details", "root", "password");
			
			//Step 4: implement the sql query using prepared statement 
			//(https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			 PreparedStatement ps = con.prepareStatement("insert into PROFILE values(?,?,?)");
			//Step 5: parse in the data retrieved from the web form request into the prepared statement 
			//accordingly
			 ps.setString(1, a);
			 ps.setString(2, b);
			 ps.setString(3, d);
			//Step 6: perform the query on the database using the prepared statement
			 int i = ps.executeUpdate();
			//Step 7: check if the query had been successfully execute, return “Successfully added profile details! 
			//” via the response,
			 if (i > 0){
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + "Successfully added profile details!" + 
			"</h1>");	
			writer.close(); 
			} 
			}
			//Step 8: catch and print out any exception
			catch (Exception exception) {
			 System.out.println(exception);
			 out.close();
		}
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
