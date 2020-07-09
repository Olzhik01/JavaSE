import java.util.ArrayList;

public class RaffleDrum<T extends Card> {
    private ArrayList<T> cards = new ArrayList<>();

    public RaffleDrum(){}

    public void addCard(T card){
        cards.add(card);
    }

    public T getWinner(){
        T winner = cards.get(0);
        int index = 0;
        for(int i=0;i<cards.size();i++){
            if(cards.get(i).getChance()>winner.getChance()){
                winner = cards.get(i);
                index = i;
            }
            if(cards.get(i).getChance()==winner.getChance()){
                if(index>i){
                    winner = cards.get(i);
                    index = i;
                }

            }
        }
        return winner;
    }


    public ArrayList<T> filterChanceBigger(int n){
        ArrayList<T> arrayList = new ArrayList<>();
        for(T c:cards){
            if(c.getChance()>n){
                arrayList.add(c);
            }
        }
        return arrayList;
    }
}
