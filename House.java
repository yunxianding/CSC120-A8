/* This is a stub for the House class */

import java.util.ArrayList;

/**
 * The House class is a special type of building.
 * Students can live, work and eat(if there is a dining room) in a house.
 */

public class House extends Building implements HouseRequirements {
  
  //New Attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * Constructor for the House class.
   * @param name The name of the house.
   * @param address The address of the house.
   * @param nFloors The number of floors in the house.
   * @param hasDiningRoom Whether the house has a dining room or not.
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Checks if the house has a dining room.
   * @return true if the house has a dining room, false otherwise.
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }
  
  /**
   * Gets the number of residents in the house.
   * @return The number of residents in the house.
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Adds a student to the house as a resident if they are not already on the list.
   * @param s The student to move into the house.
   */
  public void moveIn(Student s) {
    if (!this.residents.contains(s)) {
      this.residents.add(s);
      System.out.println(s.getName() + " has moved into " + this.getName() + "House.");
    } else {
      System.out.println(s.getName() + " is already a resident of " + this.getName() + "House.");
      }
    }

  /**
   * Moves a student out of the house if they are a resident.
   * @param s The student to move out of the house.
   * @return The student who moved out, or null if they were not a resident.
   */
  public Student moveOut(Student s) {
    if (this.residents.contains(s)) {
      this.residents.remove(s);
      System.out.println(s.getName() + " has moved out of " + this.getName() + "House.");
      return s;
    } else {
      System.out.println(s.getName() + " is not a resident of " + this.getName() + "House.");
      return null;
    }
  }

  /**
   * Checks if a student is a resident of the house.
   * @param s The student to check.
   * @return true if the student is a resident, false otherwise.
   */
  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }


  /**
   * Main method to test the House class.
   * @param args
   */
  public static void main(String[] args) {
    House lawrence = new House("Lawrence House", "99 Green St", 4, false);
    System.out.println(lawrence);
    lawrence.showOptions();

    System.out.println("-----------------------------------");
    System.out.println("Demonstrating enter/exit/navigation");
    System.out.println("-----------------------------------");
    lawrence.enter();
    lawrence.goUp();
    lawrence.goDown();
    lawrence.exit();
  }

}

