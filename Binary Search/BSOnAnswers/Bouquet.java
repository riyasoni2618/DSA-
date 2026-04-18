class Bouquet {

    public static int minDays(int[] bloomDay, int m, int k) {

        // ✅ Edge case
        if((long)m * k > bloomDay.length) return -1;

        int s = mindays(bloomDay);
        int e = maxdays(bloomDay);
        int ans = -1;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(possible(bloomDay, mid, m, k)){
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }

    public static boolean possible(int[] arr, int days, int m, int k){
        int flower = 0;
        int bouq = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= days){
                flower++;

                if(flower == k){
                    bouq++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return bouq >= m;
    }

    public static int maxdays(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max; 
    }

    public static int mindays(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min; 
    }

    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;

        int result = minDays(bloomDay, m, k);
        System.out.println("Minimum days: " + result);
    }
}