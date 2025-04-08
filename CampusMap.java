import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " from the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        // Adding various buildings to the map
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        House lawrenceHouse = new House("Lawrence House", "99 Green Street Northampton, MA 01063", 4, false);
        myMap.addBuilding(lawrenceHouse);
        myMap.addBuilding(new House("Tyler House", "123 Green Street Northampton, MA 01063", 4, true));
        myMap.addBuilding(new House("Morris House", "101 Green Street Northampton, MA 01063", 4, false));
        Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true);
        myMap.addBuilding(neilsonLibrary);
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm Street Northampton, MA 01063", 2, false));
        myMap.addBuilding(new Library("Josten Library", "122 Green Street Northampton, MA 01063", 2, true));
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Elm St");
        myMap.addBuilding(campusCafe);
        myMap.addBuilding(new Cafe("Campus Center Cafe", "10 Elm Street Northampton, MA 01063"));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("McConnell Hall", "15 Green Street Northampton, MA 01063", 4));

        // Display the campus map
        System.out.println(myMap);
        
        System.out.println("-----------------------------------");
        System.out.println("Demonstrating overloaded methods");
        System.out.println("-----------------------------------");

        // Demonstrating overloaded methods for House
        System.out.println("House Overloaded Methods:");
        lawrenceHouse.moveIn("Yunxian"); // Overloaded moveIn with a name
        lawrenceHouse.moveOut("Yunxian"); // Overloaded moveOut with a name

        // Demonstrating overloaded methods for Library
        System.out.println("\nLibrary Overloaded Methods:");
        String[] books = {"The Old Man and the Sea", "Animal Farm", "The Design of Everyday Things"};
        neilsonLibrary.addTitle(books); // Add multiple titles
        neilsonLibrary.printCollection();
        neilsonLibrary.removeTitle(books); // Remove multiple titles
        neilsonLibrary.printCollection();

        // Demonstrating overloaded methods for Cafe
        System.out.println("\nCafe Overloaded Methods:");
        campusCafe.sellCoffee(); // Default coffee order

    }
}
