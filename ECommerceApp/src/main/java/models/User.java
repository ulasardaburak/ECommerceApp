package main.java.models;
import java.util.*;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() { return username; }
    public boolean checkPassword(String password) { return this.password.equals(password); }

    public static class AuthenticationService {
        private List<User> users = new ArrayList<>();

        public void register(String username, String password) {
            users.add(new User(username, password));
        }

        public boolean login(String username, String password) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.checkPassword(password)) {
                    return true;
                }
            }
            return false;
        }
    }
    }

