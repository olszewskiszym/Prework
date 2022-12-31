import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PickMovie {
    private final ArrayList<String> listOfMovies = new ArrayList<>();

    PickMovie() {

        try {
            File moviesFile = new File("movies.txt");
            Scanner readMoviesFile = new Scanner(moviesFile);

            while (readMoviesFile.hasNextLine()){
                listOfMovies.add(readMoviesFile.nextLine());
            }

            readMoviesFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("No film list.");
        }
    }

    String randomPickMovie() {
        return listOfMovies.get((int) (Math.random() * listOfMovies.size()));
    }

    String dashRandomPickMovie(String randomPickMovie) {
        return randomPickMovie.replaceAll("[a-zA-Z0-9]", "_");
    }

}
