import java.io.IOException; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
	//step1 - prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/profile_details";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	//step2 - prepare list of sql prepared statements to perform crud to database
	private static final String INSERT_PROFILES_SQL = "INSERT INTO profile" + " (firstname, lastname, gender) VALUES " + " (?, ?);";
	private static final String SELECT_PROFILE_BY_ID = "select firstname, lastname, gender from profile where firstname = ?";
	private static final String SELECT_ALL_PROFILES = "select * from profile ";
	private static final String DELETE_PROFILES_SQL = "delete from profile where firstname = ?;";
	private static final String UPDATE_PROFILES_SQL = "update profile set firstname = ?, lastname= ?, gender =? where firstname = ?;";	

	//step3 - implement the getConnection method which facilitates connection to the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	} 

	//step5 - listProfiles function to connect to the database and retrieve all user records
	
	private void listProfiles (HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException
	{
	
		
		List <Profile> profiles = new ArrayList <> ();
		try (Connection connection = getConnection();
				//step 5.1 - create statement using connection object
				PreparedStatement preparedStatement = 
						connection.prepareStatement(SELECT_ALL_PROFILES);) {
			
			//step5.2 - execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			//step5.3 - process the result set object
			while(rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				profiles.add(new Profile (firstname, lastname, gender));
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//step 5.4 - set the profiles list into the listprofiles attribute to be pass to the profilemangement.jsp
		request.setAttribute("listProfiles", profiles);
		request.getRequestDispatcher("/profileManagement.jsp").forward(request, response);
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {
		//step4 - depending on the request servelet path, determine the function to invoke using the follow switch statement 
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/ProfileServlet/delete":
				deleteProfile(request, response);
				 break;
			case "/ProfileServlet/edit":
				showEditForm(request, response);
				 break;
			case "/ProfileServlet/update":
				updateProfile(request, response);
				 break;
			case "/ProfileServlet/dashboard":
				listProfiles(request, response);
				 break;
			}
		}catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//showEditForm
	//method to get parameter, query database for existing profile data and redirect to profile edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		//get parameter passed in url 
		String firstname = request.getParameter("firstname");
		Profile existingProfile = new Profile ("", "", "");
		//step1 - establishing a connection
		try (Connection connection = getConnection();
				//step2 - create statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROFILE_BY_ID);) {
			
			preparedStatement.setString(1, firstname);
			
			//step3 - execute query / update query
			ResultSet rs = preparedStatement.executeQuery();
			//step4 - process the resultSet object
			while(rs.next()) {
				firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				existingProfile = new Profile (firstname, lastname, gender);
			}
			

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//step5 - set existing user to request and serve up the editUser form
		request.setAttribute("profile", existingProfile);
		request.getRequestDispatcher("/profileEdit.jsp").forward(request, response);
	}
	
	//updateProfile
	//method to update profile table base on the form data 
	private void updateProfile(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
		//step1 - retrieve values from request
		String oriFirstname= request.getParameter("oriFirstname");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		//step2 - attempt connection with database and execute update profile sql query
		try(Connection connection = getConnection(); PreparedStatement statement = 
				connection.prepareStatement(UPDATE_PROFILES_SQL);){
			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, gender);
			statement.setString(4, oriFirstname);
			int i = statement.executeUpdate();
		}
		//step3 - redirect back to profileServlet 
		response.sendRedirect("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");
	}

	//deleteProfile
	//method to delete profile
	private void deleteProfile(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException {
		//step1 - retrieve value from request
		String firstname = request.getParameter("firstname");
		//step2 - attempt connection with database and execute delete profile sql query
		try(Connection connection = getConnection(); PreparedStatement statement = 
				connection.prepareStatement(DELETE_PROFILES_SQL);){
			statement.setString(1, firstname);
			int i = statement.executeUpdate();
		}
		//step3 - redirect back to UserServlet dashboard 
		response.sendRedirect("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");
	}


}
