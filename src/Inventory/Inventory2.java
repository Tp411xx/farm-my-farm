package Inventory;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.util.HashMap;

public abstract class Inventory2 {

    protected VBox inventoryBox;
    protected HashMap<String, InventoryItem> items = new HashMap<>();

    public Inventory2(VBox inventoryBox) {
        this.inventoryBox = inventoryBox;
    }

    public void addItem(String name, Image image, int quantity) {

        if (items.containsKey(name)) {

            InventoryItem item = items.get(name);
            item.addQuantity(quantity);

        } else {

            InventoryItem item = createItem(name, image, quantity);

            items.put(name, item);
            inventoryBox.getChildren().add(item.getView());
        }
    }

    // méthode abstraite
    protected abstract InventoryItem createItem(String name, Image image, int quantity);
}