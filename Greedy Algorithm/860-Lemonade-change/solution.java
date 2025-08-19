class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] > 5) return false;
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10 ){
                if(five <= 0){
                    return false;
                }else{
                    five--;
                    ten++;
                }
            }else{
                    if(ten >=1 && five >=1){
                        ten--;
                        five--;
                    }else if(five >=3){
                        five-=3;
                    }else{
                        return false;
                    }
            }
        }
        return true;
    }
}
