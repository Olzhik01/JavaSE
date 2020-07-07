
import java.util.*;


public class Task1{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        System.out.println("Give a Fahrenheit degree: ");
        double fahrenheitDegree = scanner.nextDouble();
        System.out.println(
                    (Math.round(( (fahrenheitDegree-32)/1.8) *100))/100.0 + " Celsius"
        );
    }


}






