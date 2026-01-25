package agh.ics.oop.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static agh.ics.oop.model.MapDirection.*;
import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {
    Vector2d vector2d;
    Animal animal;

    @BeforeEach
    void setUp() {
        vector2d = new Vector2d(2, 2);
        animal = new Animal(vector2d);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPosition() {
        assertEquals(new Vector2d(2, 2), animal.getPosition());
    }

    @Test
    void getOrientation() {
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void testToString() {
    }

    @Test
    void isAt() {
    }

    @Test
    void move() {


        animal.move(RIGHT);
        assertEquals(EAST, animal.getOrientation());
        animal.move(LEFT);
        assertEquals(NORTH, animal.getOrientation());
        animal.move(FORWARD);

//        x <= 4 - true
//        x <= 4 - false
//        x >= 0 - true
//        x >= 0 - false

//        y <= 4 - true
//        y <= 4 - false
//        y >= 0 - true
//        y >= 0 - false

        assertEquals(new Vector2d(2,3), animal.getPosition());
        for (int i = 0; i < 2; i++) {
            animal.move(FORWARD);
            animal.move(RIGHT);
        }
        assertEquals(new Vector2d(2,4), animal.getPosition());

    }
}