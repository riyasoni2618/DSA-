import java.util.*;

public class BookAllocation {

    public static boolean isPossible(int[] arr, int mid, int k) {
        int students = 1;
        int pages = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > mid) return false;

            if (pages + arr[i] > mid) {
                students++;
                pages = arr[i];
            } else {
                pages += arr[i];
            }

            if (students > k) return false;
        }
        return true;
    }

    public static int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;

        int s = max(arr);   // 👈 your function
        int e = sum(arr);   // 👈 your function
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (isPossible(arr, mid, k)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > max) max = x;
        }
        return max;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int k = 2;

        System.out.println(findPages(books, k));
    }
}