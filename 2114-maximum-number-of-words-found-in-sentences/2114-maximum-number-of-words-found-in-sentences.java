class Solution {
    public int mostWordsFound(String[] sentences) {
      int temp=0;
       int result=0;
      for(int i=0;i<sentences.length;i++){
         temp=1;
            String s=sentences[i];
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)!=' '){
                   continue;
                }else{
                    temp+=1;
                }
                    
            }
 result=  Math.max(result,temp);
 
      }
      return result;
    }
}