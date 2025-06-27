// two pointer approach
import java.util.*;
public class threesum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println("Triplets that sum to 0 are:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> ans = new ArrayList<>();
       int n = nums.length;
       for(int i=0;i<n;i++){
        if(i>0 && nums[i] == nums[i-1]){
            continue;
        }
        int j=i+1,k=n-1;
        while(j<k){
            int sum = nums[i]+nums[j]+nums[k];
            if(sum<0){
                j++;
            }
            else if(sum>0){
                k--;
            }
            else{
                ans.add(List.of(nums[i],nums[j++],nums[k--]));
                while(j<k && nums[j] == nums[j-1]){
                    j++;
                }
                while(j<k && nums[k] == nums[k+1]){
                    k--;
                }
            }
        }
       }
       return ans; 
    }
}