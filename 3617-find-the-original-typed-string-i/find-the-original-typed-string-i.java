class Solution {
    public int possibleStringCount(String s) {
        int count=0;
        int numCount=0;
        int ans=1;
        char prev='.';
        for(char c:s.toCharArray()){
            
            if(prev==c){
                count++;

            }else{
                if(count>0){
                    numCount++;
                    ans+=(count);
                }
                count=0;
            }
            //System.out.println(prev+":"+c+":"+count);
            prev=c;
        }
        if(count>0){
            ans+=count;
        }
        return ans;
    }
}