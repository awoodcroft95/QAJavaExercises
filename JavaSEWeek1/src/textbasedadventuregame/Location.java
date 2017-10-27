package textbasedadventuregame;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<Item> items = new ArrayList<Item>();
    private String locationName;
    private String locationDesc;
    private List<Exit> exits = new ArrayList<Exit>();

    public Location(String name, String description){
        this.locationName = name;
        this.locationDesc = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public void addExits(Exit exit){
        this.exits.add(exit);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    @Override
    public String toString() {
        return getLocationName() + "-" + getLocationDesc();
    }

    //override toString - output information about the location

}
