class Solution {
    public int countHillValley(int[] nums) {
        List<Integer> normalized=new ArrayList<>();
        int prev=-1;
        for(int a:nums){
            if(a==prev){
                continue;
            }
            normalized.add(a);
            prev=a;
        }
        int hillValleyCount=0;
        for(int i=1;i<normalized.size()-1;i++){
            int cur=normalized.get(i);
            int left=normalized.get(i-1);
            int right=normalized.get(i+1);
            if(cur<left && cur<right){
                hillValleyCount++;
            }
            if(cur>left && cur>right){
                hillValleyCount++;
            }
            
        }
        return hillValleyCount;
    }
}