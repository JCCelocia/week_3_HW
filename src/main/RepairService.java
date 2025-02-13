// Concrete class for repair services
public class RepairService extends SaleItem {
    private int hoursWorked;

    public RepairService(double pricePerHour, int hoursWorked) {
        super("Repair", pricePerHour);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateTotalSales() {
        return price * hoursWorked;
    }
}
