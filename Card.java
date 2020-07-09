

public abstract class Card implements Comparable<Card>{

    @Override
    public int compareTo(Card o) {
        if(getChance()>o.getChance()){
            return 1;
        }
        else if(getChance()<o.getChance()){
            return -1;
        }
        else{
            return 0;
        }
    }

    public abstract int getChance();
}
