public class Movie {
	protected String title;
	protected String director;
	protected String releaseDate;
	protected String genre;
	protected String plot;
	
	/**
	 * @param title
	 * @param director
	 * @param releaseDate
	 * @param genre
	 * @param plot
	 */
	
	public Movie(String title, String director, String releaseDate, String genre, String plot) {
		super();
		this.title = title;
		this.director = director;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.plot = plot;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * @return the releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}
	/**
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}
}