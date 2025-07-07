class UnionFind{
    int[] parent;
    UnionFind(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    int search(int day){
        if(day==parent[day]){   //That means this day is unoccupied
            return day;
        }
        parent[day]=search(parent[day]); //Occupied
        return parent[day];
    }
}

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            return a[1]-b[1];
        });  //Sort by end dates in ascending order
        int maxDay=events[events.length-1][1]+2;
        UnionFind uf=new UnionFind(maxDay);

        int ans=0;
        for(int[] a:events){
            int start=a[0];
            int end=a[1];
            int availableEnd=uf.search(a[0]);
            if(availableEnd<=end){
                ans++;
                uf.parent[availableEnd]=uf.search(availableEnd+1);
            }
        }
        return ans;
    }
}