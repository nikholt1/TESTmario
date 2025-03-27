import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private Menu menu;
    private OrderHistory orderHistory;
    Scanner scanner = new Scanner(System.in);
    public Manager() {
        menu = new Menu();
        orderHistory = new OrderHistory();
    }

    // Method to display the menu
    public void displayMenu() {
        menu.displayMenu();
    }

    // Method to place an order
    public void placeOrder(ArrayList<OrderLine> orderLines) {
        System.out.println("Indtast afhentningstid i minutter: ");
        int inputTime = scanner.nextInt();
        Order order = new Order(inputTime);
        for (OrderLine orderLine : orderLines) {
            order.addOrderLine(orderLine);
        }
        orderHistory.addOrder(order);
        System.out.println("Order placed:\n" + order);
    }

    // Method to change the price of an item
    public void changeItemPrice(int productNumber, double newPrice) {
        menu.changePrice(productNumber, newPrice);
    }

    // Method to get the price of a product by name
    public double getProductPrice(int productNumber) {
        return menu.getPrice(productNumber);
    }

    // Method to view the order history
    public void viewOrderHistory() {
        orderHistory.displayOrders();
    }

    public String getName(int productNumber) {
        return menu.getName(productNumber);
    }
    // Method to get total turnover
    public double getTotalTurnover() {
        return orderHistory.getTotalTurnover();
    }
    public void showMostPopularItem() {
        orderHistory.showMostPopularItem();
    }
    public void setOrderStatus() {
        System.out.println("Input id for odre der skal COMPLETES");
        int id = scanner.nextInt();
        orderHistory.setOrderStatus(id);

    }
    public void showOrderDetails(int id) {
        orderHistory.showOrderDetails(id);
    }
}
