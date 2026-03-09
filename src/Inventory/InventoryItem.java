package Inventory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class InventoryItem {

    private HBox view;
    private int quantity;
    private Label quantityLabel;
    private String name;

    public InventoryItem(String name, Image image, int quantity) {

        this.name = name;
        this.quantity = quantity;

        ImageView icon = new ImageView(image);
        icon.setFitWidth(32);
        icon.setFitHeight(32);

        Label nameLabel = new Label(name);
        quantityLabel = new Label("x " + quantity);

        view = new HBox(10);
        view.getChildren().addAll(icon, nameLabel, quantityLabel);
    }

    public void addQuantity(int amount) {
        quantity += amount;
        quantityLabel.setText("x " + quantity);
    }

    public String getName() {
        return name;
    }

    public HBox getView() {
        return view;
    }
}