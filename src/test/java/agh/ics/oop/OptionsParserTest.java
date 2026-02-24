package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {

    @Test
    void zamianaTest() {
        String[] input1 = new String[]{"f", "b", "r", "l"};
        ArrayList<MoveDirection> output1 = new ArrayList<>(List.of(FORWARD, BACKWARD, RIGHT, LEFT));
        assertEquals(List.of(), OptionsParser.zamiana(new String[]{}));
        assertEquals(output1, OptionsParser.zamiana(input1));

    }
}