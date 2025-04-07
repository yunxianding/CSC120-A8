/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    //Attributes
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100; // Initial amount of coffee in ounces
        this.nSugarPackets = 10; // Initial amount of sugar packets
        this.nCreams = 10; // Initial amount of creams
        this.nCups = 50; // Initial number of cups
        System.out.println("You have built a cafe: ☕");
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
     * Restocks the cafe's inventory.
     * @param nCoffeeOunces The amount of coffee to add.
     * @param nSugarPackets The number of sugar packets to add.
     * @param nCreams The number of cream splashes to add.
     * @param nCups The number of cups to add.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Restocked inventory: " + nCoffeeOunces + " coffee ounces, " + nSugarPackets + " sugar packets, " + nCreams + " creams, " + nCups + " cups.");
    }
    /**
     * Main method to test the Cafe class.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        // Create a new Cafe
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Elm St", 1);

        // Sell some coffee
        campusCafe.sellCoffee(12, 2, 3);
        campusCafe.sellCoffee(100, 50, 30); // This should trigger a restock
        campusCafe.sellCoffee(12, 2, 3);
    }
}
