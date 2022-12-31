public class Main {

    public static void main(String[] args) {


        final PickMovie choseMovie = new PickMovie();

            String movie = choseMovie.randomPickMovie();
            String dashMovie = choseMovie.dashRandomPickMovie(movie);

            Game game = new Game(movie, dashMovie);
        }

    }
