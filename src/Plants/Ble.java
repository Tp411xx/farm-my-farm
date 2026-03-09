package Plants;

public class Ble extends Plant {
    public Ble() {
        this.name = "Blé";
        this.folderName = "blé";
        this.buyMoney = 100;
        this.sellMoney = 300;
        this.duration = 45;
    }

    public void growthDuration() {

    }

    public String getFolderName() {
        return folderName;
    }
}