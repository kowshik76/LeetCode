class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fives++;
            } else if (bills[i] == 10) {
                if (fives >= 1) {
                    fives--;
                    tens++;
                } else {
                    return false;
                }
            } else {
                if (tens >= 1 && fives >= 1) {
                    fives -= 1;
                    tens -= 1;
                } else if(fives >= 3){
                    fives-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}