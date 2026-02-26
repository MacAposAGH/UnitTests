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
    void setUp(){
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
//        Vector2d p1 = new Vector2d(10, 7);
//        Vector2d p2 = new Vector2d(2, 7);
//        Vector2d p3 = new Vector2d(10, 3);

//        x > other.x && y > other.y -> false
        assertFalse(inside.precedes(lowerLeft));
//        x <= other.x && y > other.y -> false
        assertFalse(inside.precedes(lowerRight));
////        x > other.x && y <= other.y -> false
//        assertFalse(p1.precedes(p2));
//        x <= other.x && y <= other.y -> true
        assertTrue(inside.precedes(upperRight));
    }

    @Test
    void followsTest() {
//        x < other.x && y < other.y -> false
        assertFalse(inside.follows(upperRight));
//        x >= other.x && y < other.y -> false
        assertFalse(inside.follows(upperLeft));
//        x >= other.x && y >= other.y -> true
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

//    @Test
//    void upperRightTest() {
//        Vector2d p0 = new Vector2d(1, 1);
//        Vector2d p1 = new Vector2d(0, 0);
//        Vector2d p2 = new Vector2d(2, 0);
//        Vector2d p3 = new Vector2d(2, 1);
//        Vector2d p4 = new Vector2d(2, 2);
//
//        assertEquals(p0, p0.upperRight(p1));
//        assertEquals(p3, p0.upperRight(p2));
//        assertEquals(p4, p0.upperRight(p4));
//    }
//
//    @Test
//    void lowerLeftTest() {
//        Vector2d p0 = new Vector2d(1, 1);
//        Vector2d p1 = new Vector2d(2, 2);
//
//        Vector2d p2 = new Vector2d(0, 2);
//
//        Vector2d p3 = new Vector2d(0, 1);
//        Vector2d p4 = new Vector2d(0, 0);
//
//        assertEquals(p0, p0.lowerLeft(p1));
//        assertEquals(p3, p0.lowerLeft(p2));
//        assertEquals(p4, p0.lowerLeft(p4));
//    }

    @Test
    void LowerLeftUpperRightTest() {
        assertEquals(inside, inside.upperRight(lowerLeft));
        assertNotEquals(inside, inside.upperRight(lowerRight));
        assertEquals(upperRight, inside.upperRight(upperRight));

        assertEquals(inside, inside.lowerLeft(upperRight));
        assertNotEquals(inside, inside.lowerLeft(upperLeft));
        assertEquals(lowerLeft, inside.lowerLeft(lowerLeft));

}

    @Test
    void oppositeTest() {
        assertEquals(new Vector2d(-1, -1), unitVector.opposite());
    }

    @Test
    void equalsTest() {
        Vector2d p0 = new Vector2d(1, 0);
        Vector2d p1 = new Vector2d(1, 1);

//        Reflexive
        assertEquals(unitVector, unitVector);
//        Symmetric
        assertEquals(unitVector, p1);
//        assertEquals(p1, p7);

        assertFalse(unitVector.equals(null));

//        x != vector2d.x && y == vector2d.y -> false
        assertNotEquals(unitVector, lowerLeft);
//        x == vector2d.x && y != vector2d.y -> false
        assertNotEquals(unitVector, p0);
//        x == vector2d.x && y == vector2d.y -> true
        assertEquals(unitVector, p1);
    }

//    @Test
//    void insideBoundaryTest() {
//        Vector2d p0 = new Vector2d(1, 1);
//        Vector2d start1 = new Vector2d(2, 2);
//        Vector2d start2 = new Vector2d(0, 2);
//        Vector2d start3 = new Vector2d(0, 0);
//
//        Vector2d finish1 = new Vector2d(0, 2);
//        Vector2d finish2 = new Vector2d(2, 0);
//        Vector2d finish3 = new Vector2d(2, 2);
//
////        false && ...                  -> false
//        assertFalse(p0.insideBoundary(start1, finish1));
////        true && false && ...          -> false
//        assertFalse(p0.insideBoundary(start2, finish1));
////        true && true && false && ...  -> false
//        assertFalse(p0.insideBoundary(start2, finish2));
////        true && true && true && false -> false
//        assertFalse(p0.insideBoundary(start3, finish2));
////        true && true && true && true  -> true
//        assertTrue(p0.insideBoundary(start3, finish3));
//    }
    @Test
    void insideBoundaryTestV2() {
//        false && ...                  -> false
        assertFalse(inside.insideBoundary(upperRight, upperLeft));
//        true && false && ...          -> false
        assertFalse(inside.insideBoundary(upperLeft, upperLeft));
//        true && true && false && ...  -> false
        assertFalse(inside.insideBoundary(upperLeft, unitVector));
//        true && true && true && false -> false
        assertFalse(inside.insideBoundary(lowerLeft, unitVector));
//        true && true && true && true  -> true
        assertTrue(inside.insideBoundary(lowerLeft, upperRight));
    }
}
