package dynamic_online_marketplace;

import java.util.*;

// Abstract class representing a generic product
abstract class Product<T> {
    private String productName;
    private double price;
    private T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void applyDiscount(double percentage) {
        this.price -= (this.price * percentage / 100);
    }

    @Override
    public String toString() {
        return "Product: " + productName + ", Price: ₹" + price + ", Category: " + category;
    }
}

// Book category
enum BookCategory {
    FICTION, NON_FICTION, ACADEMIC;
}

// Clothing category
enum ClothingCategory {
    TRADITIONAL, WESTERN, SPORTS;
}

// Gadget category
enum GadgetCategory {
    SMARTPHONE, LAPTOP, ACCESSORY;
}

// Specific product classes
class Book extends Product<BookCategory> {
    public Book(String productName, double price, BookCategory category) {
        super(productName, price, category);
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String productName, double price, ClothingCategory category) {
        super(productName, price, category);
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String productName, double price, GadgetCategory category) {
        super(productName, price, category);
    }
}

// Generic catalog class
class ProductCatalog<T extends Product<?>> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void removeProduct(T product) {
        products.remove(product);
    }

    public List<T> getProducts() {
        return products;
    }

    // Generic method to apply discount
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }

    public static void displayProducts(List<? extends Product<?>> productList) {
        for (Product<?> product : productList) {
            System.out.println(product);
        }
    }
}

// Main class to test the Dynamic Online Marketplace
public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        // Adding products
        bookCatalog.addProduct(new Book("Mahabharata", 1200, BookCategory.ACADEMIC));
        bookCatalog.addProduct(new Book("Wings of Fire", 500, BookCategory.NON_FICTION));

        clothingCatalog.addProduct(new Clothing("Kurta", 1500, ClothingCategory.TRADITIONAL));
        clothingCatalog.addProduct(new Clothing("Denim Jacket", 3000, ClothingCategory.WESTERN));

        gadgetCatalog.addProduct(new Gadget("OnePlus Phone", 35000, GadgetCategory.SMARTPHONE));
        gadgetCatalog.addProduct(new Gadget("MacBook", 120000, GadgetCategory.LAPTOP));

        // Applying discounts
        ProductCatalog.applyDiscount(bookCatalog.getProducts().get(0), 10);
        ProductCatalog.applyDiscount(gadgetCatalog.getProducts().get(1), 5);

        // Displaying products
        System.out.println("Books Available:");
        ProductCatalog.displayProducts(bookCatalog.getProducts());

        System.out.println("\nClothing Available:");
        ProductCatalog.displayProducts(clothingCatalog.getProducts());

        System.out.println("\nGadgets Available:");
        ProductCatalog.displayProducts(gadgetCatalog.getProducts());
    }
}