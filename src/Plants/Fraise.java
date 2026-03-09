package Plants;

public class Fraise extends Plant {
    public Fraise() {
        this.name = "Fraise";
        this.folderName = "fraise";
        this.buyMoney = 50;
        this.sellMoney = 100;
        this.duration = 60;

    }

    public void growthDuration() {

    }

    public String getFolderName() {
        return folderName;
    }
}