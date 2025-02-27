package main.java.models;
import java.util.*;

public class Order {
    private static int orderCounter = 1;
    private int orderId;
    private List<Product> products;
    private double totalAmount;

    public Order(List<Product> products) {
        this.orderId = orderCounter++;
        this.products = new ArrayList<>(products);
        this.totalAmount = products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        products.forEach(System.out::println);
        System.out.println("Toplam: " + totalAmount + "tl");
    }
    public static class Cart {
        private List<Product> products = new ArrayList<>();

        public void addProduct(Product product) {
            products.add(product);
        }

        public List<Product> getProducts() { return products; }

        public double getTotalPrice() {
            return products.stream().mapToDouble(Product::getPrice).sum();
        }
    }
    public static class OrderService {
        private List<Order> orders = new ArrayList<>();

        public void createOrder(Cart cart) {
            Order order = new Order(cart.getProducts());
            orders.add(order);
            order.displayOrder();
        }
    }

}
