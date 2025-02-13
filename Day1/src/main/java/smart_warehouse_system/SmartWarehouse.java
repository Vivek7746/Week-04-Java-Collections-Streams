package smart_warehouse_system;

import java.util.*;

// Abstract class representing a warehouse item
abstract class WarehouseItem {
    private String itemName;
    private double price;

    public WarehouseItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + ", Price: ₹" + price;
    }
}

// Electronics class extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String itemName, double price) {
        super(itemName, price);
    }
}

// Groceries class extending WarehouseItem
class Groceries extends WarehouseItem {
    public Groceries(String itemName, double price) {
        super(itemName, price);
    }
}

// Furniture class extending WarehouseItem
class Furniture extends WarehouseItem {
    public Furniture(String itemName, double price) {
        super(itemName, price);
    }
}

// Generic Storage class with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public List<T> getItems() {
        return items;
    }

    // Wildcard method to display all items
    public static void displayItems(List<? extends WarehouseItem> itemList) {
        for (WarehouseItem item : itemList) {
            System.out.println(item);
        }
    }
}

// Main class to test the Smart Warehouse System
public class SmartWarehouse {
    public static void main(String[] args) {
        // Creating storage units
        Storage<Electronics> electronicStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items with Indian-based names
        electronicStorage.addItem(new Electronics("Samsung TV", 45000));
        electronicStorage.addItem(new Electronics("Bose Speaker", 15000));

        groceryStorage.addItem(new Groceries("Basmati Rice", 1200));
        groceryStorage.addItem(new Groceries("Amul Butter", 250));

        furnitureStorage.addItem(new Furniture("Sandalwood Sofa", 75000));
        furnitureStorage.addItem(new Furniture("Teakwood Table", 30000));

        // Displaying all items
        System.out.println("Electronics in Agra Warehouse:");
        Storage.displayItems(electronicStorage.getItems());

        System.out.println("\nGroceries in Varanasi Warehouse:");
        Storage.displayItems(groceryStorage.getItems());

        System.out.println("\nFurniture in Jaipur Warehouse:");
        Storage.displayItems(furnitureStorage.getItems());
    }
}