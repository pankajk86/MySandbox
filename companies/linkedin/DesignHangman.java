package linkedin;

import java.util.Arrays;

public class DesignHangman {

	public static void main(String[] args) {
		String s = "dedication";
		
		Hangman game = new Hangman(s);
		char[] guesses = {'e', 'a', 'k', 'd', 't', 'c', 'i', 'n', 'o'};
		Status status = Status.IN_PROGRESS;
		
		for(int i = 0; status == Status.IN_PROGRESS && i < guesses.length; i++) {
			status = game.match(guesses[i]);
			System.out.println("Current Guess: " + guesses[i] + ", Guesses: " + game.getCurrentGuesses() + 
					", status: " + status + ", turns left: " + game.getTurnsLeft());
		}
	}

}

class Hangman {
	private final int ALLOWED_TURNS = 8;
	private final String wordToGuess;
	private final int size;
	private int turnsLeft;
	private int correctGuesses;
	private char[] guessedChars;
	
	public Hangman(String wordToGuess) {
		this.wordToGuess = wordToGuess;
		this.size = wordToGuess.length();
		this.correctGuesses = 0;
		this.turnsLeft = ALLOWED_TURNS;
		this.guessedChars = new char[size];
		
		Arrays.fill(guessedChars, '_');
	}
	
	public Status match(char guess) {
		
		for(int i = 0; i < wordToGuess.length(); i++) {
			if(wordToGuess.charAt(i) == guess) {
				guessedChars[i] = guess;
				correctGuesses++;
			}
		}
		
		turnsLeft--;
		if(turnsLeft > 0) {
			return correctGuesses == size ? Status.SUCCESS : Status.IN_PROGRESS;
		} else {
			return correctGuesses == size ? Status.SUCCESS : Status.FAILURE;
		}
	}
	
	public String getCurrentGuesses() {
		return String.valueOf(guessedChars);
	}
	
	public int getTurnsLeft() {
		return this.turnsLeft;
	}
}

enum Status {
	IN_PROGRESS, FAILURE, SUCCESS
}
