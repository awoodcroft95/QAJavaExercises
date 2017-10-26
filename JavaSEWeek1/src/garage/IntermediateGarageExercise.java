package garage;

public class IntermediateGarageExercise {

    public static void main(String[] args){
        garageExercise();
    }
    public static void garageExercise(){
        Car muscleCar = new Car(2, 4, "Mustang", true);
        Motorbike sportBike = new Motorbike(2, 1, "Yamaha", true);
        Bicycle bMX = new Bicycle(2, 1, "Offroader", 2);
        Garage bobsGarage = new Garage();

        bobsGarage.addVehicle(muscleCar);
        bobsGarage.addVehicle(sportBike);
        bobsGarage.addVehicle(bMX);
        bobsGarage.printGarageContents();

        sportBike.setBroken();

        System.out.println("Cost of repairing a car £" + bobsGarage.fixVehicle(muscleCar));
        bobsGarage.removeVehicleByType("Car");
        bobsGarage.printGarageContents();
    }
}
