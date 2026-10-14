public class QuickSortThreeWay {
    public static void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            if (a[i] < v) swap(a, lt++, i++);
            else if (a[i] > v) swap(a, i, gt--);
            else i++;
        }
        quickSort(a, lo, lt - 1);
        quickSort(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 2, 4, 1, 9, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("3-Way Sorted: " + java.util.Arrays.toString(arr));
    }
}
