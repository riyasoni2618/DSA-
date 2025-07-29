public class prblm88 {
    public static void main(String[] args) {
    Solution sol = new Solution();
    int[] nums = {2, 5, 6, 0, 0, 1, 2};  // Rotated sorted array with duplicates
    int target = 0;
    boolean result = sol.search(nums, target);
    System.out.println("Is target " + target + " present? " + result);
}

}
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid]==target) return true;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;
                right--;
                continue;
            }
            if (nums[left] <= nums[mid]) {   
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
