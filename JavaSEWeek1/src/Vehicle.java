public class Vehicle {
    protected int numOfWheels;
    protected int numOfSeats;
    protected String modelName;
    protected int vehicleID;
    protected boolean isBroken;

    public Vehicle(int numOfWheels, int numOfSeats, String modelName){
        this.numOfWheels = numOfWheels;
        this.numOfSeats = numOfSeats;
        this.modelName = modelName;
    }

    public void setVehicleID(int id){
        this.vehicleID = id;
    }

    public void setFixed(){
        this.isBroken = false;
    }

    public void setBroken(){
        this.isBroken = true;
    }

    public int getNumOfWheels(){
        return this.numOfWheels;
    }

    public int getNumOfSeats() {
        return this.numOfSeats;
    }

    public int getVehicleID() {
        return this.vehicleID;
    }

    public void setNumOfWheels(int newNumOfWheels){
        this.numOfWheels = newNumOfWheels;
    }

    public void setNumOfSeats(int newNumOfSeats){
        this.numOfSeats = newNumOfSeats;
    }

    public String returnInfo(){
        return this.modelName + this.getVehicleID() + this.getClass().getName();
    }

}

class Car extends Vehicle {
    private boolean roof;

    public Car(int numOfWheels, int numOfSeats, String modelName, boolean roof) {
        super(numOfWheels, numOfSeats, modelName);
        this.roof = roof;
    }
}


class Motorbike extends Vehicle{

    private boolean handlebars;

    public Motorbike(int numOfWheels, int numOfSeats, String modelName, boolean handlebars) {
        super(numOfWheels, numOfSeats, modelName);
        this.handlebars = handlebars;
    }

}

class Bicycle extends Vehicle{
    private int numOfPedals;

    public Bicycle(int numOfWheels, int numOfSeats, String modelName, int numOfPedals) {
        super(numOfWheels, numOfSeats, modelName);
        this.numOfPedals = numOfPedals;
    }

    public int getNumOfPedals(){
        return this.numOfPedals;
    }

    public void setNumOfPedals(int newPedals){
        this.numOfPedals = newPedals;
    }
}
