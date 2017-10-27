package textbasedadventuregame;

import java.util.Scanner;

public class TextBasedAdventure {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        World newWorld = new World();
        String command;
        SpecialItem pocketWatch = new SpecialItem("Pocket Watch", "An odd pocket watch that doesn't seem to tell the time.", "Shows North and the direction of treasure.");



        boolean programRunning = true;
        //Setup
        newWorld.generateLocations();
        System.out.println("The Barren Moore....");
        System.out.println("To start playing enter you name:");
        String playerName = sc.nextLine();
        newWorld.setPlayer(playerName);
        System.out.println(playerName + ", you awaken in a barren moore.");
        System.out.println("The moore seems infinite with dense fog blocking your view of the horizon.");
        newWorld.getPlayer().setLocationIndex(0);
        boolean notLooked = true;
        while(notLooked){
            System.out.println("Try 'Look'");
            command = sc.nextLine().toLowerCase();
            if (command.equals("look")){
                System.out.println("You look down and see what looks like a small pocket watch.");
                newWorld.getPlayer().addItem(pocketWatch);
                System.out.println("The pocket watch has too hands, both fixed on different directions.");
                System.out.println("You think one is pointing north, the other you're not so sure about.");
                notLooked = false;
            } else {
                System.out.println("To continue use the command 'look' (no quote marks)");
            }
        }
        //Main Input Loop
        while (programRunning){
            System.out.println("Try 'north', 'south', 'east' or 'west'.  'exit' to stop playing.");
            command = sc.nextLine().toLowerCase();
            if (command.equals("north") && newWorld.getPlayer().getLocationIndex() < 10){
                System.out.println("A large rock face seems to cut off the Moore in this direction, it looks impossible to pass.");
                System.out.println("Maybe you should try a different direction.");
            } else if (command.equals("east") && newWorld.getPlayer().getLocationIndex() % 10 == 9){
                System.out.println("The moore seems to become a very deep lake here, there is no hope in trying to cross it.");
                System.out.println("Maybe you should try a different direction.");
            } else if (command.equals("south") && newWorld.getPlayer().getLocationIndex() >= 90){
                System.out.println("The fog clears here and the moore seems to never end in this direction.");
                System.out.println("There's no hope in trying to go this way.");
                System.out.println("Maybe you should try a different direction.");
            } else if (command.equals("west") && newWorld.getPlayer().getLocationIndex() / 10 < 10){
                System.out.println("This way is blocked by a thick forest covered with brambles 20ft high.");
                System.out.println("Maybe you should try a different direction.");
            } else if (command.equals("north") && newWorld.getPlayer().getLocationIndex() > 10){
                System.out.println("You head north.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()-10);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
            } else if (command.equals("east") && !(newWorld.getPlayer().getLocationIndex() % 10 == 9)){
                System.out.println("You head east.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()+1);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
            } else if (command.equals("south") && newWorld.getPlayer().getLocationIndex() < 90){
                System.out.println("You head south.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()+10);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
            } else if (command.equals("west") && newWorld.getPlayer().getLocationIndex() / 10 > 10){
                System.out.println("You head west.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()-1);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
            } else if (command.equals("look")){
                System.out.println("You look around.");
                newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).getItems(); //finish this
            }
        }
    }
}
