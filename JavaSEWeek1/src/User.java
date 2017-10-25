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

}

class Student extends User {

    private int studentID;

    public Student(int userID, String userName, int phoneNo, int studentID){
        super(userID, userName, phoneNo);
        this.studentID = studentID;
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
}