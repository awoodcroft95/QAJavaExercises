package library;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String userName;
    private int phoneNo;
    private List<LibraryItem> itemsRented = new ArrayList<LibraryItem>();

    public User(int userID, String userName, int phoneNo){
        this.userID = userID;
        this.userName = userName;
        this.phoneNo = phoneNo;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<LibraryItem> getItemsRented() {
        return itemsRented;
    }

    public void addToItemsRented(LibraryItem newItem){
        this.itemsRented.add(newItem);
    }

    public void removeRentedItem(LibraryItem oldItem){
        this.itemsRented.remove(oldItem);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "-" + this.getUserName() + "-" + this.getUserID() + "-" + this.getPhoneNo();
    }
}

class Student extends User {

    private int studentID;

    public Student(int userID, String userName, int phoneNo, int studentID){
        super(userID, userName, phoneNo);
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return super.toString() + "-" +  this.studentID;
    }
}

class Faculty extends User {
    private int facultyID;

    public Faculty(int userID, String userName, int phoneNo, int facultyID){
        super(userID, userName, phoneNo);
        this.facultyID = facultyID;
    }

    public void extendRerturnDate(){

    }

    @Override
    public String toString() {
        return super.toString() + "-" + this.facultyID;
    }
}