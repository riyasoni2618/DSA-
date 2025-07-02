import java.util.*;
public class prblm189 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Original array: " + Arrays.toString(nums));
        solution.rotate(nums, k);
        System.out.println("Rotated array by " + k + " steps: " + Arrays.toString(nums));
    }
}
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

