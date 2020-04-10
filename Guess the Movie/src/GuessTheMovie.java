import java.util.Scanner;
import java.io.File;
import java.util.Random;

class GuessTheMovie {
	
	public static void main(String [] args) throws Exception {
		
		//create a new list of Movie
		MovieList myMovieList = new MovieList();
		
		//import text file of the movie
		File MovieList = new File("movies.txt");
		
		//Read the file
		Scanner scanner = new Scanner(MovieList);		
		
		//Using Scanner
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			myMovieList.addMovieName(line);
		}
		
		//create a random number between 1 to 25 to pick a line and display the line (movie name)
		Random rand = new Random();
		int MovieRand = rand.nextInt(25)+1;
		
		//Convert the name of the movie into dash
		String MovieNameChosen = myMovieList.getMovieName(MovieRand);
		
		String ConvertDash;
		ConvertDash = MovieNameChosen.replaceAll("[A-Za-z0-9]", "-");
		
		System.out.println("The Movie chosen is: "+ MovieNameChosen);
		
		//Main
		
		System.out.println("The name of the movie is: "+ ConvertDash);
		
		//String to char array
		char [] charsName = MovieNameChosen.toCharArray();
		char [] charsNameDash = ConvertDash.toCharArray();
		//loop through string to see a match of letter
		
		char dash = '-';
		int NumberOfDash =0;
		for(int i=0;i<charsNameDash.length;i++) {
			if(charsNameDash[i]==dash) {
			NumberOfDash++;
			}
		}
		//System.out.println("Number of Dash is: " + NumberOfDash);
		//set up some variable for playing game
		boolean hasWon = false;
		boolean continueToPlay = true;
		boolean correctly = true;
		boolean alreadyType = false;
		int wrongAnswer = 0;
		int match =0;
		
		//System.out.println("Array length :" +arrayInput.length);
		
		StringBuilder str = new StringBuilder("");
	
		System.out.println("Please start guessing 1 letter");
		while(continueToPlay) {
			//get user input letter from scanner
			
			Scanner UserInput = new Scanner(System.in);
			String UserGuessString = UserInput.nextLine();
			char UserGuesschar = UserGuessString.charAt(0);
						
			System.out.println("You just entered: " + UserGuesschar);
			
			//check if this input was already typed
			if(str.length()>0) {
				for (int i=0;i<str.length();i++) {
					if(UserGuesschar==str.charAt(i)) {
						alreadyType = true;
						System.out.println("You already typed this letter "+UserGuesschar+". Please enter another letter" );
						break;
					}
				}
			}
			//check to see if the input is match or not with movie
			if(alreadyType==false) {
				for(int i=0;i<charsName.length;i++) {
					if(charsName[i]==UserGuesschar) {
						charsNameDash[i] = UserGuesschar; //display on the Dash Movie Name
						match++;
						NumberOfDash--;		
					}
				}
			}
			System.out.println("we have " + match +" letter(s) " + UserGuesschar+  " in the movie");
			
			if(match==0) {
				correctly=false;
			}
			
			str = str.append(UserGuesschar);
			System.out.println("You already guessed: " + str);
			
			ConvertDash = String.valueOf(charsNameDash);
			
			System.out.println("The name of Movie right now is: "+ ConvertDash);		
			
			if(correctly == false) {
				wrongAnswer++;
				System.out.println("You guess wrong " + wrongAnswer + " time(s)");
				correctly = true;
			}
			match =0;
			alreadyType = false;
			if(NumberOfDash==0) {
				hasWon = true;
			}
			if(hasWon) { //for future expansion, like asking if user want to play
				System.out.println("YOU WON!!!");
				continueToPlay = false;
			}
		}
	}
}

