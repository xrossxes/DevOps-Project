
public class User {
	
	protected String name;
	
	/**
	 * @return the name
	 */
	
	public User(String name, String password, String email) {
		super();
		this.name= name;
		this.password = password;
		this.email = email;
	}
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	protected String password;
	
	protected String email;

}
