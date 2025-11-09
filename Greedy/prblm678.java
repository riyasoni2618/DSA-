package Greedy;

public class prblm678 {
    public boolean checkValidString(String s){
        int min =0;
        int max =0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch =='('){
                min++;
                max++;
            }
            else if(ch == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }
            if(max<0){
                return false;
            }
            if(min<0){
                min=0;
            }
        }
        return min==0;
    }
    public static void main (String[] args){
        prblm678 obj = new  prblm678();
        String s = "(*))";
        boolean result = obj.checkValidString(s);
        System.out.println("Is the string valid? " + result);
    }
}
