package Plants;

public class Aubergine extends Plant {
    public Aubergine() {
        this.name = "Aubergine";
        this.folderName = "aubergine";
        this.buyMoney = 100;
        this.sellMoney = 300;
        this.duration = 100;
    }

    public void growthDuration() {

    }

    public String getFolderName() {
        return folderName;
    }
}