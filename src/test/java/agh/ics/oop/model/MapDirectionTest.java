package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test
    void toStr() {
        MapDirection east = MapDirection.WEST;
        assertEquals("Wschód", east.toString(MapDirection.EAST));
        assertEquals("Zachód", east.toString(MapDirection.WEST));
        assertEquals("Północ", east.toString(MapDirection.NORTH));
        assertEquals("Południe", east.toString(MapDirection.SOUTH));
    }

    @Test
    void next() {
        assertEquals(MapDirection.EAST, MapDirection.next(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.next(MapDirection.EAST));
        assertEquals(MapDirection.WEST, MapDirection.next(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.next(MapDirection.WEST));
    }

    @Test
    void previous() {
        assertEquals(MapDirection.NORTH, MapDirection.previous(MapDirection.EAST));
        assertEquals(MapDirection.EAST, MapDirection.previous(MapDirection.SOUTH));
        assertEquals(MapDirection.SOUTH, MapDirection.previous(MapDirection.WEST));
        assertEquals(MapDirection.WEST, MapDirection.previous(MapDirection.NORTH));
    }

    @Test
    void toUnitVector() {
        assertEquals(new Vector2d(1, 0), MapDirection.toUnitVector(MapDirection.EAST));
        assertEquals(new Vector2d(-1, 0), MapDirection.toUnitVector(MapDirection.WEST));
        assertEquals(new Vector2d(0, 1), MapDirection.toUnitVector(MapDirection.NORTH));
        assertEquals(new Vector2d(0, -1), MapDirection.toUnitVector(MapDirection.SOUTH));
    }

}
