package library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private static int itemID = 0;
    private static int userID = 0;

    private FileWriter writer ;
    private FileReader reader;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private String filePath = "/src/library/LibraryContents.txt";

    private List<LibraryItem> libraryItemList = new ArrayList<LibraryItem>();
    private List<User> userList = new ArrayList<User>();
    private List<LibraryItem> tempItemList = new ArrayList<LibraryItem>();
    private String[] tempArray;

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
        user.addToItemsRented(item);
        libraryItemList.remove(item);
    }

    public void returnItem(User user, LibraryItem item){
        libraryItemList.add(item);
        user.removeRentedItem(item);
    }

    public void addNewUser(String userName, int phoneNo){

        User temp = new User(userID, userName, phoneNo);
        userList.add(temp);
        updateUserID();
    }

    public void addNewUser(String userName, int phoneNo, int specialID, String type){
        User tempSpecial;
        if (type.equals("library.Student")){
            tempSpecial = new Student(userID, userName, phoneNo, specialID);
            userList.add(tempSpecial);
            updateUserID();
        }
        else if (type.equals("library.Faculty")){
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
        Book temp = new Book(bookName, itemID, price, authorName);
        libraryItemList.add(temp);
        updateItemID();
    }

    public void addNewItem(double price, String bookName, String authorNameLocation, String topicDate, String type){
        if (type.equals("Journal")){
            Journal temp = new Journal(bookName, itemID, price, authorNameLocation, topicDate);
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
        Magazine temp = new Magazine(bookName, itemID, price, authorName, issueNumber);
        libraryItemList.add(temp);
        updateItemID();
    }

    public void removeItem(LibraryItem item){
        libraryItemList.remove(item);
    }

    public void removeItems(List<LibraryItem> itemList){
        libraryItemList.removeAll(itemList);
    }

    public void saveLibraryContentsToFile(){
        for (LibraryItem item : libraryItemList){
            try {
                bufferedWriter.write(item.toString(), 0, item.toString().length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLibraryContentsFile(){
        String currentLine = "";
        LibraryItem tempItem;
        while (currentLine != null){
            try {
                currentLine = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                currentLine = null;
            }
            if (currentLine != null){
                tempArray = currentLine.split("-");
                if(tempArray[0].equals("Book")){
                    tempItem = new Book(tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), tempArray[4]);
                    tempItemList.add(tempItem);
                }
                else if (tempArray[0].equals("Journal")){
                    tempItem = new Journal(tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), tempArray[4], tempArray[5]);
                    tempItemList.add(tempItem);
                }
                else if (tempArray[0].equals("Magazine")){
                    tempItem = new Magazine(tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), tempArray[4], Integer.parseInt(tempArray[5]));
                    tempItemList.add(tempItem);
                }
                else if (tempArray[0].equals("Map")){
                    tempItem = new Map(tempArray[1], Integer.parseInt(tempArray[2]), Double.parseDouble(tempArray[3]), tempArray[4], tempArray[5]);
                    tempItemList.add(tempItem);
                }
            }
        }
    }
}
