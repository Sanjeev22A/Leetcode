class Point{
    int count;
    long sum;
    Point(int count,long sum){
        this.count=count;
        this.sum=sum;
    }
}
class Solution {
    
    public long[] distance(int[] nums) {
        Map<Integer,Point> leftCache=new HashMap<>();
        Map<Integer,Point> rightCache=new HashMap<>();
        long[] ans=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            long s=0L;
            int c=0;
            if(leftCache.containsKey(nums[i])){
                Point p=leftCache.get(nums[i]);
                ans[i]+=(long)i*(long)p.count-p.sum;
                c=p.count;
                s=p.sum;
            }
            Point temp=new Point(c+1,s+(long)i);
            System.out.println(nums[i]+":"+temp.count+":"+temp.sum);
            leftCache.put(nums[i],temp);
        }

        for(int i=nums.length-1;i>=0;i--){
            long s=0L;
            int c=0;
            if(rightCache.containsKey(nums[i])){
                Point p=rightCache.get(nums[i]);
                ans[i]+=p.sum-(long)i*(long)p.count;
                c=p.count;
                s=p.sum;
            }
            Point temp=new Point(c+1,s+(long)i);
            rightCache.put(nums[i],temp);
            
        }
        return ans;
    }
}