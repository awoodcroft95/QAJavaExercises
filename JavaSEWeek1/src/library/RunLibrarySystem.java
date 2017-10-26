package library;

import java.util.List;
import java.util.Scanner;

public class RunLibrarySystem {



    public static void main(String[] args){
        LibrarySystem manchesterLibrary = new LibrarySystem();
        Scanner sc = new Scanner(System.in);

        Book testBook = new Book("Book1", 1, 1.0, "JohnSmith");
        Journal testJournal = new Journal("Journal1",2, 2.0,"Steve Hawk", "Space");
        Magazine testMag = new Magazine("Mag1",3, 3.0, "Empire", 23);

        manchesterLibrary.addNewItem(testBook);

        while(true){
            System.out.println("Possible Commands: 1 : Show Item List, 2 : Show User List");
            System.out.println("Enter Library System command:");
            String command = sc.nextLine();
            if (command.equals("1")){
                List<LibraryItem> list = manchesterLibrary.getLibraryItemList();
                for (LibraryItem item : list){
                    System.out.println(item.returnItemDetails());
                }
            }
            if (command.equals("2")){
                List<User> userList = manchesterLibrary.getUserList();
                for (User user : userList){
                    System.out.println(user.toString());
                }
            }
        }
    }

}
