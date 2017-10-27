package intermediateexercises;

import static org.junit.jupiter.api.Assertions.*;

class IntermediateExercisesTest {

    Person a;
    Person b;
    Person c;
    PersonManager m;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        a = new Person("John", 32, "manager");
        b = new Person("Susan", 56, "accountant");
        c = new Person("Anthony", 22, "consultant");
        m = new PersonManager();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void uniqueSum() {
        int result = IntermediateExercises.uniqueSum(1,2,3);
        assertEquals(6, result);
    }

    @org.junit.jupiter.api.Test
    void tooHot() {
        boolean result = IntermediateExercises.tooHot(90, true);
        assertEquals(true, result);
    }

    @org.junit.jupiter.api.Test
    void peopleTask() {
        m.addToList(a);
        m.addToList(b);
        m.addToList(c);

        String result = m.personSearch("Anthony");
        assertEquals("Anthony has been found in the given list.", result);
    }
}