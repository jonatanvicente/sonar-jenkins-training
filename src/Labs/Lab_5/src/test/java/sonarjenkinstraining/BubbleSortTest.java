package sonarjenkinstraining;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void testEmptyArray() {
        int[] input = new int[] {};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(new int[] {}, input);
    }

    @Test
    public void testSingleElement() {
        int[] input = new int[] {42};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(new int[] {42}, input);
    }

    @Test
    public void testAlreadySorted() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, input);
    }

    @Test
    public void testReverseSorted() {
        int[] input = new int[] {5, 4, 3, 2, 1};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, input);
    }

    @Test
    public void testWithDuplicates() {
        int[] input = new int[] {3, 1, 2, 3, 1};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(new int[] {1, 1, 2, 3, 3}, input);
    }
}

