class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hs=new HashMap<>();
        hs.put('I',1);
        hs.put('V',5);
        hs.put('X',10);
        hs.put('L',50);
        hs.put('C',100);
        hs.put('D',500);
        hs.put('M',1000);
        char temp=' ';
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(temp!=' '){
                if(hs.get(s.charAt(i))-hs.get(temp)>0){
                    ans-=hs.get(temp);
                    ans+=hs.get(s.charAt(i))+hs.get(temp);
                    temp=s.charAt(i);
                }else{
                    temp=s.charAt(i);
                    ans+=hs.get(temp);
                }
            }else{
                temp=s.charAt(i);
                ans+=hs.get(temp);
            }
        }
        return ans;
    }
}
