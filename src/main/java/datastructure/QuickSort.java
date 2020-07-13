package datastructure;

public class QuickSort {
    
    
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 6, 8, 9, 2};

        quickSort(arr, 0, arr.length - 1);
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(Integer[] a, int low, int high) {
        if (low < high) {
            int midPos = partition(a, low, high);
            quickSort(a, low, midPos - 1);
            quickSort(a, midPos + 1, high);
        }
    }

    public static int partition(Integer[] a, int low, int high) {
        int mid = a[low];
        while (low < high) {
            // 从末尾开始往前，因为mid值是从开始位置取的
            while (a[high] >= mid && low < high) {
                high--;
            }
            a[low] = a[high];
            while (a[low] <= mid && low < high) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = mid;
        return low;
    }
}
