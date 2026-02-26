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
//


    Vector2d lowerLeft;
    Vector2d upperRight;
    Vector2d inside;

    @BeforeEach
    void setUp() {
        lowerLeft = new Vector2d(0, 0);
        inside = new Vector2d(3, 3);
        upperRight = new Vector2d(4, 4);
    }

    @Test
    void runTestV2() {
        String[] moves = {
                "l",
                "l", "r",
                "f", "f",
                "l", "r",
                "f", "f",

                "l", "r",
                "b", "b",
                "l", "r",
                "b", "b",
                "f", "r",
                "r", "b"
        };

        List<Vector2d> startingPositions = List.of(upperRight, lowerLeft);

        List<Vector2d> finalPositions = List.of(
                new Vector2d(4, 3),
                new Vector2d(0, 1)
        );
        List<MapDirection> finalOrientations = List.of(NORTH, EAST);
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

        Animal animalInUpperRight = animals.getFirst();
        Animal animalInLowerLeft = animals.get(1);

        Vector2d upperRight = animalInUpperRight.getPosition();
        Vector2d lowerLeft = animalInLowerLeft.getPosition();

        assertNotEquals(new Animal(), animalInLowerLeft);
        assertNotEquals(animalInUpperRight, animals);

        assertEquals(upperRight, upperRight);
        assertNotEquals(upperRight, lowerLeft);

    }

    @Test
    void runTestV3() {
        String[] moves = {
                "r",
                "l", "r",
                "f", "f",
                "l", "r",
                "f", "f",
        };
        List<Vector2d> startingPosition = List.of(inside, inside);
        Vector2d finalPosition = new Vector2d(2, 2);
        List<Vector2d> finalPositions = List.of(finalPosition, finalPosition);
        Simulation simulation = new Simulation(startingPosition, zamiana(moves));
        simulation.run();

        List<Animal> animals = simulation.getAnimalList();
        List<MapDirection> finalOrientations = List.of(WEST, SOUTH);


        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            MapDirection orientation = animal.getOrientation();
            MapDirection finalOrientation = finalOrientations.get(i);

            assertTrue(animal.isAt(finalPosition));
            assertEquals(finalOrientation, orientation);
            assertEquals(finalOrientation.toString(finalOrientation), orientation.toString(orientation));
            assertEquals(finalPosition, animal.getPosition());
        }
    }
}
