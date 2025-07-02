import java.util.*;

public class prblm26 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int newLength = solution.removeDuplicates(nums);

        System.out.println("New length: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
