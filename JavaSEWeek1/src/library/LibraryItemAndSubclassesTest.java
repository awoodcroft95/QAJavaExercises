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
        testBook = new Book(1, 1.0, "Book1", "JohnSmith");
        testJournal = new Journal(2, 2.0, "Journal1", "Steve Hawk", "Space");
        testMag = new Magazine(3, 3.0, "Mag1", "Empire", 23);
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