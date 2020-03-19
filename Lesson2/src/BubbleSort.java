public class BubbleSort {
    void bubbleSort(Cars arr[]) {
        int n = arr.length;

        HpCarsComparator cmp = new HpCarsComparator();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {

                if (cmp.compare(arr[j], arr[j + 1]) > 0) {
                    // swap temp and arr[i]
                    Cars temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
    }
}