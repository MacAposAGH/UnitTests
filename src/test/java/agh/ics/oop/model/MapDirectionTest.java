package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MapDirectionTest {
    @Test
    void next() {
        assertEquals(MapDirection.EAST, MapDirection.next(MapDirection.NORTH));
        assertEquals(MapDirection.SOUTH, MapDirection.next(MapDirection.EAST));
        assertEquals(MapDirection.WEST, MapDirection.next(MapDirection.SOUTH));
        assertEquals(MapDirection.NORTH, MapDirection.next(MapDirection.WEST));
    }



}
