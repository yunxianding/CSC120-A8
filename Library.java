/* This is a stub for the Library class */

import java.util.Hashtable;
/**
 * The Library class is a special type of building.
 * It has a collection of books that students can check out and return.
 */
public class Library extends Building implements LibraryRequirements{

    //New attributes
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    /**
    * Constructor for the Library class.
    * @param name The name of the library.
    * @param address The address of the library.
    * @param nFloors The number of floors in the library.
    * @param hasElevator Whether the library has an elevator.
    */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        this.hasElevator = hasElevator;
        System.out.println("You have built a library: 📖");
    }

    /* Overloaded constructor (defaults to no elevator) */
    public Library(String name, String address, int nFloors) {
        this(name, address, nFloors, false);
    }

    /**
    * Overrides the showOptions method to include Library-specific options.
    */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(String title) \n + removeTitle(String title) \n + checkOut(String title) \n + returnBook(String title) \n + printCollection()");
    }

    /**
    * Overrides the goToFloor method to account for whether the library has an elevator.
    * @param floorNum The floor to go to.
    */
    @Override
        public void goToFloor(int floorNum) {
        if (!this.hasElevator && (floorNum > this.activeFloor + 1 || floorNum < this.activeFloor - 1)) {
        throw new RuntimeException("This library does not have an elevator. You can only move to adjacent floors.");
        }
        super.goToFloor(floorNum);
    }

    /**
    * Adds a title to the library if it does not already exist.
    * @param title The title to add.
    */
    public void addTitle(String title) {
        if (!this.collection.containsKey(title)) {
        this.collection.put(title, true);
        System.out.println(title + " has been added to the library.");
        } else {
        System.out.println(title + " is already in the library.");
        }
    }

    /* Overloaded addTitle method (adds multiple titles at once) */
    public void addTitle(String[] titles) {
        for (String title : titles) {
          this.addTitle(title);
        }
    }

    /**
    * Removes a title from the library if it exists.
    * @param title The title to remove.
    * @return The title that was removed, or null if it was not found.
    */
    public String removeTitle(String title) {
        if (this.collection.containsKey(title)) {
        this.collection.remove(title);
        System.out.println(title + " has been removed from the library.");
        return title;
        } else {
        System.out.println(title + " is not in the library.");
        return null;
        }
    }

    /* Overloaded removeTitle method (removes multiple titles at once) */
    public void removeTitle(String[] titles) {
        for (String title : titles) {
          this.removeTitle(title);
        }
      }

    /**
     * Checks out a book if it is available in the library.
     * @param title The title to check.
     */
    public void checkOut(String title) {
        if (this.collection.containsKey(title)) {
            if(this.collection.get(title)){
                this.collection.replace(title, false);
                System.out.println(title + " is checked out.");
            } else {
                throw new IllegalStateException(title + " is already checked out.");
            }
        } else {
            throw new IllegalArgumentException(title + " is not in the library collection.");
        }
    }


    /**
     * Returns a title to the library if it was checked out.
     * @param title The title to return.
     */
    public void returnBook(String title) {
        if (this.collection.containsKey(title) && !this.collection.get(title)) {
            this.collection.replace(title, true);
            System.out.println(title + " has been returned to the library.");
        } else {
            System.out.println(title + " was unable to be returned.");
        }
    }
    
    /**
     * Checks if a title is in the library collection.
     * @param title The title to check.
     * @return true if the title is in the collection, false otherwise.
     */
    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    /**
     * Checks if a title is available in the library.
     * @param title The title to check.
     * @return true if the title is available, false otherwise.
     */
    public boolean isAvailable(String title) {
        return this.collection.get(title);
    }

    /**
     * Prints out the library collection including the check-out status.
     */
    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : this.collection.keySet()) {
            String status;
            if (this.collection.get(title)) {
                status = "Available";
            } else {
                status = "Checked out";
            }
            System.out.println("- " + title + " (" + status + ")");
        }
    }

    /**
     * Main method to test the Library class.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive", 4, true);
        
        System.out.println(neilsonLibrary);
        neilsonLibrary.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        neilsonLibrary.enter();
        neilsonLibrary.goUp();
        neilsonLibrary.goDown();
        neilsonLibrary.goToFloor(4); //This should work because the library has an elevator
        // neilsonLibrary.exit(); This should throw an exception because we can't exit from the 4th floor
        neilsonLibrary.goToFloor(1);
        neilsonLibrary.exit(); //This should work because we are on the first floor

        // Add books to the library
        neilsonLibrary.addTitle("The Old Man and the Sea by Ernest Hemingway");
        String[] newBooks = {"Animal Farm by George Orwell", "The Design of Everyday Things by Don Norman"};
        neilsonLibrary.addTitle(newBooks);
        neilsonLibrary.printCollection();

        // Remove a book
        neilsonLibrary.removeTitle("The Old Man and the Sea by Ernest Hemingway");
        String[] removeBooks = {"Animal Farm by George Orwell", "The Design of Everyday Things by Don Norman"};
        neilsonLibrary.removeTitle(removeBooks);
        neilsonLibrary.printCollection();

    }
}
  
  
