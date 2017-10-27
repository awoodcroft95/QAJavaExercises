package textbasedadventuregame;

import java.util.Scanner;

public class TextBasedAdventure {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        World newWorld = new World();
        String command;
        SpecialItem pocketWatch = new SpecialItem("Pocket Watch", "An odd pocket watch that doesn't seem to tell the time.", "Shows North and the direction of treasure.");
        int xCounter = 10;
        int yCounter = 10;
        boolean notFound = true;
        NonPlayerCharacter monster = new NonPlayerCharacter("monster", "At least 8ft tall and has sharp fangs and claws.");
        Item treasure = new Item("Treasure", "Gems and Gold Coins contained in a chest.");

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
                System.out.println("The pocket watch has a hand and a dial, the dial reads: " + (xCounter - 7) + "x " + (yCounter - 7) + "y");
                System.out.println("You think the hand is pointing north.");
                notLooked = false;
            } else {
                System.out.println("To continue use the command 'look' (no quote marks)");
            }
        }
        //Main Input Loop
        while (programRunning){
            System.out.println("\n \n Try 'north', 'south', 'east' or 'west'.");
            System.out.println("'look' to look around for items, 'check' to check the pocket watch,  'exit' to stop playing.");
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
            } else if (command.equals("west") && newWorld.getPlayer().getLocationIndex() % 10 == 0){
                System.out.println("This way is blocked by a thick forest covered with brambles 20ft high.");
                System.out.println("Maybe you should try a different direction.");
            } else if (command.equals("north") && newWorld.getPlayer().getLocationIndex() > 9){
                System.out.println("You head north.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()-10);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
                yCounter++;
            } else if (command.equals("east") && !(newWorld.getPlayer().getLocationIndex() % 10 == 9)){
                System.out.println("You head east.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()+1);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
                xCounter--;
            } else if (command.equals("south") && newWorld.getPlayer().getLocationIndex() < 90){
                System.out.println("You head south.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()+10);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
                yCounter--;
            } else if (command.equals("west") && !(newWorld.getPlayer().getLocationIndex() % 10 == 0)){
                System.out.println("You head west.");
                newWorld.getPlayer().setLocationIndex(newWorld.getPlayer().getLocationIndex()-1);
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).toString());
                xCounter++;
            } else if (command.equals("look")){
                System.out.println("You look around.");
                System.out.println(newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).getLocationDesc());
                try {
                    for (Item item : newWorld.getLocations().get(newWorld.getPlayer().getLocationIndex()).getItems()) {
                        newWorld.getPlayer().addItem(item);
                        System.out.println(item.toString());
                    }
                }catch (Exception e){
                    System.out.println("There were no items here.");
                    //e.printStackTrace();
                }
                if (notFound){
                    if (newWorld.getPlayer().getLocationIndex() == 33){
                        System.out.println("You found some treasure, \nYOU WIN!!!\n it's not much use here in the Moore though.");
                        System.out.println("You can continue to explore but finding a way out looks hopeless. \n 'exit' to end the game.");
                        newWorld.getPlayer().addItem(treasure);
                        notFound = false;
                    }
                }
            }else if (command.equals("check")){
                System.out.println("You check the pocket watch.");
                System.out.println("It points north and reads: " + (xCounter - 7) + "x " + (yCounter - 7) + "y");
            }
            else if (command.equals("exit")){
                programRunning = false;
            }
            else {
                System.out.println("That's not a valid commands please try again.");
            }

            if (newWorld.getPlayer().getLocationIndex() == 21){
                System.out.println();
                System.out.println("A monster appears," + monster.getDescription() + ", attack it or run away?");
                System.out.println("'attack'    'run'");
                command = sc.nextLine();
                if (command.equals("attack")){
                    System.out.println("You attack the monster and it runs away.");
                }
                else if (command.equals("run")){
                    System.out.println("You run away from the monster and hide in a bush until it leaves.");
                }
                else {
                    System.out.println("Make a decision quickly or you'll die!!!");
                }
            }
        }
    }
}
