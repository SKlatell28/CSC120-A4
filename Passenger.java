public class Passenger implements PassengerRequirements{
    
    //Attributes
    String name;

    /* Constructor // Makes A Passanger
     * @param name -- the passangers name
     */
    public Passenger(String name) {
        this.name = name;
    }

    //Checks if customer can get in a car
    public void boardCar(Car c) {
        Boolean possible = c.addPassenger(this);
        if (possible) {
            System.out.println("The boarding was sucessful!");
        } else {
            System.out.println("There was a problem getting on this train car...");
        }
    }

    //Checks if customer can get off a car
    public void getOffCar(Car c) {
        Boolean possible = c.removePassenger(this);
        if (possible) {
            System.out.println("Successful removal");
        } else {
            System.out.println("It seems there was a problem..are you sure the passanger was ever in this car?");
        }
    }

}
