// Abstract class to enforce a common structure
public abstract class SaleItem {
    protected String itemName;
    protected double price;

    public SaleItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateTotalSales();
}
