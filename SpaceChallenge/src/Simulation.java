
// Part 2  shorturl.at/AHK14

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //This method loads all items from a text file and returns an ArrayList of Items.

    ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        ArrayList<Item> items = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] oneItem = line.split("=");
            items.add(new Item(oneItem[0], Integer.parseInt(oneItem[1])));
        }
        return items;
    }

    //This method takes the ArrayList of Items returned from loadItems and starts
    // creating U1 rockets.It first tries to fill up 1 rocket with as many items as
    // possible before creating a new rocket object and filling that one until all items are loaded.
    // The method then returns the ArrayList of those U1 rockets that are fully loaded.

    ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket r = new U1();

        for (Item i : list) {
            while (r.canCarry(i)) {
                fleet.add(r);
                r = new U1();
            }
            r.carry(i);
        }
        fleet.add(r);
        return fleet;
    }


    //This method takes the ArrayList of Items and starts
    //creating U2 rockets and filling them with those items
    //until all items are loaded. The method then returns the
    // ArrayList of those U2 rockets that are fully loaded.

    ArrayList<Rocket> loadU2(ArrayList<Item> list) {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket r = new U2();

        for (Item i : list) {

            while (r.canCarry(i)) {

                fleet.add(r);
                r = new U2();
            }
            r.carry(i);
        }
        fleet.add(r);
        return fleet;
    }

     //This method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the
     //ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false),
     // it will have to sendthat rocket again. All while keeping track of the total budget required
     // to send each rocket safely to Mars.
     //runSimulation then returns the total budget required to send all rockets (including the crashed ones).

    int runSimulation(ArrayList<Rocket> list) {
        int crash = 0;            // failed trials counter
        for (Rocket r : list) {

            while (!r.launch()) {
                r.launch();
                crash++;

            }

            while (!r.land()) {
                r.land();
                crash++;
            }
        }
        int budget = list.get(0).cost * (list.size() + crash);
        System.out.println(list.size() + " rockets and " + crash + " crashes"
                );
        return budget;
    }
}


