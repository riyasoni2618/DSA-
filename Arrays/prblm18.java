import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class prblm18 {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter target value: ");
        int target = sc.nextInt();
        Solution sol = new Solution();
        List<List<Integer>> result = sol.fourSum(nums, target);
        System.out.println("Quadruplets that sum to target:");
        for (List<Integer> quad : result) {
            System.out.println(quad);
        }

        sc.close();
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       Arrays.sort(nums);
       List<List<Integer>> ans = new ArrayList<>();
       int n = nums.length;
       for(int i =0;i<n;i++){
        // first optimise for the duplicate no of i
        if(i>0 && nums[i] == nums[i-1]){
            continue;
        }
        for(int j=i+1;j<n;j++){
            // sec optimize for the duplicate no of j
            if(j>i+1 && nums[j] == nums[j-1]){
                continue;
            }
            int p= j+1;
            int q= n-1;
            while(p<q){
                long sum =  (long) nums[i]+ nums[j]+ nums[p]+ nums[q];
                if(sum<target){
                    p++;
                }
                else if(sum>target){
                    q--;
                }
                else{
                    ans.add(List.of(nums[i],nums[j],nums[p++],nums[q--]));
                    // 3rd op. for the duplicate no of the p
                    while(p<q && nums[p] == nums[p-1]){
                        p++;
                    }
                    // 4th op. for the duplicate no of the q
                    while(p<q && nums[q] == nums[q+1]){
                        q--;
                    } 
                }
                
            }
         }
       } 
       return ans;
    }
}
