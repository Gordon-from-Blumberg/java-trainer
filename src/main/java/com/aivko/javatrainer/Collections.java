package com.aivko.javatrainer;

import java.util.List;

public class Collections {
    /**
     * Метод для примера
     * Возвращает минимальное число из массива
     * @param array Массив чисел
     * @return Минимальное число
     */
    public static int findMin(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array is null");
        }

        int min = Integer.MAX_VALUE;
        for (int n : array) {
            if (n < min) {
                min = n;
            }
        }

        return min;
    }

    /**
     * Возвращает минимальное число из списка
     * Если список пустой - возвращает {@link Integer#MAX_VALUE}
     * @param list Список чисел
     * @return Минимальное число
     */
    public static int findMinInList(List<Integer> list) {
        // тут тебе нужно написать свою реализацию этого метода
        return 0;
    }

    /**
     * Возвращает среднее арифметическое всех чисел из списка
     * Если список пустой или null - выбрасывает {@link IllegalArgumentException}
     * @param list Список чисел
     * @return Среднее арифметическое
     */
    public static float getAverage(List<Float> list) {
        // тут тебе нужно написать свою реализацию этого метода
        return 0f;
    }
}
