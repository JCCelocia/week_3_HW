// Concrete class for phone sales
public class PhoneSale extends SaleItem {
    private int quantitySold;

    public PhoneSale(double price, int quantitySold) {
        super("Phone", price);
        this.quantitySold = quantitySold;
    }

    @Override
    public double calculateTotalSales() {
        return price * quantitySold;
    }
}
