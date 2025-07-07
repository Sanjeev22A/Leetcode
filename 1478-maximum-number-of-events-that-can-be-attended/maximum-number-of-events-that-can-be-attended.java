class Solution {
    class UnionFind{
        int[] parent;
        UnionFind(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int search(int day){
            if(day==parent[day]){  //Implies a free day
                return day;
            }
            parent[day]=search(parent[day]);
            return parent[day];
        }
        void markDay(int day){
            parent[day]=search(day+1);  //Next available day will be present as parent of this day
        }
    }
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            return a[1]-b[1];
        });

        int maxDay=events[events.length-1][1]+2;
        UnionFind uf=new UnionFind(maxDay+2);
        int count=0;
        for(int[] a:events){
            int start=a[0];
            int end=a[1];
            int availableDay=uf.search(start);
            if(availableDay<=end){
                count++;
                uf.markDay(availableDay);
            }
           
        }
        return count;
    }
}