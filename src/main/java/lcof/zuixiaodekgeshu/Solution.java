package lcof.zuixiaodekgeshu;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length-1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = findMid(arr, s, e);
        quickSort(arr, s, mid - 1);
        quickSort(arr, mid + 1, e);
    }

    private int findMid(int[] arr, int s, int e) {
        int t = arr[s];
        while (s < e) {
            while (s < e && arr[e] >= t) {
                e--;
            }
            arr[s] = arr[e];
            while (s < e && arr[s] <= t) {
                s++;
            }
            arr[e] = arr[s];
        }
        arr[s] = t;
        return s;
    }
}
