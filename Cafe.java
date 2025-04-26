/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    // Attributes
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor for the Cafe class.
     * @param name The name of the cafe.
     * @param address The address of the cafe.
     * @param nFloors The number of floors in the cafe.
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100; // Initial amount of coffee in ounces
        this.nSugarPackets = 10; // Initial amount of sugar packets
        this.nCreams = 10; // Initial amount of creams
        this.nCups = 50; // Initial number of cups
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded constructor for the Cafe class with default floors.
     * @param name The name of the cafe.
     * @param address The address of the cafe.
     */
    public Cafe(String name, String address) {
        this(name, address, 1); // Default to 1 floor
    }

    /** Overrides goUp method because cafe doesn't support goUp */
    @Override
    public void goUp() {
        throw new UnsupportedOperationException("Cafes only have one floor. You cannot go up.");

    }

    /** Overrides goDown method because cafe doesn't support goDown  */
    @Override
    public void goDown() {
        throw new UnsupportedOperationException("Cafes only have one floor. You cannot go down.");
    }

    /** Overrides goToFloor method so that the cutomer cannot go to another floor */
    @Override
    public void goToFloor(int floorNum) {
        if (floorNum != 1) {
            throw new UnsupportedOperationException("Cafes only have one floor. You cannot go to another floor.");
        } else {
            System.out.println("You are already on the ground floor of the cafe!");
        }
    }

    /**
     * Sells a cup of coffee and decreases inventory accordingly.
     * @param size The size of the coffee in ounces.
     * @param nSugarPackets The number of sugar packets requested.
     * @param nCreams The number of cream splashes requested.
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            System.out.println("Not enough inventory to sell coffee. Restocking...");
            restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Sold a coffee of size " + size + " ounces with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
    }

    /**
     * Overloaded sellCoffee method for default coffee size and ingredients.
     */
    public void sellCoffee() {
        sellCoffee(12, 1, 1); // Default to 12 ounces, 1 sugar packet, 1 cream
    }

    /**
     * Restocks the cafe's inventory.
     * @param nCoffeeOunces The amount of coffee to add.
     * @param nSugarPackets The number of sugar packets to add.
     * @param nCreams The number of cream splashes to add.
     * @param nCups The number of cups to add.
     */
    public void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked inventory: " + nCoffeeOunces + " coffee ounces, " + nSugarPackets + " sugar packets, " + nCreams + " creams, " + nCups + " cups.");
    }

    /**
     * Overloaded restock method for default restock.
     */
    public void restock() {
        restock(50, 50, 50, 50);
    }

    /**
     * Overrides the showOptions method (deleted goUp/goDown/goToFloor, added Cafe specific options).
     */
    @Override
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit()");
        System.out.println(" + sellCoffee(size, nSugarPackets, nCreams)");
        System.out.println(" + sellCoffee()");
        System.out.println(" + restock(nCoffeeOunces, nSugarPackets, nCreams, nCups)");
    }

    /**
     * Main method to test the Cafe class.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Elm St");
        System.out.println(campusCafe);
        campusCafe.showOptions();
        campusCafe.sellCoffee(12, 2, 3);
        campusCafe.sellCoffee(100, 50, 30); // This should trigger a restock
        campusCafe.sellCoffee();
        campusCafe.restock();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        campusCafe.enter();
        // campusCafe.goUp(); // This should throw an exception since the cafe has only one floor
        // campusCafe.goDown(); // This should throw an exception since the cafe has only one floor
        // campusCafe.goToFloor(2); // This should throw an exception since the cafe has only one floor
        campusCafe.exit();
    }
}

