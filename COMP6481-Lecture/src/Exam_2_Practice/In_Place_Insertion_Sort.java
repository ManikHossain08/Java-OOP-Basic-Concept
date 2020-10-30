package Exam_2_Practice;

import java.util.Arrays;

public class In_Place_Insertion_Sort {
	public static void main(String[] args) {
        String[] stringArr = new String[]{"b", "c", "a", "g", "k"};
        Sorter<String> stringInsertionSorter = new InsertionSort<>(stringArr);
        System.out.println(Arrays.toString(stringInsertionSorter.sort()));

        Integer[] intArr = new Integer[]{1, 7, 5, 3, 4, 5};
        Sorter<Integer> intInsertionSorter = new InsertionSort<>(intArr);
        System.out.println(Arrays.toString(intInsertionSorter.sort()));
    }
}

class InsertionSort<T extends Comparable<T>> implements Sorter<T> {

    private final T[] values;

    public InsertionSort(T[] values) {
        this.values = values;
    }

    @Override
    public T[] sort() {
        for (int index = 1; index < values.length; index++) {
            T value = values[index];
            int nextIndex = index - 1;
            while (nextIndex >= 0 && values[nextIndex].compareTo(value) >= 0) {
                values[nextIndex + 1] = values[nextIndex];
                nextIndex--;
            }
            values[nextIndex + 1] = value;
        }
        return values;
    }
}

interface Sorter<T extends Comparable<T>> {
    T[] sort();
}