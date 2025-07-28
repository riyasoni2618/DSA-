class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i=0;i<nums.length;i++){
            ans = ans^nums[i];
        }
        return ans;
    }
}
public class prblm136{
    public static void main(String[] args) {
       Solution sol = new Solution();
        int[] nums = {2, 3, 2, 4, 4};
        int result = sol.singleNumber(nums);
        System.out.println("The single number is: " + result); 
    }
}