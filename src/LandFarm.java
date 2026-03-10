import Inventory.Inventory;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LandFarm {
    @FXML
    private Button land;
    @FXML
    private GridPane gridPane;
    @FXML
    private VBox inventoryBox;
    @FXML
    private VBox inventoryBoxgraine;
    @FXML
    private VBox marcketbuyBox;
    @FXML
    private VBox marcketsellBox;
    @FXML
    private ComboBox<String> seedSelector;

    Inventory inventory;




    public void initialize() {
        int rows = 20;
        int columns = 20;

        seedSelector.getItems().addAll("Mais", "Patate","Aubergine","Fraise","Ble");
        seedSelector.setValue("Mais");


        inventory = new Inventory(inventoryBoxgraine);
        inventory = new Inventory(marcketbuyBox);
        inventory = new Inventory(marcketsellBox);
        inventory = new Inventory(inventoryBox);




        // Land[][] lands = new Land[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Land land = new Land(inventory, seedSelector);

                gridPane.setHalignment(land.getButton(), javafx.geometry.HPos.CENTER);
                gridPane.setValignment(land.getButton(), javafx.geometry.VPos.CENTER);
                gridPane.setAlignment(Pos.CENTER);

                gridPane.add(land.getButton(), col, row);
            }
        }
    }

    public String getSelectedSeed() {
        return seedSelector.getValue();
    }
}
