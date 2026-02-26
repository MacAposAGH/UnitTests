package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static agh.ics.oop.OptionsParser.zamiana;
import static agh.ics.oop.model.MapDirection.*;
import static org.junit.jupiter.api.Assertions.*;


// niepoprawne argumenty
// puste argumenty
// 1 zwierzak, więcej zwierzaków
public class SimulationTest {
    Vector2d lowerLeft;
    Vector2d lowerRight;
    Vector2d upperRight;
    Vector2d upperLeft;

    @BeforeEach
    void setUp() {
        lowerLeft = new Vector2d(0, 0);
        lowerRight = new Vector2d(4, 0);
        upperLeft = new Vector2d(0, 4);
        upperRight = new Vector2d(4, 4);
    }

    @Test
    void runTestV2() {
        String[] moves = {
                "b", "b", "l", "r",
                "l", "f", "r", "f",
                "f", "f", "f", "f",
                "l", "l", "r", "l",
                "f", "b", "f", "f",
                "l", "b", "r", "f",
                "b", "l", "b", "r",
                "l", "r", "r", "l",
                "b", "l", "b", "r"
        };
        List<Vector2d> startingPositions = List.of(lowerLeft, lowerLeft, upperRight, lowerLeft);
        List<Vector2d> finalPositions = List.of(
                new Vector2d(0, 0),
                new Vector2d(2, 2),
                new Vector2d(4, 4),
                new Vector2d(2, 2)
        );
        List<MapDirection> finalOrientations = List.of(NORTH, SOUTH, WEST, EAST);
        List<Animal> finalAnimals = startingPositions.stream().map(Animal::new).toList();

        Simulation simulation = new Simulation(startingPositions, zamiana(moves));
        List<Animal> animals = simulation.getAnimalList();

        assertIterableEquals(finalAnimals, animals);
        simulation.run();

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            MapDirection orientation = animal.getOrientation();

            MapDirection finalOrientation = finalOrientations.get(i);
            Vector2d finalPosition = finalPositions.get(i);

            assertTrue(animal.isAt(finalPosition));
            assertEquals(finalOrientation, orientation);
            assertEquals(finalOrientation.toString(finalOrientation), orientation.toString(orientation));
            assertEquals(finalPosition, animal.getPosition());
            assertEquals(finalPosition.toString() + " " + finalOrientation, animal.toString());
        }

        Animal animalInLowerLeft = animals.getFirst();
        Animal firstAnimalInTheMiddle = animals.get(1);
        Animal animalInUpperRight = animals.get(2);
        Animal secondAnimalInTheMiddle = animals.getLast();
        secondAnimalInTheMiddle.move(MoveDirection.RIGHT);

        Vector2d upperRight = animalInUpperRight.getPosition();
        Vector2d lowerLeft = animalInLowerLeft.getPosition();
        Vector2d middle = secondAnimalInTheMiddle.getPosition();

        assertNotEquals(animalInLowerLeft, animalInUpperRight);
        assertNotEquals(new Animal(), animalInUpperRight);
        assertNotEquals(animalInUpperRight, animals);
        assertEquals(firstAnimalInTheMiddle, secondAnimalInTheMiddle);
        assertEquals(firstAnimalInTheMiddle.hashCode(), secondAnimalInTheMiddle.hashCode());

        assertEquals(upperRight, upperRight);
        assertFalse(upperRight.equals(null));
        assertNotEquals(upperRight, lowerLeft);
        assertNotEquals(upperRight, lowerRight);

        assertFalse(middle.precedes(lowerLeft));
        assertFalse(middle.precedes(lowerRight));
        assertTrue(middle.precedes(upperRight));

        assertFalse(middle.follows(upperRight));
        assertFalse(middle.follows(upperLeft));
        assertTrue(middle.follows(lowerLeft));

        assertEquals(middle, middle.upperRight(lowerLeft));
        assertNotEquals(middle, middle.upperRight(lowerRight));
        assertEquals(upperRight, middle.upperRight(upperRight));

        assertEquals(middle, middle.lowerLeft(upperRight));
        assertNotEquals(middle, middle.lowerLeft(upperLeft));
        assertEquals(lowerLeft, middle.lowerLeft(lowerLeft));

        assertEquals(new Vector2d(-4, -4), upperRight.opposite());

        assertFalse(middle.insideBoundary(lowerRight, lowerRight));
        assertFalse(middle.insideBoundary(lowerLeft, lowerLeft));
        assertFalse(middle.insideBoundary(upperLeft, lowerRight));
        assertFalse(middle.insideBoundary(lowerLeft, lowerRight));
        assertTrue(middle.insideBoundary(lowerLeft, upperRight));
    }
}
