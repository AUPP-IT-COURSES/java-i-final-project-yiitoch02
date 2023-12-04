import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoanCalculatorApp extends JFrame {

    // Define frames for different pages
    private JFrame homeFrame;
    private JFrame loanCalculatorFrame;
    private JFrame loanComparisonFrame;

    // Define variables for loan calculation
    private double loanAmount;
    private double interestRate;
    private int repaymentTerm;

    public static void main(String[] args) {
        new LoanCalculatorApp();
    }

    public LoanCalculatorApp() {
        // Create the home page frame
        homeFrame = new JFrame("Loan Comparison App");
        homeFrame.setLayout(new BorderLayout());
        homeFrame.setSize(500, 300);

        // Add introduction label to home page
        JLabel introductionLabel = new JLabel("Welcome to the Loan Comparison App!");
        introductionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        homeFrame.add(introductionLabel, BorderLayout.NORTH);

        // Add buttons to switch between pages
        JPanel buttonPanel = new JPanel();
        JButton loanCalculatorButton = new JButton("Loan Calculator");
        loanCalculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch_to_loan_calculator();
            }
        });
        JButton loanComparisonButton = new JButton("Loan Comparison");
        loanComparisonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch_to_loan_comparison();
            }
        });
        buttonPanel.add(loanCalculatorButton);
        buttonPanel.add(loanComparisonButton);
        homeFrame.add(buttonPanel, BorderLayout.CENTER);

        // Make the home page visible
        homeFrame.setVisible(true);

        // Create the loan calculator frame
        loanCalculatorFrame = new JFrame("Loan Calculator");
        loanCalculatorFrame.setLayout(new FlowLayout());
        loanCalculatorFrame.setSize(400, 200);

        // Add labels and input fields for loan calculator
        JLabel loanAmountLabel = new JLabel("Loan Amount:");
        loanCalculatorFrame.add(loanAmountLabel);
        JTextField loanAmountTextField = new JTextField(10);
        loanCalculatorFrame.add(loanAmountTextField);

        JLabel interestRateLabel = new JLabel("Interest Rate (%):");
        loanCalculatorFrame.add(interestRateLabel);
        JTextField interestRateTextField = new JTextField(10);
        loanCalculatorFrame.add(interestRateTextField);

        JLabel repaymentTermLabel = new JLabel("Repayment Term (Years):");
        loanCalculatorFrame.add(repaymentTermLabel);
        JTextField repaymentTermTextField = new JTextField(10);
        loanCalculatorFrame.add(repaymentTermTextField);

        // Add button to trigger calculation
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input from text fields
                loanAmount = Double.parseDouble(loanAmountTextField.getText());
                interestRate = Double.parseDouble(interestRateTextField.getText());
                repaymentTerm = Integer.parseInt(repaymentTermTextField.getText());

                // Calculate monthly payment
                monthlyPayment = calculateLoanPayment(loanAmount, interestRate, repaymentTerm);

                // Display results
                JOptionPane.showMessageDialog(loanCalculatorFrame, "Monthly Payment: ${monthlyPayment:.2f}", "Loan Calculator Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        loanCalculatorFrame.add(calculateButton);

        // Make the loan calculator frame visible
        loanCalculatorFrame.setVisible(false);

        // Create the loan comparison frame
