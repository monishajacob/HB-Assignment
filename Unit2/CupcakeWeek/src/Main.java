import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println(
                "\nWe are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing");

        Scanner input = new Scanner(System.in);
        System.out.println("\nWe are deciding on the price for our standard cupcake. Here is the description: ");
        cupcake.type();
        System.out.println(
                "How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places): ");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        System.out.println("\nWe are deciding on the price for our standard cupcake. Here is the description: ");
        redVelvet.type();
        System.out.println(
                "How much would you like to charge for the Red Velvet cupcake? (Input a numerical number taken to 2 decimal places): ");
        String priceRedVelvetText = input.nextLine();
        double priceRedVelvet = Double.parseDouble(priceRedVelvetText);
        redVelvet.setPrice(priceRedVelvet);

        System.out.println("\nWe are deciding on the price for our standard cupcake. Here is the description: ");
        chocolate.type();
        System.out.println(
                "How much would you like to charge for the Chocolate cupcake? (Input a numerical number taken to 2 decimal places): ");
        String priceTextChocolate = input.nextLine();
        double priceChocolate = Double.parseDouble(priceTextChocolate);
        chocolate.setPrice(priceChocolate);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();
        System.out.println(
                "\nWe are in the middle of creating the drink menu. We currently have three types of drinks on" +
                        "\nthe menu but we need to decide on pricing");
        System.out.println("\nWe are deciding on the price for our bottled water. Here is the description: ");
        water.type();
        System.out.println("How much would you like to charge for the water bottle?" +
                "\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        water.setPrice(price);
        System.out.println("\nWe are deciding on the price for our bottle of soda. Here is the description: ");
        soda.type();
        System.out.println("How much would you like to charge for the bottled soda?" +
                "\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);
        System.out.println("\nWe are deciding on the price for our bottle of milk. Here is the description: ");
        milk.type();
        System.out.println("How much would you like to charge for the bottled milk?" +
                "\n(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu, drinkMenu);

    }
}

class Cupcake {

    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }
}

class RedVelvet extends Cupcake {

    @Override
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake {

    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}

class Drink {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void type() {
        System.out.println("A bottle of water.");
    }
}

class Soda extends Drink {
    public void type() {
        System.out.println("A bottle of soda.");
    }
}

class Milk extends Drink {
    public void type() {
        System.out.println("A bottle of milk.");
    }
}