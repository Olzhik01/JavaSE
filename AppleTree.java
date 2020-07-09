public class AppleTree extends FruitTree {
    @Override
    public int produce(int years) {
        int total = 0;
        for(int i=1;i<=years;i++){
            if(i==1 || i==2){
                total+=0;
            }
            if(i>=3 && i<=6){
                total+=(5*i)+5;
            }
            if(i>6){
                total+=40;
            }
        }
        return total;
    }
}
