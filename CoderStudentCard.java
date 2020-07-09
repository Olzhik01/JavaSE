import java.util.*;

public class CoderStudentCard extends Card{
    private String name;
    private int numProblemsSolved;


    public CoderStudentCard(String name, int numProblemsSolved) {
        this.name = name;
        this.numProblemsSolved = numProblemsSolved;
    }

    @Override
    public int getChance() {
        int uniqueLetters = 0;
        List<Character> list = new LinkedList<>();
        for(int i=0;i<name.toLowerCase().length();i++){
            if(!list.contains(name.toLowerCase().charAt(i))){
                list.add(name.toLowerCase().charAt(i));
                uniqueLetters++;
            }
        }
        return uniqueLetters+numProblemsSolved;

    }

    @Override
    public String toString() {
        return "Coder "+name+" solved "+numProblemsSolved+" problems";
    }


}
