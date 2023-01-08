
//   Part 1.2   shorturl.at/AHK14

public class Rocket implements SpaceShip {

    int cost;
    int weight;
    int maxWeight;
    int cargoLimit;
    int totalWeight;
    double launchExplosion;
    double landingCrash;



    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }
    public void carry(Item item) {
        this.totalWeight += item.weight;
    }
    public boolean canCarry(Item item) {
        return this.totalWeight + item.weight > maxWeight;
    }

}

