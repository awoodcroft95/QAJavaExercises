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
        //add item back to library list
        //remove item from user list
    }

    public void addNewUser(String userName, int phoneNo){

        User temp = new User(userID, userName, phoneNo);
        userList.add(temp);
        updateUserID();
    }

    public void addNewUser(String userName, int phoneNo, int specialID, String type){
        User tempSpecial;
        if (type.equals("Student")){
            tempSpecial = new Student(userID, userName, phoneNo, specialID);
            userList.add(tempSpecial);
            updateUserID();
        }
        else if (type.equals("Faculty")){
            tempSpecial = new Faculty(userID, userName, phoneNo, specialID);
            userList.add(tempSpecial);
            updateUserID();
        }
        else{
            //Do something?Error Message?
        }
    }

    public void deleteUser(User user){
        userList.remove(user);
    }

    public void updateUser(User user, String userName, int phoneNo){
        user.setUserName(userName);
        user.setPhoneNo(phoneNo);
    }

    public void addNewItem(double price, String bookName, String authorName){
        Book temp = new Book(itemID, price, bookName, authorName);
        libraryItemList.add(temp);
        updateItemID();
    }

    public void addNewItem(double price, String bookName, String authorNameLocation, String topicDate, String type){
        if (type.equals("Journal")){
            Journal temp = new Journal(itemID, price, bookName, authorNameLocation, topicDate);
            libraryItemList.add(temp);
            updateItemID();
        }
        else if (type.equals("Map")){
            Map temp = new Map(bookName, itemID, price, authorNameLocation, topicDate);
            libraryItemList.add(temp);
            updateItemID();
        }
        else{
            //do something?Error Message?
        }
    }

    public void addNewItem(double price, String bookName, String authorName, int issueNumber){
        Magazine temp = new Magazine(itemID, price, bookName, authorName, issueNumber);
        libraryItemList.add(temp);
        updateItemID();
    }
}
