public class Product {
    private int id;
    private double price;
    private String name;
    private String description;
    private int productNumber;
    public Product(int productNumber, double price, String name, String description) {
        this.productNumber = productNumber;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public int getProductNumber() {
        return productNumber;
    }
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  productNumber + ". " + name + ", pris: " + price;
    }
    public String toStringForMenu() {
        if (productNumber < 10) {
            return """
                    %d. %-85s %.0f
                    \033[3m%s\033[0m""".formatted(productNumber, name, getPrice(), description);
        }
        return """
                %d. %-84s %.0f
                \033[3m%s\033[0m""".formatted(productNumber, name, getPrice(), description);
    }
}
