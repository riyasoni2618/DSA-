public class prblm33 {
   public static void main(String[] args) {
    Solution sol = new Solution();
    
    int[] nums = {4, 5, 6, 7, 0, 1, 2}; // Rotated sorted array
    int target = 0;

    int result = sol.search(nums, target);
    System.out.println("Index of target " + target + ": " + result);
}

}

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if(nums[mid]==target) return mid;
            // must check left < mid or not.
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
        return nums[left] == target ? left : -1;
    }
}
