import java.util.ArrayList; //Array Class List


public class Car implements CarRequirements{

    //Attributes
    private Integer max_capacity;
    private ArrayList<String> passanger_list;

    /** Constructor for Car
     * @param capacity the cars total capacity
     */
    public Car(Integer max_capacity, String passanger_list) {
        this.max_capacity = max_capacity;
        this.passanger_list = new ArrayList<String>();
    }

    //returns + prints the number of available seats in the train car
    public int seatsRemaining() {
        if (this.passanger_list == null) {
            return max_capacity;
        } else {
        Integer now = this.max_capacity - this.passanger_list.size();
        return now;
        }
    }

    //returns + prints the max seats in the train car
    public int getCapacity() {
        return this.max_capacity;
    }

    //removes a passanger from the train car (if they're on it)
    public Boolean removePassenger(Passenger p) {
        String byName = String.valueOf(p.name);
        if (this.passanger_list.contains(byName)) {
            System.out.println("Removing " + byName + " from this car!");
            this.passanger_list.remove(byName);
            return true;
        }
        System.out.println("This passenger is not in this car...");
        return false;
    }


    //adds a passanger to the train car if there's space and they're not on it
    public Boolean addPassenger(Passenger p) {

        String byName = String.valueOf(p.name);
        if (this.passanger_list == null) {
            this.passanger_list.add(byName);
            return true;
        }
        if (this.passanger_list.size() >= 10) {
            System.out.println("Sorry! This car is full! try another one...");
            return false;
        }
        if (this.passanger_list.contains(byName)) {
            System.out.println("This passenger is already in this car...");
            return false;
        }
        this.passanger_list.add(byName);
        System.out.println("Adding " + p.name + " to car!");
        return true;
    }

    //prints list of all passengers in train car
    public void printManifest() {
        if (this.passanger_list.size() > 0) {
            for (String i : this.passanger_list) {
                System.out.println(i);
            }
        } else {
            System.out.println("This car is EMPTY!");
        }
        
    }

    //Makes info easier to read
    public String toString() {
        int current = this.seatsRemaining();
        return("Car has a max capicity of " + max_capacity + " with " + current + " seats remainging. The passenger(s) onboard are: " + this.passanger_list);
    }

    //Main
    public static void main(String[] args) {
        Car myCar = new Car(10, "List");
        Passenger Ben = new Passenger("Ben");
        myCar.addPassenger(Ben);
        myCar.addPassenger(Ben);
        Passenger Ronnie = new Passenger("Ronnie");
        myCar.addPassenger(Ronnie);
        myCar.printManifest();
        myCar.removePassenger(Ronnie);
 
        System.out.println("");
        System.out.println(myCar.toString());

    }

}