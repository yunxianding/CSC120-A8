/* This is a stub for the Library class */

import java.util.Hashtable;
/**
 * The Library class is a special type of building.
 * It has a collection of books that students can check out and return.
 */
public class Library extends Building implements LibraryRequirements{

  //New attributes
  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for the Library class.
   * @param name The name of the library.
   * @param address The address of the library.
   * @param nFloors The number of floors in the library.
   */
  public Library(String name, String address, int nFloors){
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
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

    /**
     * Checks if a title is available in the library.
     * @param title The title to check.
     */
    public void checkOut(String title) {
        if (this.collection.containsKey(title) && this.collection.get(title)) {
            this.collection.replace(title, false); 
            System.out.println(title + " is checked out.");
        } else {
            System.out.println(title + " is not available for checkout.");
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
      Library myLibrary = new Library("Neilson Library", "7 Neilson Drive", 4);

      // Add books to the library
      myLibrary.addTitle("The Old Man and the Sea by Ernest Hemingway");
      myLibrary.addTitle("Animal Farm by George Orwell");
      myLibrary.addTitle("The Design of Everyday Things by Don Norman");

      // Print the collection
      myLibrary.printCollection();

      // Check out a book
      myLibrary.checkOut("The Design of Everyday Things by Don Norman");
      myLibrary.checkOut("The Design of Everyday Things by Don Norman"); // This should fail because it's already checked out

      // Return a book
      myLibrary.returnBook("The Design of Everyday Things by Don Norman");
      myLibrary.returnBook("Animal Farm by George Orwell"); // This should fail because it's not checked out

      // Remove a book
      myLibrary.removeTitle("The Old Man and the Sea by Ernest Hemingway");

      // Print the collection again
      myLibrary.printCollection();
  }
}
  
  
