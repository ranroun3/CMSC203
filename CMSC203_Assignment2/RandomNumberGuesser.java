import java.util.Scanner;
public class RandomNumberGuesser {
	static int lowGuess;
	static int nextGuess; 
	static int highGuess;
	static boolean isCorrectGuess;
	static boolean nextGame;

	//While I know the logic for this might seem a bit complicated, I wanted to try to challenge myself to modularize my code as 
	//much as possible. I originally had this code written as two nested do-while loops, but wanted to see if I could get it done.
	//The code here is a bit loopy, but in the future it should be relatively straightforward.

	public static void main(String [] args) {
		nextGame=true;
		while(nextGame==true) {
			lowGuess=0;
			highGuess=100;
			RNG.resetCount();
			isCorrectGuess=false;
			int randNum=RNG.rand();

			System.out.println("Welcome to the random number guessing game! (hint: try " + randNum + ")");
			initialGuess(randNum);

			while(isCorrectGuess == false) {
				do{
					System.out.println("Enter a number between " + lowGuess + " and " + highGuess + ": ");
					Scanner sc = new Scanner(System.in);
					nextGuess=sc.nextInt();
				}while(RNG.inputValidation(nextGuess, lowGuess, highGuess)==false);
				System.out.println("The number of guesses is " + RNG.getCount());
				guess(nextGuess, randNum);

			}


		}
	}
	public static void initialGuess(int randNum) {
		Scanner sc= new Scanner(System.in);
		do {
			RNG.resetCount();
			System.out.println("Enter your first guess between 0 and 100: ");
			nextGuess=sc.nextInt();			
		}while(RNG.inputValidation(nextGuess, lowGuess, highGuess)==false);
		System.out.println("The number of guesses is " + RNG.getCount());
		guess(nextGuess, randNum);
	}
	public static void guess(int next, int rand){

		if((nextGuess<highGuess) && (nextGuess<rand)) {
			System.out.println("Your guess is too low.");
			setNewLowGuess(nextGuess);


		}
		else if((nextGuess<highGuess)  &&(nextGuess>rand)) {
			System.out.println("Your guess is too high.");
			setNewHighGuess(nextGuess);

		}
		else if(nextGuess==rand) {
			winningGuess();
		}

	}
	public static void setNewLowGuess(int nextGuess) {
		lowGuess=nextGuess;
	}
	public static void setNewHighGuess(int nextGuess) {
		highGuess=nextGuess;
	}

	public static void winningGuess() {
		isCorrectGuess=true;
		System.out.println("Congratulations! You guessed correctly.");
		char nextChar;
		do {

			Scanner sc = new Scanner(System.in);
			System.out.println("Try again? (y or n)");
			nextChar=sc.nextLine().charAt(0);
			if(nextChar =='y') {
				nextGame=true;
			}
			else if (nextChar == 'n') {
				nextGame=false;
				System.out.println("Thanks for playing...");
			}
		}while(nextChar != 'y' && nextChar != 'n');


	}
}
