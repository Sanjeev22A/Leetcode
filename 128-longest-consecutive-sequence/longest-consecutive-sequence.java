class Pair {
    int a, count;
    Pair(int a, int count) {
        this.a = a;
        this.count = count;
    }
}

public class UnionFind {
    HashMap<Integer, Pair> parent;

    UnionFind(int[] arr) {
        parent = new HashMap<>();
        for (int a : arr) {
            parent.put(a, new Pair(a, 1));
        }
    }

    int find(int x) {
        if (x != parent.get(x).a) {
            parent.get(x).a = find(parent.get(x).a);  
        }
        return parent.get(x).a;
    }

    int union(int a, int b) {
        if (!parent.containsKey(a) || !parent.containsKey(b)) return 0;

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return parent.get(rootA).count;

        
        int newCount = parent.get(rootA).count + parent.get(rootB).count;
        parent.get(rootB).a = rootA;
        parent.get(rootA).count = newCount;

        return newCount;
    }

    int getMaxComponent() {
        int max = 0;
        for (Map.Entry<Integer, Pair> entry : parent.entrySet()) {
            
            if (entry.getKey() == parent.get(entry.getKey()).a) {
                max = Math.max(entry.getValue().count, max);
            }
        }
        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind uf=new UnionFind(nums);
        HashSet<Integer> a=new HashSet<>();
        for(int b:nums){
            a.add(b);
        }

        for(int b:a){
            if(a.contains(b+1)){
                uf.union(b,b+1);
            }
        }
        return uf.getMaxComponent();
        
    }
}