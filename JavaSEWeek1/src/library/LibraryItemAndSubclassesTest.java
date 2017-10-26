package library;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book(1, 1.0, "Book1", "JohnSmith");
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
}