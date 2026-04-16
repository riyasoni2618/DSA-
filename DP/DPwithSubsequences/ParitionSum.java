import java.util.*;

class ParitionSum {
    static int[][] dp;

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int x = sum / 2;
        dp = new int[n + 1][sum + 1];   // ✅ fixed
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, x, 0);
    }

    static Boolean solve(int[] nums, int x, int i) {
        if (x == 0) return true;
        if (i >= nums.length) return false;

        if (dp[i][x] != -1)
            return dp[i][x] == 1;
        boolean skip = solve(nums, x, i + 1);
        boolean take = false;
        if (nums[i] <= x) {
            take = solve(nums, x - nums[i], i + 1);
        }
        dp[i][x] = (skip || take) ? 1 : 0;
        return skip || take;
    }
}