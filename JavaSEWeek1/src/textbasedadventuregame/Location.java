package textbasedadventuregame;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<Item> items = new ArrayList<Item>();
    private String locationName;
    private String locationDesc;
    private int row;
    private int column;
    private List<Exit> exits = new ArrayList<Exit>();

    public Location(String name, String description, int row, int column){
        this.locationName = name;
        this.locationDesc = description;
        this.row = row;
        this.column = column;
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

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return getLocationName() + "-" + getLocationDesc();
    }
    //override toString - output information about the location

}
