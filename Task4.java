

public class Task4 {
    public static void main(String[] args) {
        CarSale car1 = new CarSale("Toyota",25000,18);
        CarSale car2 = new CarSale("BMW",30000,25);
        CarSale car3 = new CarSale("Lada",20000,10);

        CarSale[] carsList = {car1,car2,car3};
        CarSale[] emptyList = {};

        System.out.println(car1.getCarName()+" "+car1.getFinalCostOfCar());
        System.out.println(car2.getCarName()+" "+car2.getFinalCostOfCar());
        System.out.println(car3.getCarName()+" "+car3.getFinalCostOfCar());

        System.out.println("The Cheapest Car is "+findCheapestCar(carsList).getCarName()+" with final cost "+findCheapestCar(carsList).getFinalCostOfCar());
        System.out.println("Total cost of cars is "+totalCostOfCars(carsList));

        //System.out.println(findCheapestCar(emptyList)); /* if array is empty,it returns null*/
        //System.out.println(totalCostOfCars(emptyList));  /* if array is empty,it returns 0*/
    }


    public static CarSale findCheapestCar(CarSale[] carSales){

        if(carSales.length!=0) {
            CarSale cheapestCar = carSales[0];

            for (CarSale c : carSales) {

                if (c.getFinalCostOfCar() < cheapestCar.getFinalCostOfCar()) {
                    cheapestCar = c;
                }
            }
            return cheapestCar;
        }
        else{
            return null;
        }
    }

    public static int totalCostOfCars(CarSale[] carSales){
        if(carSales.length==0) {
            return 0;
        } else{
            int totalCost = 0;
            for (CarSale c : carSales) {
                totalCost += c.getFinalCostOfCar();
            }
            return totalCost;
        }
    }
}
