public class InvalidBINException extends Exception {
    private String message;

    public InvalidBINException(String message) {
        super(message);
    }
}
