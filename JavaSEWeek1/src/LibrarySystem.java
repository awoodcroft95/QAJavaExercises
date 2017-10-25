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
    private List<User> userList = new ArrayList<User>();

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

    public int getItemID(){
        return itemID;
    }

    public int getUserID(){
        return userID;
    }

    private void updateItemID(){
        itemID++;
    }

    private void updateUserID(){
        userID++;
    }

    public void issueItem(User user, LibraryItem item){
        //add item to user list
        //remove item from library list
    }

    public void returnItem(User user, LibraryItem item){
        //remove item from user list
        //add item back to library list
    }

    public void addNewUser(int userID, String userName, int phoneNo){

        User temp = new User(userID, userName, phoneNo);
        userList.add(temp);
    }

    public void addNewUser(int userID, String userName, int phoneNo, int specialID, String type){
        User tempSpecial;
        if (type.equals("Student")){
            tempSpecial = new Student(userID, userName, phoneNo, specialID);
            userList.add(tempSpecial);
        }
        else if (type.equals("Faculty")){
            tempSpecial = new Faculty(userID, userName, phoneNo, specialID);
            userList.add(tempSpecial);
        }
        else{
            //Do something?
        }
    }

    public void deleteUser(User user){
        userList.remove(user);
    }

    public void updateUser(User user){

    }
}
