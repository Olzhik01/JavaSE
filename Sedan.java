



//related to Task6
public class Sedan extends Car {
    private int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

//    public Sedan(){}

    public double getSalePrice(){

        if(length==20){
            return super.getSalePrice() - super.getSalePrice()*(5.0/100);
        }
        else{
            return super.getSalePrice() - super.getSalePrice()*(10.0/100);
        }
    }




}

