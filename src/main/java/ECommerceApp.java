package main.java;
import main.java.models.User;
import main.java.models.Order;
import main.java.models.Product;
import main.java.models.utils.Cart;


    public class ECommerceApp {
        public static void main(String[] args) {
            User.AuthenticationService auth = new User.AuthenticationService();
            auth.register("user1", "pass123");

            if (auth.login("user1", "pass123")) {
                System.out.println("Giriş başarılı");
            } else {
                System.out.println("Hatalı giriş");
                return;
            }

            // Ürün oluşturma
            Product p1 = new Product(1, "Laptop", 1000);
            Product p2 = new Product(2, "Phone", 500);

            // Sepete ürün ekleme
            Order.Cart cart = new Order.Cart();
            cart.addProduct(p1);
            cart.addProduct(p2);

            // Sipariş oluşturma
            Order.OrderService orderService = new Order.OrderService();
            orderService.createOrder(cart);
        }
    }
