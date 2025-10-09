class Solution {
    public int myAtoi(String s) {
         s=s.trim();
        if(s.length()==0) return 0;
        int i=0,sign=1;
        long sum=0;
        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            sign= s.charAt(0)=='-' ? -1 : 1;
            i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            sum=sum*10 +(s.charAt(i)-'0');
            if(sum * sign > Integer.MAX_VALUE ) return Integer.MAX_VALUE;
            if(sum * sign < Integer.MIN_VALUE ) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sum*sign);
    }
}
