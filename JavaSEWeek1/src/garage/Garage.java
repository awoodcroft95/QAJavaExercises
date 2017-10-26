package garage;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    List<Vehicle> storedVehicles = new ArrayList<>();
    private double costOfRepair;
    private int iDCounter = 0;

    public void removeVehicleByID(int vehicleID){
        for (Vehicle v : storedVehicles){
            if (v.vehicleID == vehicleID){
                storedVehicles.remove(v);
            }
        }
    }

    public void removeVehicleByType(String vTypeName) { //takes vehicle type as parameter
        List<Vehicle> vehiclesToRemove = new ArrayList<>();
        for (Vehicle v : storedVehicles){
            if (vTypeName == (v.getClass().getName()).split("@")[0]){
                vehiclesToRemove.add(v);
            }
        }

        storedVehicles.removeAll(vehiclesToRemove);
    }

    public void addVehicle(Vehicle newVehicle){
        storedVehicles.add(newVehicle);
        iDCounter++;
        newVehicle.setVehicleID(iDCounter);
    }

    public double fixVehicle(Vehicle vehicleToBeFixed){
        vehicleToBeFixed.setFixed();
        if (vehicleToBeFixed instanceof Car){
            System.out.println("A car probably needs repair");
            if (vehicleToBeFixed.getNumOfWheels() < 4){
                costOfRepair = (4 - vehicleToBeFixed.getNumOfWheels()) * 35.00;
                vehicleToBeFixed.setNumOfWheels(4);
                return costOfRepair;
            }
            else {
                return 0.00;
            }
        }
        else if (vehicleToBeFixed instanceof Motorbike){
            System.out.println("A motorbike probably needs repair");
            if (vehicleToBeFixed.getNumOfSeats() == 0){
                costOfRepair = 1 * 25.00;
                vehicleToBeFixed.setNumOfSeats(1);
                return costOfRepair;
            }
            else {
                return 0.00;
            }
        }
        else if (vehicleToBeFixed instanceof Bicycle){
            if (((Bicycle) vehicleToBeFixed).getNumOfPedals() < 2){
                costOfRepair = 2 * 20.00;
                ((Bicycle) vehicleToBeFixed).setNumOfPedals(2);
                return costOfRepair;
            }
            else{
                return 0.00;
            }
        }
        else {
            return 0.00;
        }
    }

    public void emptyGaraqe(){
        storedVehicles.clear();
    }

    public void printGarageContents(){
        for(Vehicle v : storedVehicles){
            System.out.println(v.returnInfo());
        }
    }

}
