import java.util.Scanner;

public class Task2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Give a string to reverse: ");
        String initialString = scanner.next();
        String reverseString = "";

        for(int i=initialString.length()-1;i>=0;i--){
            reverseString+= initialString.charAt(i);
        }
        System.out.println(reverseString);


    }
}
