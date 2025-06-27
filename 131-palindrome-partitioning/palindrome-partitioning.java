class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        backTrack(s,new ArrayList<>(),0,"");
        return res;
    }
    boolean isPalindrome(String s){
        if(s.length()==0){
            return false;
        }
        int start=0,end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;end--;
        }
        return true;
    }
    void backTrack(String s,List<String> curSequence,int index,String currentString){
       
        if(index==s.length()){
            if(isPalindrome(currentString)){
                curSequence.add(currentString);
                res.add(curSequence);
                return;
            }
            else{
                return;
            }
        }
        
        if(isPalindrome(currentString)){
            backTrack(s,new ArrayList<>(curSequence),index+1,currentString+s.charAt(index));
            List<String> temp=new ArrayList<>(curSequence);
            temp.add(currentString);
            
            backTrack(s,temp,index+1,""+s.charAt(index));
        }else{
            backTrack(s,new ArrayList<>(curSequence),index+1,currentString+s.charAt(index));
        }
    }

}