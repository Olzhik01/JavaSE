

public class ReaderStudentCard extends Card{
    private String name;
    private int numBooksRead;

    public ReaderStudentCard(String name, int numBooksRead) {
        this.name = name;
        this.numBooksRead = numBooksRead;
    }

    @Override
    public String toString() {
        return "Reader "+name+ " read "+numBooksRead+" books";
    }

    @Override
    public int getChance() {
        return name.length() + (numBooksRead*10);
    }


}
