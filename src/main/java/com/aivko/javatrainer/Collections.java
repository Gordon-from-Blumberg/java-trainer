package com.aivko.javatrainer;

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
}
