package library;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Book testBook;
    Journal testJournal;
    Magazine testMag;

    @BeforeEach
    void setUp() {
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
}