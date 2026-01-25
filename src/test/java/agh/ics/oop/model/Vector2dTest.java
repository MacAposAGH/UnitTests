package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {


    @Test
    void precedesTest() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 7);
        Vector2d p2 = new Vector2d(2, 7);
        Vector2d p3 = new Vector2d(10, 3);

        assertTrue(p0.precedes(p1));
        assertTrue(p0.precedes(p2));
        assertTrue(p0.precedes(p3));
        assertTrue(p0.precedes(p0));
        assertFalse(p1.precedes(p0));
        assertFalse(p2.precedes(p3));
        assertFalse(p3.precedes(p2));
        assertFalse(p1.precedes(p2));

    }


}
