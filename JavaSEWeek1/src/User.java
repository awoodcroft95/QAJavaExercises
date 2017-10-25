import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String userName;
    private int phoneNo;
    private List<LibraryItem> booksRented = new ArrayList<LibraryItem>();

}

class Student extends User {

}

class Faculty extends User {

}