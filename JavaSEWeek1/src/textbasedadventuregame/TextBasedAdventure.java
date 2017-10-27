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
        newWorld.generateLoactions();
        System.out.println("The Barren Moore....");
        System.out.println("To start playing enter you name:");
        String playerName = sc.nextLine();
        newWorld.setPlayer(playerName);
        System.out.println(playerName + ", you awaken in a barren moore.");
        System.out.println("The moore seems infinite with dense fog blocking your view of the horizon.");
        //add player to starting location

        //Main Input Loop
        while (programRunning){
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



        }

    }

}
