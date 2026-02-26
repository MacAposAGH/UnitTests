package agh.ics.oop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    Vector2d inside;
    Vector2d lowerLeft;
    Vector2d upperRight;
    Vector2d lowerRight;
    Vector2d upperLeft;
    Vector2d unitVector;

    @BeforeEach
    void setUp() {
        inside = new Vector2d(3, 3);
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(4, 4);
        lowerRight = new Vector2d(4, 0);
        upperLeft = new Vector2d(0, 4);
        unitVector = new Vector2d(1, 1);

    }

    @Test
    void getXTest() {
        assertEquals(0, lowerLeft.getX());
    }

    @Test
    void getYTest() {
        assertEquals(0, lowerLeft.getY());
    }

    @Test
    void toStrTest() {
        assertEquals("(0,0)", lowerLeft.toString());
    }

    @Test
    void precedesTest() {
        assertFalse(inside.precedes(lowerLeft));
        assertFalse(inside.precedes(lowerRight));
        assertTrue(inside.precedes(upperRight));
    }

    @Test
    void followsTest() {
        assertFalse(inside.follows(upperRight));
        assertFalse(inside.follows(upperLeft));
        assertTrue(inside.follows(lowerLeft));
    }

    @Test
    void addTest() {
        assertEquals(upperRight, inside.add(unitVector));
    }

    @Test
    void subtractTest() {
        assertEquals(inside, upperRight.subtract(unitVector));
    }

    @Test
    void lowerLeftTest() {
        assertEquals(inside, inside.lowerLeft(upperRight));
        assertNotEquals(inside, inside.lowerLeft(upperLeft));
        assertEquals(lowerLeft, inside.lowerLeft(lowerLeft));
    }

    @Test
    void upperRightTest() {
        assertEquals(inside, inside.upperRight(lowerLeft));
        assertNotEquals(inside, inside.upperRight(lowerRight));
        assertEquals(upperRight, inside.upperRight(upperRight));

    }

    @Test
    void oppositeTest() {
        assertEquals(new Vector2d(-3, -3), inside.opposite());
    }

    @Test
    void equalsTest() {
        Vector2d p1 = new Vector2d(4, 4);

        assertEquals(upperRight, upperRight);
        assertEquals(p1, upperRight);
        assertFalse(upperRight.equals(null));

        assertNotEquals(upperRight, lowerLeft);
        assertNotEquals(upperRight, lowerRight);
        assertEquals(upperRight, p1);
    }

    @Test
    void hashCodeTest() {
        Vector2d p1 = new Vector2d(3, 3);
        assertEquals(inside, p1);
        assertEquals(inside.hashCode(), p1.hashCode());
    }

    @Test
    void insideBoundaryTest() {
        assertFalse(inside.insideBoundary(lowerRight, lowerRight));
        assertFalse(inside.insideBoundary(lowerLeft, lowerLeft));
        assertFalse(inside.insideBoundary(upperLeft, lowerRight));
        assertFalse(inside.insideBoundary(lowerLeft, lowerRight));
        assertTrue(inside.insideBoundary(lowerLeft, upperRight));
    }
}
