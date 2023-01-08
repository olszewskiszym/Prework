
// Part 1.3  shorturl.at/AHK14
// ROCKET U1
//Rocket cost = $100 Million
//Rocket weight = 10 Tonnes
//Max weight (with cargo) = 18 Tonnes
//Chance of launch explosion = 5% * (cargo carried / cargo limit)
//Chance of landing crash = 1% * (cargo carried / cargo limit)

public class U1 extends Rocket {

    public U1() {

        cost = 100;
        weight = 10000;
        maxWeight = 18000;
        cargoLimit = 8000;
        launchExplosion = 0.0;
        landingCrash = 0.0;
        totalWeight = weight;
    }
        public boolean land () {

            int random = (int) (Math.random() * 100 + 1);
            this.landingCrash = 1.0 * (this.totalWeight - this.weight) / (this.cargoLimit);
            return this.landingCrash <= random;
        }

        public boolean launch () {

            int random = (int) (Math.random() * 100 + 1);
            this.launchExplosion = 5.0 * (this.totalWeight - this.weight) / (this.cargoLimit);
            return this.launchExplosion <= random;
        }
}