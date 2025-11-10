package sonarjenkinstraining;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {

    @Test
    void sortsEmpty() {
        int[] a = {};
        QuickSort.quickSort(a);
        assertArrayEquals(new int[]{}, a);
    }

    @Test
    void sortsSingle() {
        int[] a = {1};
        QuickSort.quickSort(a);
        assertArrayEquals(new int[]{1}, a);
    }

    @Test
    void sortsAlreadySorted() {
        int[] a = {1, 2, 3, 4, 5};
        QuickSort.quickSort(a);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);
    }

    @Test
    void sortsReverse() {
        int[] a = {5, 4, 3, 2, 1};
        QuickSort.quickSort(a);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);
    }

    @Test
    void sortsWithDuplicates() {
        int[] a = {3, 1, 2, 3, 1};
        QuickSort.quickSort(a);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, a);
    }

    @Test
    void sortsWithNegatives() {
        int[] a = {0, -1, 5, -3, 2};
        QuickSort.quickSort(a);
        assertArrayEquals(new int[]{-3, -1, 0, 2, 5}, a);
    }

    @Test
    void sortsRandom() {
        Random rnd = new Random(42);
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) a[i] = rnd.nextInt(1000) - 500;
        int[] expected = Arrays.copyOf(a, a.length);
        Arrays.sort(expected);

        QuickSort.quickSort(a);
        assertArrayEquals(expected, a);
    }

    @Test
    void nullThrows() {
        assertThrows(NullPointerException.class, () -> QuickSort.quickSort(null));
    }
}



