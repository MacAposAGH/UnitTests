package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void zamianaTest() {
        String[] input1 = new String[]{"f", "f"};
        MoveDirection[] output1_s = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD};
        List<MoveDirection> output1 = Arrays.asList(output1_s);



        assertEquals(output1, OptionsParser.zamiana(input1));

    }
}