public class prblm1752 {
         public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {3, 4, 5, 1, 2}; // Rotated sorted array - true
        int[] nums2 = {2, 1, 3, 4};    // Not rotated sorted - false
        int[] nums3 = {1, 2, 3};       // Sorted - true
        System.out.println("Result 1: " + sol.check(nums1)); // true
        System.out.println("Result 2: " + sol.check(nums2)); // false
        System.out.println("Result 3: " + sol.check(nums3)); // true
    }
}
class Solution {
    public boolean check(int[] nums) {
      int n = nums.length-1;
      int count = 0;
      for(int i=0;i<n;i++){
        if(nums[i]> nums[i+1]){
            count++;
        }
      }  
      if(nums[n]> nums[0]){
        count++;
      }
      return count<=1;
    }
}
