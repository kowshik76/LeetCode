class Solution {
    public static boolean ispal(int ind,int last,String s){
        while(ind<=last){
            if(s.charAt(ind++)!=s.charAt(last--)){
                return false;
            }
        }
        return true;
    }
    public static void helpme(String s,List<List<String>> ans,List<String> pals,int ind){
        if(ind==s.length()){
            ans.add(new ArrayList<>(pals));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(ispal(ind,i,s)){
                pals.add(s.substring(ind,i+1));
                helpme(s,ans,pals,i+1);  
                pals.remove(pals.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> pals=new ArrayList<>();
        helpme(s,ans,pals,0);
        return ans;
    }
}