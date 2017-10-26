package library;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySystemTest {

    Book testBook;
    Journal testJournal;
    Magazine testMag;
    LibrarySystem testSystem;

    @BeforeEach
    void setUp() {
        testSystem = new LibrarySystem();
        testBook = new Book("Book1", 1, 1.0, "JohnSmith");
        testJournal = new Journal("Journal1",2, 2.0,"Steve Hawk", "Space");
        testMag = new Magazine("Mag1",3, 3.0, "Empire", 23);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void returnBookDetails() {
        String result = testBook.returnBookDetails();
        assertEquals("Book1 JohnSmith ID:1 £1.0", result);
    }

    @Test
    void returnItemDetails() {
        String result = testBook.returnItemDetails();
        assertEquals("Book1 ID:1 £1.0", result);
    }

    @Test
    void getAuthorName() {
        String result = testBook.getAuthorName();
        assertEquals("JohnSmith", result);
    }

    @Test
    void returnBookDetailsJournal() {
        String result = testJournal.returnBookDetails();
        assertEquals("Journal1 Steve Hawk ID:2 £2.0 Topic:Space", result);
    }

    @Test
    void returnBookDetailsMag() {
        String result = testMag.returnBookDetails();
        assertEquals("Mag1 Empire ID:3 £3.0 IssueNo:23", result);
    }

    @Test
    void addLibraryItemToList() {
        testSystem.addNewItem(1.0, "Book1", "JohnSmith");
        int result = testSystem.getItemListSize();
        assertEquals(1, result);
        String toStringResult = testSystem.getLibraryItemList().get(0).toString();
        assertEquals("library.Book-Book1-1-1.0-JohnSmith", toStringResult);
    }

    @Test
    void addNewUser(){
        testSystem.addNewUser("John Smith", 123);
        int result = testSystem.getUserListSize();
        assertEquals(1, result);
        String toStringResult = testSystem.getUserList().get(0).toString();
        assertEquals("John Smith-1-123", toStringResult);
    }
}