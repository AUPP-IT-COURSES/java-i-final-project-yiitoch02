import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SimpleInterestCalculatorUI extends JFrame {

    public SimpleInterestCalculatorUI() {
        setTitle("Simple Interest Calculator");
        setLayout(null);

        // Create labels for user input
        JLabel loanAmountLabel = new JLabel("Loan Amount:");
        loanAmountLabel.setBounds(20, 20, 100, 20);
        add(loanAmountLabel);

        JLabel interestRateLabel = new JLabel("Interest Rate (%):");
        interestRateLabel.setBounds(20, 50, 100, 20);
        add(interestRateLabel);

        JLabel repaymentTermLabel = new JLabel("Repayment Term (Years):");
        repaymentTermLabel.setBounds(20, 80, 120, 20);
        add(repaymentTermLabel);

        // Create text fields for user input
        JTextField loanAmountTextField = new JTextField();
        loanAmountTextField.setBounds(140, 20, 100, 20);
        add(loanAmountTextField);

        JTextField interestRateTextField = new JTextField();
        interestRateTextField.setBounds(140, 50, 100, 20);
        add(interestRateTextField);

        JTextField repaymentTermTextField = new JTextField();
        repaymentTermTextField.setBounds(140, 80, 100, 20);
        add(repaymentTermTextField);

        // Create a button to trigger calculation
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(250, 50, 80, 20);
        add(calculateButton);

        // Add action listener to the calculate button
        calculateButton.addActionListener(e -> {
            try {
                // Get user input from text fields
                double loanAmount = Double.parseDouble(loanAmountTextField.getText());
                double interestRate = Double.parseDouble(interestRateTextField.getText());
                int repaymentTerm = Integer.parseInt(repaymentTermTextField.getText());

                // Calculate simple interest
                double simpleInterest = loanAmount * interestRate * repaymentTerm;

                // Display results in a message dialog
                JOptionPane.showMessageDialog(null, "Simple Interest: " + simpleInterest);
            } catch (NumberFormatException exception) {
                // Handle invalid input
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.");
            }
        });

        // Set frame size and visibility
        setSize(400, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleInterestCalculatorUI();
    }
}
