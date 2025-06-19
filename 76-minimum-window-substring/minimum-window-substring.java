class Solution {
    int getChar(char c){
        if(c>='a' && c<='z'){
            return c-'a';
        }else if(c>='A' && c<='Z'){
            return c-'A'+26;
        }
        return 0;
    }
    boolean canEqual(int[] map1,int[] map2){
        for(int i=0;i<52;i++){
            if(map1[i]<map2[i]){
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] map1=new int[52];
        int[] map2=new int[52];
        for(char c:t.toCharArray()){
            map2[getChar(c)]++;
        }
        int start=0,end=0;
        boolean startUpdate=false;
        String temp="";
        int ans=Integer.MAX_VALUE;
        while(end<s.length()){
            if(!startUpdate){
                map1[getChar(s.charAt(end))]++;
            }
            if(start<s.length() && canEqual(map1,map2)){
                if(end-start+1<ans){
                    ans=end-start+1;
                    temp=s.substring(start,end+1);
                    
                }
                map1[getChar(s.charAt(start))]--;
                start++;
                startUpdate=true;
            }else{
                end++;
                startUpdate=false;
            }
        }
        while(start<end && canEqual(map1,map2)){
            if(end-start+1<ans){
                ans=end-start+1;
                temp=s.substring(start,end+1);

            }
            map1[getChar(s.charAt(start))]--;
            start++;
        }
        return temp;
    }

    
}