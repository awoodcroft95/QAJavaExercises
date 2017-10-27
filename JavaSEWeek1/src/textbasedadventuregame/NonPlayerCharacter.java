package textbasedadventuregame;

public class NonPlayerCharacter extends Character {

    private String description;

    public NonPlayerCharacter(String name, String desc){
        super(name);
        this.description = desc;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return this.getName() + "-" + this.getDescription();
    }
}
