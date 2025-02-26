public class Engine implements EngineRequirements{
    //Attributes
    public FuelType f;
    public double currentFuelLevel;
    public double maxFuelLevel;

    /**
     * Constructor for Engine
     * @param f Engine's fuel type
     * @param currentFuelLevel currentFuelLevel Engine's current fuel level
     * @param maxFuelLevel maxFuelLevel Engine's max fuel level
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel) {
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    //Returns the fuel type of the engine
    public FuelType getFuelType() {
        return this.f;
    }

    //returns the engines maximum fuel level
    public double getMaxFuel() {
        return this.maxFuelLevel;
    }

    //returns how much fuel is currently in the engine
    public double getCurrentFuel() {
        return this.currentFuelLevel;

    }

    //refuels the engine to maximum fuel-level (if its not already)
    public void refuel() {
        double total = this.getMaxFuel();
        double now = this.getCurrentFuel();
        double needed = total - now;
        this.currentFuelLevel += needed;
        System.out.println("Adding " + needed + " to fuel level. Fuel level now at the maximum, " + total);
    }

    //Goes if the engine has enough fuel for trip, subtracts appropriate amount of fuel
    public Boolean go() {
        double now = this.getCurrentFuel();
        if (now >= 25.) {
            this.currentFuelLevel -= 25.;
            double now_2 = this.getCurrentFuel();
            if (now_2 == 0) {
                return false;
            }
            return true;
        }
        System.out.println("You do not have enough fuel to run! Please refuel.");
        return false;
    }

    //Makes print out easier to read
    public String toString() {
        return "Engine has fuel type:" + this.f + ". Engine current fuel level: " + this.currentFuelLevel + ". Engine max fuel level: " + this.maxFuelLevel;

    }


    //Main
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
    
}