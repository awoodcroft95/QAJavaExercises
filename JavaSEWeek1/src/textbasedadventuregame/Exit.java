package textbasedadventuregame;

import java.util.List;

public class Exit {

    private final int north = 1;
    private final int east = 2;
    private final int south = 3;
    private final int west = 4;

    private final String northStr = "north";
    private final String eastStr = "east";
    private final String southStr = "south";
    private final String westStr = "west";

    private Location leadsTo = null;

    private String directionName;
    private int directionNumber;

    public Exit(int directionNumber, Location leadsTo){
        this.directionNumber = directionNumber;
        this.leadsTo = leadsTo;
        if (directionNumber == 1){
            directionName = northStr;
        }else if(directionNumber == 2){
            directionName = eastStr;
        }
        else if(directionNumber == 3){
            directionName = southStr;
        }
        else if(directionNumber == 4){
            directionName = westStr;
        }
        else{
            directionName = null;
            directionNumber = -1;
            leadsTo = null;
        }
    }

    public Location getLeadsTo() {
        return leadsTo;
    }

    public void setLeadsTo(Location leadsTo) {
        this.leadsTo = leadsTo;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public void setDirectionNumber(int directionNumber) {
        this.directionNumber = directionNumber;
    }
}
