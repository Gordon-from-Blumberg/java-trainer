package com.aivko.javatrainer;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
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

    private static List<Arguments> findMinInListArguments() {
        return List.of(
                Arguments.of(List.of(), Integer.MAX_VALUE),
                Arguments.of(List.of(0), 0),
                Arguments.of(List.of(0, 1), 0),
                Arguments.of(List.of(0, -1), -1),
                Arguments.of(List.of(1, 10, 100), 1),
                Arguments.of(List.of(1, -10, 100), -10),
                Arguments.of(List.of(-1, -10, -100), -100)
        );
    }

    private static List<Arguments> getAverageArguments() {
        return List.of(
                Arguments.of(List.of(0f), 0f),
                Arguments.of(List.of(5.4f), 5.4f),
                Arguments.of(List.of(0f, 0f, 0f), 0f),
                Arguments.of(List.of(0f, -1f, 1f), 0f),
                Arguments.of(List.of(1f, 2f, 3f), 2f),
                Arguments.of(List.of(-100f, 6f, 4f), -30f),
                Arguments.of(List.of(1.1f, 1.2f, 1.3f), 1.2f),
                Arguments.of(List.of(-2.1f, -2.2f, -2.3f), -2.2f),
                Arguments.of(List.of(2f, 3f), 2.5f)
        );
    }

    private static List<Arguments> addEvenArguments() {
        return List.of(
                Arguments.of(new ArrayList<Integer>(), new int[] {1, 2, 3}, List.of(2)),
                Arguments.of(list(1), new int[] {1, 2, 3}, List.of(1, 2)),
                Arguments.of(list(1, 2), new int[] {1, 2, 3}, List.of(1, 2, 2)),
                Arguments.of(list(1, 2), new int[] {1, 3, 5}, List.of(1, 2)),
                Arguments.of(list(2), new int[] {0, 2, 10}, List.of(2, 0, 2, 10)),
                Arguments.of(list(2), new int[] {}, List.of(2)),
                Arguments.of(list(5), new int[] {-1, -2, -4}, List.of(5, -2, -4))
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

    @Test
    public void getAverage_checkForNull() {
        assertThrows(IllegalArgumentException.class, () -> Collections.getAverage(null));
    }

    @Test
    public void getAverage_checkForEmpty() {
        assertThrows(IllegalArgumentException.class, () -> Collections.getAverage(List.of()));
    }

    @ParameterizedTest
    @MethodSource("findMinInListArguments")
    public void findMinInList_test(List<Integer> list, int expectedMin) {
        assertEquals(expectedMin, Collections.findMinInList(list));
    }

    @ParameterizedTest
    @MethodSource("getAverageArguments")
    public void getAverage_test(List<Float> list, float expectedAvg) {
        assertEquals(expectedAvg, Collections.getAverage(list));
    }

    @Test
    public void addEven_checkForNull() {
        assertThrows(IllegalArgumentException.class, () -> Collections.addEven(null, new int[] {1, 2}));
        assertThrows(IllegalArgumentException.class, () -> Collections.addEven(list(1, 2), null));
    }

    @ParameterizedTest
    @MethodSource("addEvenArguments")
    public void addEven_test(List<Integer> list, int[] array, List<Integer> expected) {
        Collections.addEven(list, array);
        assertIterableEquals(expected, list);
    }

    @SafeVarargs
    private static <T> List<T> list(T... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}