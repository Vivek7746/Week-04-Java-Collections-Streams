package shopping_cart;

import java.util.*;

// Class representing a Shopping Cart
class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>(); // Store product prices
    private Map<String, Double> orderedItems = new LinkedHashMap<>(); // Maintain order of items added
    private TreeMap<Double, String> sortedItems = new TreeMap<>(); // Store items sorted by price

    // Add a product to the cart
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        orderedItems.put(product, price);
        sortedItems.put(price, product);
    }

    // Display cart items in order they were added
    public void displayOrderedItems() {
        System.out.println("Cart Items (Order of Addition): " + orderedItems);
    }

    // Display cart items sorted by price
    public void displaySortedItems() {
        System.out.println("Cart Items (Sorted by Price): " + sortedItems);
    }

    // Display all products and their prices
    public void displayProductPrices() {
        System.out.println("Product Prices: " + productPrices);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding sample products
        cart.addProduct("Laptop", 999.99);
        cart.addProduct("Headphones", 199.99);
        cart.addProduct("Mouse", 49.99);
        cart.addProduct("Keyboard", 89.99);

        // Display cart details
        cart.displayProductPrices();
        cart.displayOrderedItems();
        cart.displaySortedItems();
    }
}