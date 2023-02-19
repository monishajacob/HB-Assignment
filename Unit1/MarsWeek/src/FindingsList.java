import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class  FindingsList {

    public FindingsList() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Thread.sleep(500);
        
        System.out.println("\n\nWelcome back brave explorers!");
        ArrayList<String> rocks = new ArrayList<String>();

        rocks.add("rock");
        rocks.add("weird rock");
        rocks.add("smooth rock");
        rocks.add("not rock");
        System.out.println("Rocks completely downloaded.");
        System.out.println(rocks);
        System.out.println("Hold on, " + rocks.get(3) + " incorrect hence deleting.");
        rocks.remove("not rock");
        System.out.println(rocks);
        System.out.println("Perfect");

        Thread.sleep(1000);
        HashMap<String, String> fossils = new HashMap<>();
        fossils.put("Bird Fossil", "The fossil has wings implying it was capable of flight");
        fossils.put("Fish Fossil", "The fossil is vaguely fish shaped implies there was once water");
        fossils.put("Tooth Fossil", "The tooth from an unknown fossil");
        System.out.println("Fossil data downloaded");
        System.out.println("Which of the fossils would you like to learn more about(Bird Fossil, Fish Fossil, or Tooth Fossil)?");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("Bird Fossil")) {
            System.out.println("Fossil: " + choice + "\nDescription: " + fossils.get(choice));
        } else if (choice.equalsIgnoreCase("Fish Fossil")) {
            System.out.println("Fossil: " + choice + "\nDescription: " + fossils.get(choice));
        } else if (choice.equalsIgnoreCase("Tooth Fossil")) {
            System.out.println("Fossil: " + choice + "\nDescription: " + fossils.get(choice));
        }

        Thread.sleep(700);
        HashSet<String> supplies = new HashSet<>();
        supplies.add("Food");
        supplies.add("Defence");
        supplies.add("Protective gear");
        System.out.println("\nSupplies Before Expedition ");
        Iterator itr = supplies.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("\nSupplies After Expedition ");
        supplies.remove("Defence");
        Iterator i = supplies.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }
    
}
