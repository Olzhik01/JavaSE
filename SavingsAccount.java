

// related to Task5
public class SavingsAccount {
    static double annualInterestRate;
    private double savingsBalance;

    public double calculateMonthlyInterest(){
        return (savingsBalance*annualInterestRate)/12 + savingsBalance;
    }

    public static void  modifyInterestRate(double annualInterestRate) {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

}
