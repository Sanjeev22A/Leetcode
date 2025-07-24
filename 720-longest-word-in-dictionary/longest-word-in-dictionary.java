class Solution {
    public String longestWord(String[] words) {
        Set<String> set=new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        String res="";
        for(String word:words){
            boolean flag=true;
            for(int i=0;i<word.length();i++){
                if(!set.contains(word.substring(0,i+1))){
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(res.length()<word.length()){
                    res=word;
                }
                else if(res.length()==word.length()){
                    int val=res.compareTo(word);
                    if(val>0){
                        res=word;
                    }
                }
            }
        }
        return res;
    }
}