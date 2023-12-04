import java.util.*;

public class LoanComparison {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get user input for loan 1
            System.out.print("Enter loan amount for loan 1: ");
            double loanAmount1 = scanner.nextDouble();

            System.out.print("Enter interest rate for loan 1 (%): ");
            double interestRate1 = scanner.nextDouble();

            System.out.print("Enter repayment term for loan 1 (years): ");
            int repaymentTerm1 = scanner.nextInt();

            // Get user input for loan 2
            System.out.print("\nEnter loan amount for loan 2: ");
            double loanAmount2 = scanner.nextDouble();

            System.out.print("Enter interest rate for loan 2 (%): ");
            double interestRate2 = scanner.nextDouble();

            System.out.print("Enter repayment term for loan 2 (years): ");
            int repaymentTerm2 = scanner.nextInt();

            // Calculate monthly payments
            double monthlyPayment1 = calculateMonthlyPayment(loanAmount1, interestRate1, repaymentTerm1);
            double monthlyPayment2 = calculateMonthlyPayment(loanAmount2, interestRate2, repaymentTerm2);

            // Compare monthly payments
            if (monthlyPayment1 < monthlyPayment2) {
                System.out.println("\nLoan 1 is better with a monthly payment of $" + monthlyPayment1 + " compared to $" + monthlyPayment2 + " for loan 2.");
            } else if (monthlyPayment1 > monthlyPayment2) {
                System.out.println("\nLoan 2 is better with a monthly payment of $" + monthlyPayment2 + " compared to $" + monthlyPayment1 + " for loan 1.");
            } else {
                System.out.println("\nBoth loans have the same monthly payment of $" + monthlyPayment1 + ".");
            }
        }
    }

    public static double calculateMonthlyPayment(double loanAmount, double interestRate, int repaymentTerm) {
        double monthlyInterestRate = interestRate / 12 / 100;
        int numberOfPayments = repaymentTerm * 12;
        return (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}

