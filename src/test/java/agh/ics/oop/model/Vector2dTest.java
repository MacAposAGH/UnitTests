package agh.ics.oop.model;

import org.junit.jupiter.api.BeforeAll;
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

        assertTrue(p0.precedes(p1));
        assertTrue(p0.precedes(p2));
        assertTrue(p0.precedes(p3));
        assertTrue(p0.precedes(p0));
        assertFalse(p1.precedes(p0));
        assertFalse(p2.precedes(p3));
        assertFalse(p3.precedes(p2));
        assertFalse(p1.precedes(p2));
    }

    @Test
    void followsTest(){
        Vector2d p0 = new Vector2d(0, 0);
        Vector2d p1 = new Vector2d(10, 7);
        Vector2d p2 = new Vector2d(2, 7);
        Vector2d p3 = new Vector2d(10, 3);

        assertFalse(p0.follows(p1));
        assertFalse(p0.follows(p2));
        assertFalse(p0.follows(p3));
        assertFalse(p3.follows(p2));

        assertTrue(p0.follows(p0));
        assertTrue(p1.follows(p0));
        assertTrue(p2.follows(p0));
        assertTrue(p3.follows(p0));

    }

    @Test
    void addTest(){
        Vector2d p0 = new Vector2d(1, 2);
        Vector2d p1 = new Vector2d(3, 4);
        assertEquals(new Vector2d(4, 6), p0.add(p1));
    }

    @Test
    void subtractTest(){
        Vector2d p0 = new Vector2d(1, 2);
        Vector2d p1 = new Vector2d(3, 4);
        assertEquals(new Vector2d(2, 2), p1.subtract(p0));
    }

    @Test
    void upperLowerTest(){
        Vector2d p0 = new Vector2d(5, 6);
        Vector2d p01 = new Vector2d(5, 6);
        assertEquals(p0, p0.lowerLeft(p01));
    }

}
