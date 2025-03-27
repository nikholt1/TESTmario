// Class representing an order line (an item in an order)


// Class for managing the application

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UserInterface ui = new UserInterface(manager);
        ui.start();
    }
}
