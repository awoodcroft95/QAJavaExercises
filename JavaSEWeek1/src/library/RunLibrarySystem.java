package library;

import java.util.List;
import java.util.Scanner;

public class RunLibrarySystem {



    public static void main(String[] args) {
        LibrarySystem manchesterLibrary = new LibrarySystem();
        Scanner sc = new Scanner(System.in);

        Book testBook = new Book("Book1", 1, 1.0, "JohnSmith");
        Journal testJournal = new Journal("Journal1", 2, 2.0, "Steve Hawk", "Space");
        Magazine testMag = new Magazine("Mag1", 3, 3.0, "Empire", 23);

        manchesterLibrary.addNewItem("Book1", 1.0, "John Smith");
        manchesterLibrary.addNewUser("John Smith", 123);

        boolean programRunning = true;

        while (programRunning) {
            System.out.println("Possible Commands: 1 : Show Item List, 2 : Show User List");
            System.out.println("3 : Add User, 4 : Add Item");
            System.out.println("Enter Library System command:");
            String command = sc.nextLine();
            if (command.equals("1")) {
                List<LibraryItem> list = manchesterLibrary.getLibraryItemList();
                for (LibraryItem item : list) {
                    System.out.println(item.returnItemDetails());
                }
            } else if (command.equals("2")) {
                List<User> userList = manchesterLibrary.getUserList();
                for (User user : userList) {
                    System.out.println(user.toString());
                }
            } else if (command.equals("3")) {
                System.out.println("Please select the type of user you wish to add.");
                System.out.println("1 : Regular User, 2 : Student, 3 : Faculty");
                String userCommand = sc.nextLine();
                if (userCommand.equals("1")) {
                    System.out.println("Enter the user information in the following order:");
                    System.out.println("Name, Phone Number.     Press 'Enter/Return' after each piece of information.");
                    String userDataName = sc.nextLine();
                    int userDataPhoneNoInt = 0;
                    userDataPhoneNoInt = handleNumericalInput(sc);
                    manchesterLibrary.addNewUser(userDataName, userDataPhoneNoInt);
                } else if (userCommand.equals("2")) {
                    System.out.println("Enter the user information in the following order:");
                    System.out.println("Name, Phone Number, Student ID     Press 'Enter/Return' after each piece of information.");
                    String userDataName = sc.nextLine();
                    int userDataPhoneNoInt = 0;
                    userDataPhoneNoInt = handleNumericalInput(sc);
                    int userStudetnID = 0;
                    userStudetnID = handleNumericalInput(sc);
                    manchesterLibrary.addNewUser(userDataName, userDataPhoneNoInt, userStudetnID, "Student");
                } else if (userCommand.equals("3")){
                    System.out.println("Enter the user information in the following order:");
                    System.out.println("Name, Phone Number, Faculty ID     Press 'Enter/Return' after each piece of information.");
                    String userDataName = sc.nextLine();
                    int userDataPhoneNoInt = 0;
                    userDataPhoneNoInt = handleNumericalInput(sc);
                    int userFacultyID = 0;
                    userFacultyID = handleNumericalInput(sc);
                    manchesterLibrary.addNewUser(userDataName, userDataPhoneNoInt, userFacultyID, "Faculty");
                }
                System.out.println(manchesterLibrary.getUserList().get(manchesterLibrary.getUserList().size() - 1));
            } else if (command.equals("Exit")) {
                programRunning = false;
            } else {
                System.out.println("Please Enter a Valid Command.");
            }
        }
    }

    public static int handleNumericalInput(Scanner sc) {
        boolean tryInput = true;
        int userInput = 0;
        while (tryInput) {
            String userStringInput = sc.nextLine();
            try {
                userInput = Integer.parseInt(userStringInput);
                tryInput = false;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Tried to convert String to Integer, non numeric characters were probably contained in the String causing an Error");
                System.out.println("Please enter only numbers next time.");
                tryInput = true;
            }
        }
        return userInput;
    }
}

