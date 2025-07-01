import java.util.Scanner;
public class prblm152 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        int result = sol.maxProduct(nums);
        System.out.println("Maximum product subarray: " + result);
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int pre =1;
        int suff=1;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre = pre*nums[i];
            suff = suff*nums[n-i-1];
            ans = Math.max(ans,Math.max(pre,suff));
        }
        return ans;
    }
}
