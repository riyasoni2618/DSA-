import java.util.Arrays;

public class Houserobber2 {

    int[] t;

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: take 0th house, exclude last
        t = new int[n];
        Arrays.fill(t, -1);
        int take_0th_idx_house = solve(nums, 0, n - 2);

        // Case 2: skip 0th house, include last
        t = new int[n];
        Arrays.fill(t, -1);
        int take_1th_idx_house = solve(nums, 1, n - 1);

        return Math.max(take_0th_idx_house, take_1th_idx_house);
    }

    public int solve(int[] nums, int i, int n){
        if(i > n) return 0;

        if(t[i] != -1){
            return t[i];
        }

        int take = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        return t[i] = Math.max(take, skip);
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = {2, 3, 2};   // test case

        int result = obj.rob(nums);

        System.out.println("Maximum money robbed (circular): " + result);
    }
}