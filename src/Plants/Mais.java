package Plants;

public class Mais extends Plant {
    public Mais() {
        this.name = "Mais";
        this.folderName = "mais";
        this.buyMoney = 100;
        this.sellMoney = 300;
        this.duration = 30;
    }

    public void growthDuration() {

    }

    public String getFolderName() {
        return folderName;
    }
}