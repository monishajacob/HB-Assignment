import java.util.Scanner;

public class MarsExpedition {

    public MarsExpedition() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nExpedition prep program starting...");
        System.out.println("System Booting up...");
        System.out.println("3...");
        System.out.println("2...");
        System.out.println("1...");
        System.out.println("Get Ready");

        System.out.println("Hello user, What is your name?");

        String name = input.nextLine();

        System.out.println("Hi, " + name + " - Welcome to the Expedition prep program.\n" +
                "Are you ready to head out into the new world?\n" +
                "Type Y or N");

        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("I knew you would say that. You are team leader for a reason.");
        } else {
            System.out.println("To bad you are team leader. You have to go.");
        }


        System.out.println("How many people do you want on your expedition team? (Input an int number)");

        int teamSize = input.nextInt();
        input.nextLine();

        if (teamSize > 2) {
            System.out.println("That's way to many people. We can only send 2 more members");
            teamSize = 2;
        } else if (teamSize < 2) {
            System.out.println("That's not enough people. We need you and 2 more members.");
            teamSize = 2;
        } else if (teamSize == 2) {
            System.out.println("That's a perfect sized team. Good job.");
        }

        System.out.println("You are allowed to bring one snack with you. What do you bring?");
        String snack = input.nextLine();
        System.out.println("Nice choice, you will be bringing a " + snack + " with you.");

        System.out.println("You have the choice of 3 vehicles" +
        "\n\tA: A Tesla" +
        "\n\tB: A Chandrayan" +
        "\n\tC: A Space Car");

        String vehicleChoice = input.nextLine();

        if (vehicleChoice.equalsIgnoreCase("A")) {
            vehicleChoice = "a Tesla";
        } else if (vehicleChoice.equalsIgnoreCase("B")) {
            vehicleChoice = "a Chandrayan";
        } else if (vehicleChoice.equalsIgnoreCase("C")) {
            vehicleChoice = "a Space Car";
        } else {
            vehicleChoice = "Mario Cart";
        }

        System.out.println("Let's begin the expedition! " +
                "\nYour team is led by " + name + " having " + teamSize + " teammates." +
                "\nYou would be exploring Mars with " + vehicleChoice + "." + " What a cool Choice! "+
                "\nTeam will exit in" +
                "\n3...." +
                "\n2...." +
                "\n1...." +
                "\nGET READY, GOOOOO!");
    }
    }
    

