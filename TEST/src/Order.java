import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private OrderStatus orderStatus;
    private List<OrderLine> orderLines;
    private LocalDateTime pickupTime;
    private static int lastId = 0;
    private int id;
    private int productNumber;

    public Order(int inputTime) {
        this.id = ++lastId;
        this.orderStatus = OrderStatus.Active;
        this.orderLines = new ArrayList<>();
        calculatePickupTime(inputTime);
    }
    public int getId() {
        return id;
    }
    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
    }

    public double getTotal() {
        double total = 0;
        for (OrderLine line : orderLines) {
            total += line.getTotalPrice();
        }
        return total;
    }
    public int getProductNumber() {
        for (OrderLine orderline : orderLines) {
            return orderline.getProductNumber();
        }
        return -1;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderstatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void calculatePickupTime(int inputTime) {
        pickupTime = LocalDateTime.now().plus(inputTime, ChronoUnit.MINUTES).truncatedTo(ChronoUnit.SECONDS);
    }


    public String printCurrentOrder() {
        System.out.println("Ordre : ");
        for (OrderLine orderline : orderLines) {
            System.out.println(orderline);
        }
        return "";
    }

    public String toString() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = pickupTime.format(formatter);
        System.out.println("________________________________________________________________________");
        return printCurrentOrder() + "\n" +
                "Total pris: " + getTotal() + "\n" +
                "Afhentningstid: " + formattedTime + "\n" +
                "Status: " + orderStatus + "\n" +
                "ID: " + id + "\n" +
                "________________________________________________________________________";

    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        for (OrderLine line : orderLines) {
//            sb.append(line.toString()).append("\n");
//        }
//        sb.append("Total: $").append(getTotal());
//        return sb.toString();
//    }
}
