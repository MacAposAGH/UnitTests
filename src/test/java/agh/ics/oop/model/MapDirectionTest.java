package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.model.MapDirection.EAST;
import static agh.ics.oop.model.MapDirection.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    void toStr() {
        MapDirection east = WEST;
        assertEquals("Wschód", east.toString(EAST));
        assertEquals("Zachód", east.toString(WEST));
        assertEquals("Północ", east.toString(MapDirection.NORTH));
        assertEquals("Południe", east.toString(MapDirection.SOUTH));
    }

    @Test
    void next() {
        assertEquals(EAST, MapDirection.next(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.next(EAST));
        assertEquals(WEST, MapDirection.next(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.next(WEST));
    }

    @Test
    void previous() {
        assertEquals(MapDirection.NORTH, MapDirection.previous(EAST));
        assertEquals(EAST, MapDirection.previous(MapDirection.SOUTH));
        assertEquals(MapDirection.SOUTH, MapDirection.previous(WEST));
        assertEquals(WEST, MapDirection.previous(MapDirection.NORTH));
    }

    @Test
    void toUnitVector() {
        assertEquals(new Vector2d(1, 0), MapDirection.toUnitVector(EAST));
        assertEquals(new Vector2d(-1, 0), MapDirection.toUnitVector(WEST));
        assertEquals(new Vector2d(0, 1), MapDirection.toUnitVector(MapDirection.NORTH));
        assertEquals(new Vector2d(0, -1), MapDirection.toUnitVector(MapDirection.SOUTH));
    }

}
