class Solution {
    public int[] findErrorNums(int[] nums) {
         int n = nums.length;
        int[] hash = new int[n + 1];
        int repeating = -1, missing = -1;
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2)
                repeating = i;
            else if (hash[i] == 0)
                missing = i;
            if (repeating != -1 && missing != -1)
                break;
        }
        return new int[]{repeating, missing};
    }
}
public class prblm645 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 2, 4};
        int[] result = sol.findErrorNums(nums);
        System.out.println("Repeating Number: " + result[0]);
        System.out.println("Missing Number: " + result[1]);
    }
}