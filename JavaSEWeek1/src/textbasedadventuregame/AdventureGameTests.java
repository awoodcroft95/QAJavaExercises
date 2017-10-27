package textbasedadventuregame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureGameTests {
    World testWorld;
    Location testLocation;
    Player testPlayer;
    Item testItem;
    NonPlayerCharacter testNPC;

    @BeforeEach
    void setUp() {
        testWorld = new World();
        testLocation = new Location("The Moore Hills", "The area is covered in small spiky plants, you have to move carefully to avoid getting spiked.", 0, 0);
        testPlayer = new Player("John");
        testItem = new Item("Item1", "This is Item1");
        testNPC = new NonPlayerCharacter("Monster", "Scary Monster");
    }

    @AfterEach
    void tearDown() {
        testLocation = null;
    }

    @Test
    void descriptionGenerator() {
        String result = testWorld.descriptionGenerator(11);
        assertEquals("The moore seems infinite with dense fog blocking your view of the horizon.", result);
    }

    @Test
    void descriptionGeneratorRand() {
        String result = testWorld.descriptionGenerator(1);
        assertEquals("The area is covered in small spiky plants, you have to move carefully to avoid getting spiked.", result);
    }

    @Test
    void genLocations(){
        testWorld.generateLocations();
        assertEquals(testLocation.toString(), testWorld.getLocations().get(0).toString());
    }

    @Test
    void addItemToPlayer(){
        testPlayer.addItem(testItem);
        assertEquals(testItem.toString(), testPlayer.getInventory().get(0).toString());
    }

    @Test
    void getRecentItemInfo(){
        testPlayer.addItem(testItem);
        String result = testPlayer.mostRecentItemInfo();
        assertEquals(testItem.toString(), result);
    }

    @Test
    void nPCToString(){
        String result = testNPC.toString();
        assertEquals("Monster-Scary Monster", result);
    }

    @Test
    void playerToString(){
        testPlayer.setLocationIndex(0);
        String result = testPlayer.toString();
        assertEquals("John-0", result);
    }

    @Test
    void getLocationIndex(){
        testLocation.setRow(5);
        testLocation.setColumn(3);
        int result = testLocation.getIndex();
        assertEquals(53, result);
    }

}