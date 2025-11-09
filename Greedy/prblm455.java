package Greedy;

public class prblm455 {
    public int findContentChildren(int[] g, int[] s) {
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);
        int left=0;
        int right=0;
        int n = g.length;
        int m = s.length;
        int count=0;
        while(left<n && right<m){
            if(g[left]<=s[right]){
                count++;
                left++;
                right++;
            }
            else{
                left++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        prblm455 obj = new prblm455();
        int[] g = {1,3,3,4,5};
        int[] s = {1,1,2,2,3,4};
        int res = obj.findContentChildren(g,s);
        System.out.println("Numbers:" +res);
    }
}
