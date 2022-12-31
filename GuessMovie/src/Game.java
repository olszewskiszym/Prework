import java.util.ArrayList;
import java.util.Scanner;

class Game {

    private Scanner readUserInput;
    private final String movie;
    private String dashMovie;
    private final ArrayList<Character> wrongCharacters = new ArrayList<>();
    private int mistakes = 0;

    Game(String movie, String dashMovie) {

        readUserInput = new Scanner(System.in);
        String userInput;
        this.movie = movie;
        this.dashMovie = dashMovie;

        System.out.println("Guess title of the movie. You can type single letters or try to get full name!");
        System.out.println("You can make 10 mistakes.");

        do {

            System.out.println("You are guessing:  "+this.dashMovie);
            System.out.println("You have guessed (" + mistakes + ") wrong letters: "+ wrongCharacters);
            System.out.println("Guess a letter: ");
            userInput = readUserInput.nextLine();

            if (userInput.matches("[a-zA-Z\\s]*")) {
                compareAndChange(userInput.toLowerCase());
            }
            else System.out.println("Only letters! Try again.");

            if (!containsDash()) break;

        } while(mistakes < 10);

        if(mistakes != 10) System.out.println("You win! The movie is: " + this.movie);
        else System.out.println("You lose! You have made 10 mistakes. The movie is: " + this.movie);

    }

    private void compareAndChange(String userInput){

        int charOccurrence;
        char[] charArrayUserInput = userInput.toCharArray();
        char[] charArrayDashMovie = dashMovie.toCharArray();

        for (char charUserInput : charArrayUserInput) {

            charOccurrence = 0;

            for (int y = 0; y < charArrayDashMovie.length; y++) {
                if (movie.charAt(y) == charUserInput) {
                    charArrayDashMovie[y] = charUserInput;
                    charOccurrence++;
                }
            }
            addWrongCharacters(charOccurrence, charUserInput);
            if (mistakes >= 10) break;
        }
        dashMovie = String.valueOf(charArrayDashMovie);
    }

    private void addWrongCharacters(int charOccurrence, char charUserInput) {
        if (charOccurrence == 0 && !wrongCharacters.contains(charUserInput)) {
            wrongCharacters.add(charUserInput);
            mistakes++;
        }

    }

    private boolean containsDash() {
        return dashMovie.contains("_");

    }



}
