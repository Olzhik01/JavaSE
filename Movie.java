import java.util.Comparator;

public class Movie{
    private String movieName;
    private int moviePrice;

    public Movie(String movieName, int moviePrice) {
        this.movieName = movieName;
        this.moviePrice = moviePrice;
    }

    public Movie(){}



    //    @Override
//    public int compareTo(Movie o) {
//        return this.moviePrice - o.moviePrice;
//    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }

    @Override
    public String toString() {
        return movieName + " " + moviePrice;
    }
}
