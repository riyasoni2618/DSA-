import java.util.ArrayList;
import java.util.List;
public class majorityele2 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 2, 3, 2, 2, 1, 1};
        List<Integer> result = sol.majorityElement(nums);

        System.out.println("Majority elements (> n/3): " + result);
    }
}
    class Solution {
    public List<Integer> majorityElement(int[] nums) {
       ArrayList<Integer> ans = new ArrayList<>();
        int cnt1 =0;
        int cnt2=0;
        int el1= Integer.MIN_VALUE;
        int el2= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i]!= el2){
                cnt1=1;
                el1= nums[i];
            }else if(cnt2==0 && nums[i] != el1){
                cnt2=1;
                el2= nums[i];
            }else if(el1 == nums[i]){
                cnt1++;
            }else if(el2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]== el1) cnt1++;
            else if(nums[i] == el2) cnt2++;
        }
        if(cnt1>nums.length/3)
        ans.add(el1);
        if(cnt2> nums.length/3)
        ans.add(el2);
        return ans;
    }
}
