import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CTask4 {

    public static void main(String[] args) {
        Movie movie1 = new Movie("Terminator",1500);
        Movie movie2 = new Movie("Mstiteli",2500);
        Movie movie3 = new Movie("Hello",1000);
        Movie movie4 = new Movie("Movie",2000);
        Movie movie5 = new Movie("World",3500);


        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        System.out.println(movies);
        //Collections.sort(movies);
        System.out.println(movies);






    }




}


