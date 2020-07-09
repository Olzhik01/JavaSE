public class CherryTree extends FruitTree {

    @Override
    public int produce(int years) {
        int total = 0;
        for(int i=1;i<=years;i++){
            if(i<=8){
                total+=i+2;
            }
            if(i>8){
                total+=11;
            }
        }
        return total;
    }
}
