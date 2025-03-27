import java.util.Scanner;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Manager manager;

    public UserInterface(Manager manager) {
        this.scanner = new Scanner(System.in);
        this.manager = manager;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Vis menukort");
            System.out.println("2. Vis aktive ordre");
            System.out.println("3. Opret ordre");
            System.out.println("4. vis ordredetaljer");
            System.out.println("5. Færdiggør ordre");
            System.out.println("6. Annuler ordre");
            System.out.println("7. se mest populære produkt");
            System.out.println("8. Se total omsætning");
            System.out.println("9. Ændre pris på produkt");
            System.out.println("10. afslut program");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manager.displayMenu();
                    break;
                case 2:
                    manager.viewOrderHistory();
                    break;
                case 3:
                    placeOrder();
                    break;
                case 4:
                    System.out.println("Input id for ordre du gerne vil se");
                    int id = scanner.nextInt();
                    manager.showOrderDetails(id);
                    // vis ordre detaljer
                    break;
                case 5:
//                    System.out.println("Total Turnover: $" + manager.getTotalTurnover());
//                    break;
                    //færdiggør ordre
                    manager.setOrderStatus();
                    break;
                case 6:
//                    System.out.println("Exiting...");
//                    return;
                    //annuler ordre
                    break;
                case 7:
                    // se mest populære produkt
                    manager.showMostPopularItem();
                    break;
                case 8:
                    System.out.println("Total omsætning: " + manager.getTotalTurnover());
                    break;
                case 9:
                    changeItemPrice();
                    break;
                case 10:
                    System.out.println("afslutter program");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void placeOrder() {
        ArrayList<OrderLine> orderLines = new ArrayList<>();

        while (true) {
            System.out.println("Indtast product nummer (0 for at afslutte): ");
            int productNumber = scanner.nextInt();
            if (productNumber == 0) {
                break;
            }
            double price = manager.getProductPrice(productNumber);
            String itemName = manager.getName(productNumber);
            Product product = new Product(productNumber, price, itemName , "");

            OrderLine orderline = new OrderLine(product);
            orderLines.add(orderline);
            System.out.println("Ordren har nu: " + product);
        }
        manager.placeOrder(orderLines);


    }
//    private void placeOrder() {
//        ArrayList<OrderLine> orderLines = new ArrayList<>();
//        while (true) {
//            System.out.print("Enter item name to order (or 'done' to finish): ");
//            String itemName = scanner.nextLine();
//            if (itemName.equalsIgnoreCase("done")) {
//                break;
//            }
//            double price = manager.getProductPrice(itemName);
//            if (price > 0) {
//                System.out.print("Enter quantity: ");
//                int quantity = scanner.nextInt();
//                scanner.nextLine(); // Consume newline
//                Product product = new Product(0, price, itemName, "");  // Product details for the order
//                OrderLine orderLine = new OrderLine(product, quantity);
//                orderLines.add(orderLine);
//            } else {
//                System.out.println("Item not found in the menu.");
//            }
//        }
//        manager.placeOrder(orderLines);
//    }


    private void changeItemPrice() {
        System.out.println("Indtast produkt nummer du gerne vil ændre: ");
        int productNumber = scanner.nextInt();
        System.out.println("indtast den nye pris");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        manager.changeItemPrice(productNumber, newPrice);
    }
//    private void changeItemPrice() {
//        System.out.print("Enter item name to change price: ");
//        String itemName = scanner.nextLine();
//        System.out.print("Enter new price: ");
//        double newPrice = scanner.nextDouble();
//        scanner.nextLine(); // Consume newline
//        manager.changeItemPrice(itemName, newPrice);
//    }
}
