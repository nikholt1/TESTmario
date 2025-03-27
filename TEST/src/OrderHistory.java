import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.ArrayList;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double getTotalTurnover() {
        double total = 0;
        for (Order order : orders) {
            if (order.getOrderStatus() == OrderStatus.COMPLETED) {
                total += order.getTotal();
            }
        }
        return total;
    }

    public void showMostPopularItem() {

    }


    public void showOrderDetails(int id) {

        for (Order order : orders) {
            if (order.getId() == id) {
                System.out.println(order);
                break;
            }
        }
    }

    public void setOrderStatus(int id) {
        for (Order order : orders) {
            if (id == order.getId()) {
                order.setOrderstatus(OrderStatus.COMPLETED);
            }
        }
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
