package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void getXTest() {
        Vector2d v = new Vector2d(0, 0);
        assertEquals(0, v.getX());
    }

    @Test
    void getYTest() {
        Vector2d v = new Vector2d(0, 0);
        assertEquals(0, v.getY());
    }

    @Test
    void toStrTest() {
        Vector2d v = new Vector2d(0, 0);
        assertEquals("(0,0)", v.toString());
    }

    @Test
    void precedesTest() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 7);
        Vector2d p2 = new Vector2d(2, 7);
        Vector2d p3 = new Vector2d(10, 3);

//        x > other.x && y > other.y -> false
        assertFalse(p1.precedes(p0));
//        x <= other.x && y > other.y -> false
        assertFalse(p2.precedes(p3));
////        x > other.x && y <= other.y -> false
//        assertFalse(p1.precedes(p2));
//        x <= other.x && y <= other.y -> true
        assertTrue(p0.precedes(p1));
    }

    @Test
    void followsTest() {
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 7);
        Vector2d p2 = new Vector2d(2, 7);
        Vector2d p3 = new Vector2d(10, 3);

//        x < other.x && y < other.y -> false
        assertFalse(p0.follows(p1));
//        x >= other.x && y < other.y -> false
        assertFalse(p3.follows(p2));
//        x >= other.x && y >= other.y -> true
        assertTrue(p1.follows(p0));
    }

    @Test
    void addTest() {
        Vector2d p0 = new Vector2d(1, 2);
        Vector2d p1 = new Vector2d(3, 4);
        assertEquals(new Vector2d(4, 6), p0.add(p1));
    }

    @Test
    void subtractTest() {
        Vector2d p0 = new Vector2d(1, 2);
        Vector2d p1 = new Vector2d(3, 4);
        assertEquals(new Vector2d(2, 2), p1.subtract(p0));
    }

    @Test
    void upperRightTest() {
        Vector2d p0 = new Vector2d(1, 1);
        Vector2d p1 = new Vector2d(0, 0);
        Vector2d p2 = new Vector2d(2, 0);
        Vector2d p3 = new Vector2d(2, 1);
        Vector2d p4 = new Vector2d(2, 2);

        assertEquals(p0, p0.upperRight(p1));
        assertEquals(p3, p0.upperRight(p2));
        assertEquals(p4, p0.upperRight(p4));
    }

    @Test
    void lowerLeftTest() {
        Vector2d p0 = new Vector2d(1, 1);
        Vector2d p1 = new Vector2d(2, 2);

        Vector2d p2 = new Vector2d(0, 2);

        Vector2d p3 = new Vector2d(0, 1);
        Vector2d p4 = new Vector2d(0, 0);

        assertEquals(p0, p0.lowerLeft(p1));
        assertEquals(p3, p0.lowerLeft(p2));
        assertEquals(p4, p0.lowerLeft(p4));
    }

    @Test
    void oppositeTest() {
        Vector2d p0 = new Vector2d(1, 1);
        assertEquals(new Vector2d(-1, -1), p0.opposite());
    }

    @Test
    void equalsTest() {
        Vector2d p0 = new Vector2d(1, 1);
        Vector2d p1 = new Vector2d(0, 0);
        Vector2d p2 = new Vector2d(1, 0);
        Vector2d p3 = new Vector2d(1, 1);

        assertEquals(p0, p0);
        assertFalse(p0.equals(null));
//        x != vector2d.x && y == vector2d.y -> false
        assertNotEquals(p0, p1);
//        x == vector2d.x && y != vector2d.y -> false
        assertNotEquals(p0, p2);
//        x == vector2d.x && y == vector2d.y -> true
        assertEquals(p0, p3);
    }

    @Test
    void insideBoundaryTest() {
        Vector2d p0 = new Vector2d(1, 1);
        Vector2d start1 = new Vector2d(2, 2);
        Vector2d start2 = new Vector2d(0, 2);
        Vector2d start3 = new Vector2d(0, 0);

        Vector2d finish1 = new Vector2d(0, 2);
        Vector2d finish2 = new Vector2d(2, 0);
        Vector2d finish3 = new Vector2d(2, 2);

//        false && ...                  -> false
        assertFalse(p0.insideBoundary(start1, finish1));
//        true && false && ...          -> false
        assertFalse(p0.insideBoundary(start2, finish1));
//        true && true && false && ...  -> false
        assertFalse(p0.insideBoundary(start2, finish2));
//        true && true && true && false -> false
        assertFalse(p0.insideBoundary(start3, finish2));
//        true && true && true && true  -> true
        assertTrue(p0.insideBoundary(start3, finish3));
    }
}
