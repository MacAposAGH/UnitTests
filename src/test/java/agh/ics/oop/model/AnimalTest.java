package agh.ics.oop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    Vector2d lowerLeft;
    Vector2d upperRight;
    Animal animalInLowerLeft;
    Animal animalInUpperRight;

    @BeforeEach
    void setUp() {
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(4, 4);
        animalInLowerLeft = new Animal(lowerLeft);
        animalInUpperRight = new Animal(upperRight);
    }

    @Test
    void getPosition() {
        assertEquals(new Vector2d(2, 2), new Animal().getPosition());
    }

    @Test
    void getOrientation() {
        assertEquals(MapDirection.NORTH, animalInLowerLeft.getOrientation());
    }

    @Test
    void testToString() {
        assertEquals("(0,0) NORTH", animalInLowerLeft.toString());
    }

    @Test
    void isAt() {
        assertTrue(animalInLowerLeft.isAt(lowerLeft));
        assertFalse(animalInLowerLeft.isAt(upperRight));
    }

    @Test
    void runTest() {
        animalInUpperRight.move(LEFT);
        for (MoveDirection moveDirection : List.of(FORWARD, FORWARD, BACKWARD, BACKWARD)) {
            animalInLowerLeft.move(LEFT);
            animalInUpperRight.move(RIGHT);
            animalInLowerLeft.move(moveDirection);
            animalInUpperRight.move(moveDirection);
            assertEquals(lowerLeft, animalInLowerLeft.getPosition());
            assertEquals(upperRight, animalInUpperRight.getPosition());
        }
        animalInLowerLeft.move(FORWARD);
        assertEquals(new Vector2d(0, 1), animalInLowerLeft.getPosition());

        animalInUpperRight.move(RIGHT);
        animalInUpperRight.move(BACKWARD);
        assertEquals(new Vector2d(4, 3), animalInUpperRight.getPosition());
    }
}