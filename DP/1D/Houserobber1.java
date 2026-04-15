public class Houserobber1 {

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int prev2 = 0;        // dp[i-2]
        int prev1 = nums[0];  // dp[i-1]

        for(int i = 1; i < n; i++){
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Houserobber obj = new Houserobber();
        int[] nums = {2, 7, 9, 3, 1};
        int result = obj.rob(nums);
        System.out.println("Maximum money robbed: " + result);
    }
}