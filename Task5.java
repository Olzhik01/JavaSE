


public class Task5 {
    public static void main(String[] args) {

        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();
        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);

        SavingsAccount.modifyInterestRate(4);

        System.out.println("Annual Interest Rate is "+SavingsAccount.annualInterestRate+": "+saver1.calculateMonthlyInterest());
        System.out.println("Annual Interest Rate is "+SavingsAccount.annualInterestRate+": "+saver2.calculateMonthlyInterest());

        SavingsAccount.modifyInterestRate(5);

        System.out.println("Annual Interest Rate is "+SavingsAccount.annualInterestRate+": "+saver1.calculateMonthlyInterest());
        System.out.println("Annual Interest Rate is "+SavingsAccount.annualInterestRate+": "+saver2.calculateMonthlyInterest());

    }
}
