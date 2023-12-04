import java.util.Scanner;

public class SimpleInterestCalculator {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get user input for loan amount
        System.out.print("Enter the loan amount: ");
        double loanAmount = scanner.nextDouble();

        // Get user input for interest rate
        System.out.print("Enter the interest rate (%): ");
        double interestRate = scanner.nextDouble();

        // Get user input for repayment term (years)
        System.out.print("Enter the repayment term (years): ");
        int repaymentTerm = scanner.nextInt();

        // Calculate simple interest
        double simpleInterest = loanAmount * interestRate * repaymentTerm;

        // Display results
        System.out.println("Simple Interest: " + simpleInterest);
    }
}
