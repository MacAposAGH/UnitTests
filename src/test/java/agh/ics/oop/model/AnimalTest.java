package agh.ics.oop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static agh.ics.oop.model.MapDirection.EAST;
import static agh.ics.oop.model.MapDirection.NORTH;
import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    Vector2d lowerLeft0;
    Vector2d lowerRight;
    Vector2d lowerLeft1;
    Vector2d upperLeft;
    Vector2d middle;
    Vector2d v0;
    Vector2d v1;
    Animal a0;
    Animal a1;

    Animal animalInLowerLeft0;
    Animal animalInLowerRight;
    Animal animalInLowerLeft1;
    Animal animalInUpperLeft;
    Animal animalInTheMiddle;

    @BeforeEach
    void setUp() {
        lowerLeft0 = new Vector2d(0, 0);
        lowerLeft1 = new Vector2d(1, 0);
        lowerRight = new Vector2d(4, 0);
        upperLeft = new Vector2d(0, 4);
        middle = new Vector2d(2, 2);

        v0 = new Vector2d(0, 0);
        v1 = new Vector2d(4, 4);
        a0 = new Animal(v0);
        a1 = new Animal(v1);

        animalInLowerLeft0 = new Animal(lowerLeft0);
        animalInLowerLeft1 = new Animal(lowerLeft1);
        animalInLowerRight = new Animal(lowerRight);
        animalInUpperLeft = new Animal(upperLeft);
        animalInTheMiddle = new Animal(middle);
    }

    //
//    @AfterEach
//    void tearDown() {
//    }
//
    @Test
    void getPosition() {
        assertEquals(new Vector2d(2, 2), new Animal().getPosition());
    }

    @Test
    void getOrientation() {
        assertEquals(MapDirection.NORTH, animalInLowerLeft0.getOrientation());
    }

    @Test
    void testToString() {
        assertEquals("(0,0) NORTH", animalInLowerLeft0.toString());
    }

    @Test
    void isAt() {
        assertTrue(animalInLowerLeft0.isAt(lowerLeft0));
        assertFalse(animalInLowerLeft0.isAt(lowerRight));
    }

    @Test
    void moveRightAndLeft() {
        animalInLowerLeft0.move(RIGHT);
        assertEquals(EAST, animalInLowerLeft0.getOrientation());
        animalInLowerLeft0.move(LEFT);
        assertEquals(NORTH, animalInLowerLeft0.getOrientation());
    }

    @Test
    void moveForward() {
//        1. position.add(to_add).getX() < 0 && ...
//        (0, 0) + (-1, 0) = (-1, 0) will be: (0, 0)
//        animalInLowerLeft0.move(LEFT);
//        animalInLowerLeft0.move(FORWARD);
//        assertEquals(lowerLeft0, animalInLowerLeft0.getPosition());
        a0.move(LEFT);
        a0.move(FORWARD);
        assertEquals(v0, a0.getPosition());

//        2. position.add(to_add).getX() >= 0 && position.add(to_add).getX() > 4 && ...
//        (4, 0) + (1, 0) = (5, 0) will be: (4, 0)
//        animalInLowerRight.move(RIGHT);
//        animalInLowerRight.move(FORWARD);
//        assertEquals(lowerRight, animalInLowerRight.getPosition());
        a1.move(RIGHT);
        a1.move(FORWARD);
        assertEquals(v1, a1.getPosition());

//        3. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() < 0 && ...
//        (1, 0) + (0, -1) = (1, -1) will be: (1, 0)
//        animalInLowerLeft1.move(RIGHT);
//        animalInLowerLeft1.move(RIGHT);
//        animalInLowerLeft1.move(FORWARD);
//        assertEquals(lowerLeft1, animalInLowerLeft1.getPosition());
        a0.move(LEFT);
        a0.move(FORWARD);
        assertEquals(v0, a0.getPosition());

//        4. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() >= 0 && position.add(to_add).getY() > 4
//        (0, 4) + (0, 1) = (0, 5) will be: (0, 4)
//        animalInUpperLeft.move(FORWARD);
//        assertEquals(upperLeft, animalInUpperLeft.getPosition());
        a1.move(LEFT);
        a1.move(FORWARD);
        assertEquals(v1, a1.getPosition());
//        5. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() >= 0 && position.add(to_add).getY() <= 4
//        (2, 2) + (0, 1) = (2, 3)

//        animalInTheMiddle.move(FORWARD);
//        assertEquals(new Vector2d(2, 3), animalInTheMiddle.getPosition());

        a0.move(LEFT);
        a0.move(FORWARD);
        assertEquals(new Vector2d(1, 0), a0.getPosition());
    }

    @Test
    void moveBackward() {
//        1. position.add(to_add).getX() < 0 && ...
//        (0, 0) - (1, 0) = (-1, 0) will be: (0, 0)
//        animalInLowerLeft0.move(RIGHT);
//        animalInLowerLeft0.move(BACKWARD);
//        assertEquals(lowerLeft0, animalInLowerLeft0.getPosition());
        a0.move(RIGHT);
        a0.move(BACKWARD);
        assertEquals(v0, a0.getPosition());

//        2. position.add(to_add).getX() >= 0 && position.add(to_add).getX() > 4 && ...
//        (4, 0) - (-1, 0) = (5, 0) will be: (4, 0)
//        animalInLowerRight.move(LEFT);
//        animalInLowerRight.move(BACKWARD);
//        assertEquals(lowerRight, animalInLowerRight.getPosition());
        a1.move(LEFT);
        a1.move(BACKWARD);
        assertEquals(v1, a1.getPosition());

//        3. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() < 0 && ...
//        (0, 0) - (0, 1) = (0, -1) will be: (0, 0)
//        animalInLowerLeft1.move(BACKWARD);
//        assertEquals(lowerLeft1, animalInLowerLeft1.getPosition());
        a0.move(LEFT);
        a0.move(BACKWARD);
        assertEquals(v0, a0.getPosition());

//        4. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() >= 0 && position.add(to_add).getY() > 4
//        (0, 4) - (0, -1) = (0, 5) will be: (0, 4)
//        animalInUpperLeft.move(RIGHT);
//        animalInUpperLeft.move(RIGHT);
//        animalInUpperLeft.move(BACKWARD);
//        assertEquals(upperLeft, animalInUpperLeft.getPosition());
        a1.move(LEFT);
        a1.move(BACKWARD);
        assertEquals(v1, a1.getPosition());

//        5. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() >= 0 && position.add(to_add).getY() <= 4
//        (2, 3) - (0, 1) = (1, 1)
        a0.move(LEFT);
        a0.move(BACKWARD);
        assertEquals(new Vector2d(1, 0), a0.getPosition());
    }
}