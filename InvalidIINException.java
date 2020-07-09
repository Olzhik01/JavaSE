

public class InvalidIINException extends Exception {
    private String message;

    public InvalidIINException(String message) {
        this.message = message;
        System.out.println("InvalidIINException: "+message);
    }
}
