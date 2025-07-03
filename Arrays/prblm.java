import java.util.Scanner;

public class prblm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size (n elements, from 0 to n, one number is missing)
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter array elements (from 0 to " + n + " with one number missing): ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int missing = sol.missingNumber(nums);

        System.out.println("Missing number is: " + missing);

        sc.close();
    }
}

class Solution {
    public int missingNumber(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctIndex]){
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index){
                return index;
            }
        }

        return nums.length;
    }

    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
