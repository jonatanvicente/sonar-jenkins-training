package sonarjenkinstraining;

public class BinarySearch {
    public static int binarySearch(int[] a, int key) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) return mid;
            if (a[mid] < key) lo = mid + 1; else hi = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(a, 7)); // prints index 3
    }
}
