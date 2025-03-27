public class OrderLine {
    private Product product;
    private int productNumber;

    public OrderLine(Product product) {
        this.product = product;
        this.productNumber = product.getProductNumber();
    }

    public double getTotalPrice() {
        return product.getPrice();
    }
    public int getProductNumber() {
        return productNumber;
    }
    @Override
    public String toString() {
        return productNumber + ". " + product.getName() + ", pris: " + product.getPrice() + "kr";
    }
}
