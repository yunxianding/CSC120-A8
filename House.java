/* This is a stub for the House class */

import java.util.ArrayList;

/**
 * The House class is a special type of building.
 * Students can live, work and eat(if there is a dining room) in a house.
 */

public class House extends Building implements HouseRequirements {

    // New Attributes
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

    /* Default constructor (with no dining hall and no elevator) */
    public House() {
        this("<Name Unknown>", "<Address Unknown>", 1, false, false);
    }

    /* Overloaded constructor with nFloor, hasElevator, and hasDiningRoom only */
    public House(int nFloors, boolean hasDiningRoom, boolean hasElevator) {
        this("<Name Unknown>", "Address Unknown", nFloors, hasDiningRoom, hasElevator);
    }

    /**
     * Checks if the house has a dining room.
     * @return true if the house has a dining room, false otherwise.
     */
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Checks if the house has an elevator.
     * @return true if the house has an elevator, false otherwise.
     */
    public boolean hasElevator() {
        return this.hasElevator;
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
            System.out.println(s.getName() + " has moved into " + this.getName() + "House successfully.");
        } else {
            throw new RuntimeException(s.getName() + " is already a resident of " + this.getName() + "House.");
        }
    }

    /* Overloaded moveIn method (move in multiple students) */
    public void moveIn(ArrayList<Student> students) {
        for(int i = 0; i <= (students.size() - 1 ); i++) { 
            if(this.residents.contains(students.get(i))) { 
                throw new RuntimeException(students.get(i).getName() + "already lives here.");
            } else {
            this.residents.add(students.get(i));
            System.out.println(students.get(i).getName() + " has moved in successfully.");
          }
        }
    }

    /**
    * Moves a student out of the house if they are a resident.
    * @param s The student to move out of the house.
    */
    public Student moveOut(Student s) {
        if (this.residents.contains(s)) {
            this.residents.remove(s);
            System.out.println(s.getName() + " has moved out of " + this.getName() + "House successfully.");
            return s;
        } else {
            throw new RuntimeException(s.getName() + " is not a resident of " + this.getName() + "House.");
        }
    }

    /* Overloaded moveOut method (move out multiple students) */
    public void moveOut(ArrayList<Student> students) {
        for(int i = 0; i <= (students.size() - 1); i++) {
            if(this.residents.contains(students.get(i))) {
                System.out.println(students.get(i).getName() + " has moved out successfully.");
            } else {
            throw new RuntimeException(students.get(i).getName() + "does not live here.");
            }    
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
    * Overrides the showOptions method to show available options in a house.
    */
    public void showOptions() {
        if (hasElevator) {
            super.showOptions(); 
            System.out.println(" + moveIn(Student s) \n + moveOut(Student s) \n");
        } else {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown() \n + moveIn(Student s) \n + moveOut(Student s) \n");
        }
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
        House lawrence = new House("Lawrence House", "99 Green St", 4, false, false);
        System.out.println(lawrence);
        lawrence.showOptions();
        ArrayList<Student> students = new ArrayList<Student>();
        Student A = new Student("A", "123", 2028);
        Student B = new Student("B", "456", 2028);
        Student C = new Student("C", "789", 2028);
        students.add(A);
        students.add(B);
        students.add(C);

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        lawrence.enter();
        lawrence.goUp();
        lawrence.goDown();
        //lawrence.goToFloor(4); // This should throw an exception since the house has no elevator
        //lawrence.goToFloor(2);
        //lawrence.exit(); // This should throw an exception because we can't exit from the 4th floor
        lawrence.goToFloor(1);
        lawrence.exit(); // This should work now

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating moveIn/moveOut");
        System.out.println("-----------------------------------");
        lawrence.moveIn(students);
        lawrence.moveOut(students);
    }
}