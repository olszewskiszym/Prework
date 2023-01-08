
//  Part 3   shorturl.at/AHK14

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // 1.Create a Simulation object.

        Simulation sim = new Simulation();

        // 2.Load Items for Phase-1 and Phase-2

        ArrayList<Item> phase1 = sim.loadItems("Phase-1.txt");
        ArrayList<Item> phase2 = sim.loadItems("Phase-2.txt");

        // 3.Load a fleet of U1 rockets for Phase-1 and then for Phase-2

        ArrayList<Rocket> U1FleetPhase1 = sim.loadU1(phase1);
        ArrayList<Rocket> U1FleetPhase2 = sim.loadU1(phase2);
        ArrayList<Rocket> U2FleetPhase1 = sim.loadU2(phase1);
        ArrayList<Rocket> U2FleetPhase2 = sim.loadU2(phase2);

        // 4.Run the simulation using the fleet of U1 rockets and display the total budget required

        System.out.println("U1 fleet Phase 1: ");
        int budgetU1phase1 = sim.runSimulation(U1FleetPhase1);

        System.out.println("U1 fleet Phase 2: ");
        int budgetU1phase2 = sim.runSimulation(U1FleetPhase2);

        System.out.println("Total budget of U1 fleet = " + (budgetU1phase1 + budgetU1phase2) + "mln $");
        System.out.println();

        // 5.Run the simulation using the fleet of U2 rockets and display the total budget required

        System.out.println("U2 fleet Phase 1: ");

        int budgetU2phase1 = sim.runSimulation(U2FleetPhase1);

        System.out.println("U2 fleet Phase 1: ");
        int budgetU2phase2 = sim.runSimulation(U2FleetPhase2);

        System.out.println("Total budget of U2 fleet = " + (budgetU2phase1 + budgetU2phase2) + "mln $");
    }
}


