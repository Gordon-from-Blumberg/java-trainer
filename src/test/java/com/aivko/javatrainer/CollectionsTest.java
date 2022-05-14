package com.aivko.javatrainer;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionsTest {
    private static List<Arguments> findMinArguments() {
        return List.of(
                Arguments.of(new int[] {}, Integer.MAX_VALUE),
                Arguments.of(new int[] {0}, 0),
                Arguments.of(new int[] {0, 1}, 0),
                Arguments.of(new int[] {0, -1}, -1),
                Arguments.of(new int[] {1, 10, 100}, 1),
                Arguments.of(new int[] {1, -10, 100}, -10),
                Arguments.of(new int[] {-1, -10, -100}, -100)
        );
    }

    @Test
    public void findMin_checkForNull() {
        assertThrows(IllegalArgumentException.class, () -> Collections.findMin(null));
    }

    @ParameterizedTest
    @MethodSource("findMinArguments")
    public void findMin_test(int[] array, int expectedMin) {
        assertEquals(expectedMin, Collections.findMin(array));
    }
}