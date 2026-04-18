
public class smallestDivisor {
    public static int smallestDivisor(int[] nums, int threshold) {
        int s = 1;   // ✅ FIX
        int e = max(nums);
        int ans = -1;

        while(s <= e){
            int m = s + (e - s)/2;

            if(divisor(nums, m) <= threshold){
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return ans;
    }

    public static int divisor(int[] nums, int mid){
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += (nums[i] + mid - 1) / mid;   // ✅ FIX
        }
        return total;
    }

    public static int max(int[] arr){
        int max = Integer.MIN_VALUE;   // ✅ FIX
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max; 
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;

        int result = smallestDivisor(nums, threshold);
        System.out.println("Smallest Divisor: " + result);
    }

}
