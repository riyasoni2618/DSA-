package Greedy;

public class prblm860 {
    public boolean lemonadeChange(int[] bills){
        int five =0;
        int ten =0;
        int twen =0;
        int n = bills.length;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                ten++;
                if(five>0){
                    five--;
                }
                else{
                    return false;
                }
            }
            else{
                twen++;
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        prblm860 obj = new prblm860();
        int[] bills = {5,5,10,10,20};
        boolean result = obj.lemonadeChange(bills);
        System.out.println("Can provide change: " + result);
    }

}
