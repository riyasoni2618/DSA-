class koko {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int end = maxBanana(piles);
        int ans = 0;

        while(low <= end){
            int mid = low + (end - low)/2;
            int total = totalhours(piles , mid);

            if(total <= h){
                ans = mid; 
                end = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int totalhours(int[] piles , int mid){
        int total = 0;
        for(int i = 0; i < piles.length; i++){
            total += Math.ceil((double)piles[i] / mid);
        }
        return total;
    }

    public static int maxBanana(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max; 
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}