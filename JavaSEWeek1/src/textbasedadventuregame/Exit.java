package textbasedadventuregame;

import java.util.List;

public class Exit {

    private int north = 1;
    private int east = 2;
    private int south = 3;
    private int west = 4;

    private String northStr = "north";
    private String eastStr = "east";
    private String southStr = "south";
    private String westStr = "west";

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




}
