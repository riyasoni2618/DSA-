
public class shipWithinDays {
    public static int shipWithinDays(int[] weights, int days) {
        int s = max(weights);
        int e = sumOfwt(weights);
        int ans = -1;

        while(s <= e){
            int mid = s + (e - s)/2;
            int findDays = mindays(weights , mid);

            if(findDays <= days){
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static int mindays(int[] weights , int mid){
        int load = 0;
        int day = 1;

        for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > mid){
                day++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return day;
    }

    public static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max; 
    }

    public static int sumOfwt(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum; 
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        int result = shipWithinDays(weights, days);
        System.out.println("Minimum Capacity: " + result);
    }
}

