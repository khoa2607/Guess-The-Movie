
class MovieList {

	//fields
	String [] name;
	int MovieCount;
	
	//Constructor
	MovieList(){
		this.MovieCount = 0;
		this.name = new String[500];
	}
	
	//add to List of Movie
	void addMovieName(String MovieName) {
		name[MovieCount] = MovieName;
		MovieCount++;
	}
	
	//get method
	String getMovieName(int position) {
		return name[position-1];
	}
	
	
	
}
