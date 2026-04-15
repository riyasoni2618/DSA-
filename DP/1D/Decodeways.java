import java.util.Arrays;

public class Decodeways {

    int[] t = new int[101];

    public int numDecodings(String s) {
        Arrays.fill(t, -1);
        return solve(s, 0, s.length());
    }

    public int solve(String s, int i, int n){
        if(i == n) return 1;   // ✅ fixed

        if(s.charAt(i) == '0') return 0;

        if(t[i] != -1) return t[i];

        int res = solve(s, i + 1, n);

        if(i + 1 < n){
            if(s.charAt(i) == '1' || 
              (s.charAt(i) == '2' && s.charAt(i+1) <= '6')){
                res += solve(s, i + 2, n);
            }
        }

        return t[i] = res;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        String s = "226";   // test input

        int result = obj.numDecodings(s);

        System.out.println("Total decoding ways: " + result);
    }
}