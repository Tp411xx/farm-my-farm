import Inventory.Inventory;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import Plants.Plant;
import Plants.Mais;
import Plants.Patate;
import Plants.Fraise;
import Plants.Aubergine;
import Plants.Ble;

public class Land {

    public Button button;
    public Plant plant;
    public String typePlant;
    private ImageView dirtView;
    private ImageView plantView;
    private StackPane stack;
    private Inventory inventory;
    private ComboBox<String> seedSelector;
    private String plantFolder;
    private String plantName;


    public int state = 0;
    public int time = 10;


    private Timeline timer;

    public Land(Inventory inventory, ComboBox<String> seedSelector) {

        this.inventory = inventory;
        this.seedSelector = seedSelector;

        Image dirt = new Image(getClass().getResourceAsStream("/IMG/Dirt.png"));
        dirtView = new ImageView(dirt);

        dirtView.setFitWidth(20);
        dirtView.setFitHeight(20);

        plantView = new ImageView();
        plantView.setFitWidth(20);
        plantView.setFitHeight(20);
        plantView.setPreserveRatio(true);

        stack = new StackPane();
        stack.getChildren().addAll(dirtView, plantView);

        button = new Button();
        button.setGraphic(stack);

        this.typePlant = typePlant;
        this.inventory = inventory;

        addPlant();
    }

    public void addPlant() {

        button.setOnAction(e -> {

            if (state == 0) {

                typePlant = seedSelector.getValue();

                if (typePlant.equals("Patate")) {
                    this.plant = new Patate();
                }

                if (typePlant.equals("Mais")) {
                    this.plant = new Mais();
                }
                if (typePlant.equals("Aubergine")) {
                    this.plant = new Aubergine();
                }

                if (typePlant.equals("Fraise")) {
                    this.plant = new Fraise();
                }
                if (typePlant.equals("Ble")) {
                    this.plant = new Ble();
                }

                plantSeed();
                state = 1;
            }

            else if (state == 3) {

                harvest();
                state = 0;
                time = plant.duration;
            }

            System.out.println(typePlant);
        });
    }

    private void plantSeed() {

        Image plantImg = new Image(
                getClass().getResourceAsStream("/IMG/" + plant.folderName + "/graines.png")
        );
        plantFolder = plant.folderName;
        plantName = plant.name;
        time = plant.duration;

        plantView.setImage(plantImg);

        startTimer();
    }

    private void startTimer() {

        timer = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {

                    time--;

                    if (time <= plant.duration * 0.75 && time > plant.duration * 0.50) {
                        plantView.setImage(new Image(getClass().getResourceAsStream("/IMG/" + plantFolder + "/pousse1.png")));
                    }

                    else if (time <= plant.duration * 0.50 && time > plant.duration * 0.25) {
                        plantView.setImage(new Image(getClass().getResourceAsStream("/IMG/" + plantFolder + "/pousse2.png")));
                    }

                    else if (time <= plant.duration * 0.25 && time > 0) {
                        plantView.setImage(new Image(getClass().getResourceAsStream("/IMG/" + plantFolder + "/pousse3.png")));
                    }

                    else if (time <= 0) {
                        plantView.setImage(new Image(getClass().getResourceAsStream("/IMG/" + plantFolder + "/fini.png")));
                        state = 3;
                        timer.stop();
                    }

                })
        );

        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void harvest() {

        if (timer != null) {
            timer.stop();
        }

        Image image = new Image(
                getClass().getResourceAsStream("/IMG/" + plantFolder + "/inventaire.png")
        );

        inventory.addItem(plantName, image, 1);

        plantView.setImage(null);
    }

    public Button getButton() {
        return button;
    }
}