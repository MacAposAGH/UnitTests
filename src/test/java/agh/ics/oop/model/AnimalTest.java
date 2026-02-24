package agh.ics.oop.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static agh.ics.oop.model.MapDirection.*;
import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {
//    Vector2d vector2d;
//    Animal animal;
//
//    @BeforeEach
//    void setUp() {
//        vector2d = new Vector2d(2, 2);
//        animal = new Animal(vector2d);
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void getPosition() {
//        assertEquals(new Vector2d(2, 2), animal.getPosition());
//    }
//
//    @Test
//    void getOrientation() {
//        assertEquals(MapDirection.NORTH, animal.getOrientation());
//    }
//
//    @Test
//    void testToString() {
//    }
//
//    @Test
//    void isAt() {
//    }

    @Test
    void moveLeftAndRight() {
        Vector2d vector2d = new Vector2d(0, 0);
        Animal animal0 = new Animal(vector2d);

        animal0.move(LEFT);
        assertEquals(WEST, animal0.getOrientation());
        animal0.move(RIGHT);
        assertEquals(NORTH, animal0.getOrientation());
    }

    @Test
    void moveForward() {
        Vector2d vector2d = new Vector2d(0, 0);
        Animal animal0 = new Animal(vector2d);

        animal0.move(RIGHT);
        assertEquals(EAST, animal0.getOrientation());
        animal0.move(LEFT);
        assertEquals(NORTH, animal0.getOrientation());

//        1. position.add(to_add).getX() < 0 && ...
//        (0, 0) + (-1, 0) = (-1, 0) will be: (0, 0)
        animal0.move(LEFT);
        animal0.move(FORWARD);
        assertEquals(vector2d, animal0.getPosition());

//        2. position.add(to_add).getX() >= 0 && position.add(to_add).getX() > 4 && ...
//        (4, 0) + (1, 0) = (5, 0) will be: (4, 0)
        Vector2d vector2d1 = new Vector2d(4, 0);
        Animal animal1 = new Animal(vector2d1);
        animal1.move(RIGHT);
        animal1.move(FORWARD);
        assertEquals(vector2d1, animal1.getPosition());

//        3. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() < 0 && ...
//        (1, 0) + (0, -1) = (1, -1) will be: (1, 0)
        Vector2d vector2d2 = new Vector2d(1, 0);
        Animal animal2 = new Animal(vector2d2);
        animal2.move(RIGHT);
        animal2.move(RIGHT);
        animal2.move(FORWARD);
        assertEquals(vector2d2, animal2.getPosition());

//        4. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() >= 0 && position.add(to_add).getY() > 4
//        (1, 4) + (0, 1) = (1, 5) will be: (1, 4)
        Vector2d vector2d3 = new Vector2d(1, 4);
        Animal animal3 = new Animal(vector2d3);
        animal3.move(FORWARD);
        assertEquals(vector2d3, animal3.getPosition());

//        5. position.add(to_add).getX() >= 0 && position.add(to_add).getX() <= 4 && position.add(to_add).getY() >= 0 && position.add(to_add).getY() <= 4
//        (1, 0) + (0, 1) = (1, 1)
        Vector2d vector2d4 = new Vector2d(1, 0);
        Animal animal4 = new Animal(vector2d4);
        animal4.move(FORWARD);
        assertEquals( new Vector2d(1, 1), animal4.getPosition());
    }

    @Test
    void moveBackward() {

    }
}