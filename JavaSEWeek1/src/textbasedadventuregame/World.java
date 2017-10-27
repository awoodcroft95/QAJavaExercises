package textbasedadventuregame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {

    private List<Location> locations = new ArrayList<Location>();
    //as the player moves around new locations are created and added after going outside the pre-generated zone.
    private Random rand = new Random();
    private Player player;

    public World(){

    }


    public void generateLocations(){
        String tempName;
        String tempDesc = "A foggy barren moore surrounds you, the fog is so dense you can't see very far into the distance.";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Location tempLocation;

                if (i <= 3){
                    tempName = "The Moore Hills";
                } else if (i <= 6 && i > 3){
                    tempName = "The Moore Flat Lands";
                } else {
                    tempName = "The Moore Low Lands";
                }
                descriptionGenerator(j);
                tempLocation = new Location(tempName, tempDesc, i, j);
                locations.add(tempLocation);
            }
        }
    }

    public String descriptionGenerator(int number){
        int random = number * (rand.nextInt(10)+1);
        if  (random < 10){
            return "The area is covered in small spiky plants, you have to move carefully to avoid getting spiked.";
        }else if (random >= 10 && random < 20){
            return "The water here goes up to just below your hips, it is cold and cloudy, you have to cautiously nake your way through.";
        }
        else if (random >= 20 && random < 30) {
            return "Rain starts to pour down around you, there is a small tree to sit under until the rain stops";
        }
        return "";
    }

    public void setPlayer(String name){
        player = new Player(name);
    }

    public Player getPlayer() {
        return player;
    }
}
