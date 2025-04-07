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
  private boolean hasElevator; 

  /**
   * Constructor for the House class.
   * @param name The name of the house.
   * @param address The address of the house.
   * @param nFloors The number of floors in the house.
   * @param hasDiningRoom Whether the house has a dining room or not.
   * @param hasElevator Whether the house has an elevator or not.
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /* Overloaded constructor (without elevator information, defaults to no elevator) */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    this(name, address, nFloors, hasDiningRoom, false);
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

  /* Overloaded moveIn method (accepts a student's name instead of a Student object) */
  public void moveIn(String studentName) {
    Student s = new Student(studentName); // Assuming a Student constructor that takes a name
    this.moveIn(s);
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

  /* Overloaded moveOut method (removes a student by name) */
  public Student moveOut(String studentName) {
    for (Student s : this.residents) {
      if (s.getName().equals(studentName)) {
        return this.moveOut(s);
      }
    }
    System.out.println(studentName + " is not a resident of " + this.getName() + " House.");
    return null;
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
   * Overrides the showOptions method to include House-specific options.
   */
  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(Student s) \n + moveOut(Student s) \n + hasDiningRoom() \n + nResidents()");
  }

  /**
   * Overrides the goToFloor method to account for whether the house has an elevator.
   * @param floorNum The floor to go to.
   */
  @Override
  public void goToFloor(int floorNum) {
    if (!this.hasElevator && (floorNum > this.activeFloor + 1 || floorNum < this.activeFloor - 1)) {
      throw new RuntimeException("This house does not have an elevator. You can only move to adjacent floors.");
    }
    super.goToFloor(floorNum);
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
    // lawrence.goToFloor(4); This should throw an exception since the house has no elevator
    // lawrence.goToFloor(2);
    // lawrence.exit(); // This should throw an exception because we can't exxit from the 4th floor
    lawrence.goToFloor(1);
    lawrence.exit(); // This should work now


    System.out.println("-----------------------------------");
    System.out.println("Demonstrating moveIn/moveOut");
    System.out.println("-----------------------------------");
    Student yunxian = new Student("Yunxian");
    lawrence.moveIn(yunxian);
    lawrence.moveOut(yunxian);
    lawrence.moveOut("ding"); // This should fail since "ding" is not a resident
  }

}

