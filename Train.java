import java.util.ArrayList; //Array Class List

public class Train implements TrainRequirements {


    public Engine TheFastExpress = new Engine(this.fuelType, this.fuelCapacity, this.fuelCapacity);
    private ArrayList<Car> numberOfCars;
    
        //Attributes
        FuelType fuelType;
        double fuelCapacity;
        int nCars;
        int passengerCapacity;
    
        /* Constructor for Train//Makes a train
         * @param fuelType -- the Trains fuel type
         * @param fuelCapicity -- the trains total fuel capacity
         * @param nCars -- the amount of train cars per train
         * @param passengerCapaciy -- the amount of available seats per train car
         */
        public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
            this.fuelType = fuelType;
            this.fuelCapacity = fuelCapacity;
            this.nCars = nCars;
            this.passengerCapacity = passengerCapacity;
    
            TheFastExpress.f = this.fuelType;
            TheFastExpress.currentFuelLevel = this.fuelCapacity;
            TheFastExpress.maxFuelLevel = this.fuelCapacity;
    
            this.numberOfCars = new ArrayList<>();
            for (int i = 1; i < (this.nCars + 2); i++) {
                Car expressCar = new Car(this.passengerCapacity, null);
                numberOfCars.add(expressCar);
            }
            
        }
    
        //Prints out the engine information (using Engine.java's toString)
        public Engine getEngine() {
            System.out.println(TheFastExpress.toString());
            return this.TheFastExpress;
        }
    
        //Prints out info about all the train cars (using Car.java's toString)
        public Car getCar(int i) {
            System.out.println("Car " + i + ":   " + this.numberOfCars.get(i));
            return this.numberOfCars.get(i);
        }
    
        //Gets the maximum capacity (# of available seats) of the train as a whole
        public int getMaxCapacity() {
            return nCars * this.passengerCapacity;
        }
    
        //Gets the number of seats remaining on the train
        public int seatsRemaining() {
            this.getMaxCapacity();
            int compounding = 0;
            for (int i = 1; i < (this.nCars) + 1; i++) {
                compounding += this.getCar(i).seatsRemaining();
                System.out.println("SEATS REMAINING IS: " + okay);
            }
            return compounding;
        }
    
        //Prints alll the passengers currently on the train
        public void printManifest() {
            System.out.println("");
            System.out.println("LIST OF ALL CUSTOMERS ON TRAIN: ");
            for (int i = 1; i < (this.nCars + 1); i++) {
                System.out.println("Car " + i + ": ");
                this.numberOfCars.get(i).printManifest();
            }
        }
    
        //Main
        public static void main(String[] args) {
            Train FastExpress = new Train(FuelType.STEAM, 100., 6, 10);
            FastExpress.getEngine();
            FastExpress.getCar(3);
            Passenger Ron = new Passenger("Ron");
            FastExpress.numberOfCars.get(3).addPassenger(Ron);
            Passenger Harry = new Passenger("Harry");
            FastExpress.numberOfCars.get(3).addPassenger(Harry);
            Passenger Hermione = new Passenger("Hermione");
            FastExpress.numberOfCars.get(3).addPassenger(Hermione);
            FastExpress.getCar(3);
            System.out.println("");
            FastExpress.getCar(1);
            Passenger Dumbledore = new Passenger("Dumbledore");
            FastExpress.numberOfCars.get(1).addPassenger(Dumbledore);
            Passenger Snape = new Passenger("Snape");
            FastExpress.numberOfCars.get(1).addPassenger(Snape);
            FastExpress.getCar(1);
            System.out.println("");
            FastExpress.getCar(5);
            Passenger Malfoy = new Passenger("Malfoy");
            FastExpress.numberOfCars.get(5).addPassenger(Malfoy);
            Passenger Crabbe = new Passenger("Crabbe");
            FastExpress.numberOfCars.get(5).addPassenger(Crabbe);
            Passenger Goyle = new Passenger("Goyle");
            FastExpress.numberOfCars.get(5).addPassenger(Goyle);
            FastExpress.getCar(5);
            System.out.println("");
            FastExpress.seatsRemaining();
            FastExpress.printManifest();


    }
}
