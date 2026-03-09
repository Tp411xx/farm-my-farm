package Inventory;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import java.util.HashMap;

public class Inventory {

    private VBox inventoryBox;
    private HashMap<String, InventoryItem> items = new HashMap<>();

    public Inventory(VBox inventoryBox) {
        this.inventoryBox = inventoryBox;
    }

    public void addItem(String name, Image image, int quantity) {

        if (items.containsKey(name)) {

            InventoryItem item = items.get(name);
            item.addQuantity(quantity);

        } else {

            InventoryItem item = new InventoryItem(name, image, quantity);
            items.put(name, item);

            inventoryBox.getChildren().add(item.getView());
        }
    }
}