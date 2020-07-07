


// related to Task4
public class CarSale {
    private String carName;
    private int carPrice;
    private double discountForCarInPercent;
    private int finalCostOfCar;


    public CarSale(String carName, int carPrice, double discountForCarInPercent) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.discountForCarInPercent = discountForCarInPercent;
    }

    @Override
    public String toString() {
        return "CarSale{" +
                "carName='" + carName + '\'' +
                ", carPrice=" + carPrice +
                ", discountForCar=" + discountForCarInPercent +
                ", finalCostOfCar=" + finalCostOfCar +
                '}';
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public double getDiscountForCar() {
        return discountForCarInPercent;
    }

    public int getFinalCostOfCar() {
        return (int)(carPrice - carPrice*(discountForCarInPercent/100));
    }
}
