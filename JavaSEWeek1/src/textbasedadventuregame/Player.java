package textbasedadventuregame;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private List<Item> inventory = new ArrayList<Item>();
    private int locationIndex;

    public Player(String name){
        super(name);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item){
        this.inventory.add(item);
    }

    public String mostRecentItemInfo(){
        return this.getInventory().get(this.getInventory().size()-1).toString();
    }

    public int getLocationIndex() {
        return locationIndex;
    }

    public void setLocationIndex(int locationIndex) {
        this.locationIndex = locationIndex;
    }

    public String toString(){
        return (this.getName() + "-" + getLocationIndex());
    }
}
