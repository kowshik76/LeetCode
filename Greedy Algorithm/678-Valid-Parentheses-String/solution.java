class Solution {
    public boolean checkValidString(String s) {
        int cmin=0,cmax=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cmax++;
                cmin++;
            }else if(s.charAt(i)==')'){
                cmin--;
                cmax--;
            }else{
                cmin--;
                cmax++;
            }
            if(cmin<0){
                cmin=0;
            }
            if(cmax<0) return false;
        }
        return cmin==0;
    }
}
