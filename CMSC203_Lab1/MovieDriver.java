
import java.util.Scanner;
public class MovieDriver {
	public static void main(String [] args) {
		String yesOrNo;
		do {
			Scanner sc= new Scanner(System.in);
			Movie userMovie= new Movie();
			System.out.println("Enter the name of a movie");
			String movieTitle=sc.nextLine();
			userMovie.setTitle(movieTitle);
			System.out.println("Enter the rating of " + movieTitle);
			String movieRating=sc.nextLine();
			userMovie.setRating(movieRating);
			System.out.println("Enter the number of tickets sold for " + movieTitle);
			int ticketsSold=sc.nextInt();
			userMovie.setSoldTickets(ticketsSold);
			System.out.println(userMovie.toString());
			
			do {
				System.out.println("Do you want to enter another movie? (Enter ONLY y or n)");
				yesOrNo= sc.next();
			}while(!(yesOrNo.equalsIgnoreCase("y"))&&!(yesOrNo.equalsIgnoreCase("n")));
		}while(yesOrNo.equalsIgnoreCase("y"));
			System.out.println("Goodbye");
	}
}
