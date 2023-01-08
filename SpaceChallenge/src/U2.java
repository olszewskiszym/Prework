
// Part 1.3  shorturl.at/AHK14
//ROCKET U2
//Rocket cost = $120 Million
//Rocket weight = 18 Tonnes
//Max weight (with cargo) = 29 Tonnes
//Chance of launch explosion = 4% * (cargo carried / cargo limit)
//Chance of landing crash = 8% * (cargo carried / cargo limit)

public class U2 extends Rocket {

    public U2(){
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
        cargoLimit = 11000;
        launchExplosion = 0.0;
        landingCrash = 0.0;
        totalWeight = weight;
    }

    public boolean land() {
        int random = (int)(Math.random() * 100 + 1);
        this.landingCrash = 8.0 * (this.totalWeight - this.weight) / (this.cargoLimit);
        return this.landingCrash <= random;
    }


    public boolean launch() {
        int random = (int)(Math.random() * 100 + 1);
        this.launchExplosion = 4.0 * (this.totalWeight - this.weight) / (this.cargoLimit);
        return this.launchExplosion <= random;
    }


}
