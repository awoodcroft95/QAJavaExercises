package textbasedadventuregame;

public class Item {

    private String name;
    private String description;

    public Item(){

    }

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getName() + "-" + this.getDescription();
    }
}

class SpecialItem extends Item {

    private String specialFunction;

    public SpecialItem(String name, String description, String specialFunction){
        super(name, description);
        this.specialFunction = specialFunction;
    }

}
