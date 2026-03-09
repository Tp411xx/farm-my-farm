package Plants;

public class Patate extends Plant {
    public Patate() {
        this.name = "Patate";
        this.folderName = "patate";
        this.buyMoney = 50;
        this.sellMoney = 100;
        this.duration = 10;

    }

    public void growthDuration() {

    }

    public String getFolderName() {
        return folderName;
    }
}