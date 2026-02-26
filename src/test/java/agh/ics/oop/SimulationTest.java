package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
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
    //    Vector2d inside;
    Vector2d lowerLeft;
    Vector2d upperRight;
    Vector2d lowerRight;
    Vector2d upperLeft;
    Vector2d unitVector;


    @BeforeEach
    void setUp() {
//        inside = new Vector2d(3, 3);
        lowerLeft = new Vector2d(0, 0);
        upperRight = new Vector2d(4, 4);
        lowerRight = new Vector2d(4, 0);
        upperLeft = new Vector2d(0, 4);
        unitVector = new Vector2d(1, 1);

    }

    @Test
    void runTestV2() {
        String[] moves = {
                "b", "b", "l", "r",
                "l", "f", "r", "f",
                "f", "f", "f", "f",
                "l", "r", "r", "l",
                "f", "f", "f", "f",
                "l", "f", "r", "f",
                "b", "l", "b", "r",
                "l", "l", "r", "l",
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

        Animal animalInLowerLeft  = animals.getFirst();
        Animal animalInUpperRight = animals.get(2);
        Animal animalInside = animals.getLast();

        Vector2d upperRight = animalInUpperRight.getPosition();
        Vector2d lowerLeft = animalInLowerLeft.getPosition();
        Vector2d inside = animalInside.getPosition();

        assertNotEquals(animalInLowerLeft, animalInUpperRight);
        assertNotEquals(animalInUpperRight, animals);

        assertEquals(upperRight, upperRight);
        assertNotEquals(upperRight, lowerLeft);

        assertFalse(inside.precedes(lowerLeft));
        assertFalse(inside.precedes(lowerRight));
        assertTrue(inside.precedes(upperRight));

        assertFalse(inside.follows(upperRight));
        assertFalse(inside.follows(upperLeft));
        assertTrue(inside.follows(lowerLeft));

        assertEquals(inside, inside.upperRight(lowerLeft));
        assertNotEquals(inside, inside.upperRight(lowerRight));
        assertEquals(upperRight, inside.upperRight(upperRight));

        assertEquals(inside, inside.lowerLeft(upperRight));
        assertNotEquals(inside, inside.lowerLeft(upperLeft));
        assertEquals(lowerLeft, inside.lowerLeft(lowerLeft));

        assertFalse(inside.insideBoundary(lowerRight, lowerRight));
        assertFalse(inside.insideBoundary(lowerLeft, lowerLeft));
        assertFalse(inside.insideBoundary(upperLeft, lowerRight));
        assertFalse(inside.insideBoundary(lowerLeft, lowerRight));
        assertTrue(inside.insideBoundary(lowerLeft, upperRight));
    }

}
