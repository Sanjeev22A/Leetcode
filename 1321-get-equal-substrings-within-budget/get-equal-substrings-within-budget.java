class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost=new int[s.length()];
        for(int i=0;i<s.length();i++){
            cost[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        int start=0,end=0;
        int curCost=0;
        int maxLength=0;
        
        while(end<s.length()){
            if(curCost+cost[end]<=maxCost){
                
                curCost+=cost[end];
                maxLength=Math.max(end-start+1,maxLength);
                end++;
            }else{
                while(start<end && curCost+cost[end]>maxCost){
                    curCost-=cost[start];
                    start++;
                }
                if(start==end && cost[end]>maxCost){
                    curCost=0;
                    start=end+1;
                    end=end+1;
                    
                }
                else{
                    curCost+=cost[end];
                    maxLength=Math.max(maxLength,end-start+1);
                    end++;
                    
                }
            }
        }
        return maxLength;
    }
}