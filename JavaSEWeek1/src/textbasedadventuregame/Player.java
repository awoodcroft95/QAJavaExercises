package textbasedadventuregame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Item> inventory = new ArrayList<Item>();

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
