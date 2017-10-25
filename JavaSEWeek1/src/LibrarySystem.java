import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private static int itemID;
    private static int userID;

    private FileWriter writer ;
    private FileReader reader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String filePath = "C:/Users/Admin/Documents/LibraryContents.txt";

    private List<LibraryItem> libraryItemList = new ArrayList<LibraryItem>();

    public LibrarySystem() {
        try {
            writer = new FileWriter(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            reader = new FileReader(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(writer);
        bufferedReader = new BufferedReader(reader);
    }

}
