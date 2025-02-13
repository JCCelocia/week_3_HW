import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class with GUI
public class SalesCalculator extends JFrame {
    private JTextField phonePriceField, phoneQuantityField;
    private JTextField repairRateField, repairHoursField;
    private JTextArea resultArea;

    public SalesCalculator() {
        setTitle("Sales Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Phone input
        add(new JLabel("Phone Price:"));
        phonePriceField = new JTextField("500");
        add(phonePriceField);

        add(new JLabel("Quantity Sold:"));
        phoneQuantityField = new JTextField("10");
        add(phoneQuantityField);

        // Repair service input
        add(new JLabel("Repair Rate (per hour):"));
        repairRateField = new JTextField("50");
        add(repairRateField);

        add(new JLabel("Hours Worked:"));
        repairHoursField = new JTextField("5");
        add(repairHoursField);

        // Button
        JButton calculateButton = new JButton("Calculate Total Sales");
        add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSales();
            }
        });

        setVisible(true);
    }

    private void calculateSales() {
        try {
            double phonePrice = Double.parseDouble(phonePriceField.getText());
            int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());

            double repairRate = Double.parseDouble(repairRateField.getText());
            int repairHours = Integer.parseInt(repairHoursField.getText());

            PhoneSale phoneSale = new PhoneSale(phonePrice, phoneQuantity);
            RepairService repairService = new RepairService(repairRate, repairHours);

            double phoneTotal = phoneSale.calculateTotalSales();
            double repairTotal = repairService.calculateTotalSales();

            resultArea.setText("Total Sales:\n");
            resultArea.append("Phones: ₱" + phoneTotal + "\n");
            resultArea.append("Repairs: ₱" + repairTotal + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new SalesCalculator();
    }
}
