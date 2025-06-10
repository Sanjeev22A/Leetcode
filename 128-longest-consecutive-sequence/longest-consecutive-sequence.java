class Pair{
    int val,count;
    Pair(int val,int count){
        this.val=val;
        this.count=count;
    }
}

class UnionFind{
    Map<Integer,Pair> parent;
    UnionFind(int[] nums){
        parent=new HashMap<>();
        for(int a:nums){
            parent.put(a,new Pair(a,1));
        }
    }
    int find(int a){
        if(a==parent.get(a).val){
            return a;
        }
        parent.get(a).val=find(parent.get(a).val);
        return parent.get(a).val;
    }

    int union(int a,int b){
        Pair rootA=parent.get(find(a));
        Pair rootB=parent.get(find(b));
        if(rootA.val==rootB.val){
            return rootA.count;
        }
        parent.get(rootB.val).val=rootA.val;
        parent.get(rootA.val).count=rootA.count+rootB.count;
        return rootA.count+rootB.count;
    }

    int getMax(){
        int max=0;
        for(Map.Entry<Integer,Pair> a:parent.entrySet()){
            max=Math.max(a.getValue().count,max);
        }
        return max;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind uf=new UnionFind(nums);
        HashSet<Integer> set=new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        for(int a:set){
            if(set.contains(a+1)){
                uf.union(a,a+1);
               
            }
        }
        return uf.getMax();
    }
}