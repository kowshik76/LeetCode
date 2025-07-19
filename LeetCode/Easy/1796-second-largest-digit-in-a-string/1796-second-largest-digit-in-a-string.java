class Solution {
    public int secondHighest(String s) {
        int first=-1;
        int second=-1;
        for(char dig:s.toCharArray()){
            if(Character.isDigit(dig)){
                int temp=Character.getNumericValue(dig);
                if(temp>first){
                    second=first;
                    first=temp;
                }else if(first > temp && second <temp){
                    second=temp;
                }
            }
        }
        return second;
    }
}