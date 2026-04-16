class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        //Fix the logic for caching the left and right nearest neighbours
        int[] leftCache=new int[nums.length];
        int[] rightCache=new int[nums.length];
        Map<Integer,Integer> lookUp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            lookUp.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            leftCache[i]=lookUp.getOrDefault(nums[i],-1);
            lookUp.put(nums[i],i);
        }
        lookUp=new HashMap<>();
        
        for(int i=nums.length-1;i>=0;i--){
            lookUp.put(nums[i],i);
        }
        for(int i=nums.length-1;i>=0;i--){
            rightCache[i]=lookUp.getOrDefault(nums[i],-1);
            lookUp.put(nums[i],i);
        }
        
        List<Integer> ans=new ArrayList<>();
        int len=nums.length;
        for(int i=0;i<queries.length;i++){
            int idx=queries[i];
            int leftIdx=leftCache[queries[i]];
            int rightIdx=rightCache[queries[i]];
            int dist=-1;
            System.out.println(idx+":"+leftIdx+":"+rightIdx);
            if(leftIdx==idx){
                leftIdx=-1;
            }
            if(rightIdx==idx){
                rightIdx=-1;
            }
            if(leftIdx==-1 && rightIdx==-1){
                ans.add(-1);
                continue;
            }else if(leftIdx==-1){
                dist=Math.min(calcLeftNearest(idx,rightIdx,len),calcRightNearest(idx,rightIdx,len));
            }else if(rightIdx==-1){
                dist=Math.min(calcLeftNearest(idx,leftIdx,len),calcRightNearest(idx,leftIdx,len));
            }else{
                int dist1=Math.min(calcLeftNearest(idx,rightIdx,len),calcRightNearest(idx,rightIdx,len));
                int dist2=Math.min(calcLeftNearest(idx,leftIdx,len),calcRightNearest(idx,leftIdx,len));
                dist=Math.min(dist1,dist2);
            }
            ans.add(dist);
        }
        return ans;
    }
    private int calcLeftNearest(int idx,int leftNearest,int len){
        int dist=0;
        if(idx>leftNearest){
                dist=idx-leftNearest;
        }else{
                dist=idx+(len-leftNearest);
        }
        return dist;
    }
    private int calcRightNearest(int idx,int rightNearest,int len){
        int dist=0;
            if(rightNearest>idx){
                dist=rightNearest-idx;
            }else{
                 dist=(len-idx)+rightNearest;
            }
        return dist;
    }
}