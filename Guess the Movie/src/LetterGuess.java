
class LetterGuess {
	//Fields
	char [] letterGuess;
	int letterCount;
	
	//Constructors
	LetterGuess(){
		this.letterGuess = new char[30];
		this.letterCount = 0;
	}
	//method add letter guess 
	String addLetter(char letter){
		letterGuess[letterCount] = letter;
		letterCount++;
		
		String str;
		str = String.valueOf(letterGuess[letterCount]);
		return str;
	}
		
	//append letter method
	String getLetter(char letter) {
		String str;
		str = String.valueOf(letter);
		return str;
	}
	
	
	
}
