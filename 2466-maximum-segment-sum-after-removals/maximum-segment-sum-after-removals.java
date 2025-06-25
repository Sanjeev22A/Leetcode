class UnionFind{
    int[] parent,start,end;
    long[] sum;
    boolean[] active;
    UnionFind(int[] nums){
        parent=new int[nums.length];
        start=new int[nums.length];
        end=new int[nums.length];
        sum=new long[nums.length];
        active=new boolean[nums.length];
    }

    int find(int x){
        if(x==parent[x]){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    long getSum(int x){
        return sum[find(x)];
    }
    long union(int x,int y){
        int parentx=find(x);
        int parenty=find(y);
        if(parentx==parenty){
            return getSum(parentx);
        }
        parent[parenty]=parentx;
        start[parentx]=Math.min(start[parentx],start[parenty]);
        end[parentx]=Math.max(end[parentx],end[parenty]);
        sum[parentx]+=sum[parenty];
        active[x]=true;
        active[y]=true;
        return getSum(x);
    }
    void add(int x,int val){
        parent[x]=x;
        start[x]=x;
        end[x]=x;
        sum[x]=val;
    }

}
class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        UnionFind uf=new UnionFind(nums);
        long[] ans=new long[nums.length];
        long maxSum=0;
        for(int i=0;i<nums.length;i++){
            uf.add(i,nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--){
            ans[i]=maxSum;

            int curIndex=removeQueries[i];
            uf.active[curIndex]=true;
            if(curIndex>0){
                if(uf.active[curIndex-1]){
                    uf.union(curIndex-1,curIndex);
                }
            }
            if(curIndex<nums.length-1){
                if(uf.active[curIndex+1]){
                    uf.union(curIndex,curIndex+1);
                }
            }
            long sum=uf.getSum(curIndex);
            maxSum=Math.max(sum,maxSum);
        }
        return ans;
    }
}