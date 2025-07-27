class Point{
    int x,y;
    int id;
    Point(int x,int y,int id){
        this.x=x;
        this.y=y;
        this.id=id;
    }
   
}
class Edge{
    Point p1,p2;
    int weight;
   
    Edge(Point p1,Point p2){
        this.p1=p1;
        this.p2=p2;
        this.weight=calcWeight();
    }
    int calcWeight(){
        this.weight=Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
        return weight;
    }
}
class UnionFind{
    int[] parent;
    List<Point> points;
    UnionFind(int n,List<Point> points){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;

        }
        this.points=points;
    }
    int find(int x){
        if(x==parent[x]){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }
    int union(Edge e1){
        Point p1=e1.p1;
        Point p2=e1.p2;
        int parentX=find(p1.id);
        int parentY=find(p2.id);
        if(parentX==parentY){
            return 0;
        }
        else{
            parent[parentY]=parentX;
            return e1.weight;
        }
    }
}
class Solution {
    
    public int minCostConnectPoints(int[][] points) {
       PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->(a.weight-b.weight));
       List<Point> pointsArr=new ArrayList<>();
       int id=0;
       for(int[] a:points){
            pointsArr.add(new Point(a[0],a[1],id++));
       }
       for(int i=0;i<points.length;i++){
        for(int j=i+1;j<points.length;j++){
            Point p1=pointsArr.get(i);
            Point p2=pointsArr.get(j);
            Edge e=new Edge(p1,p2);
            pq.offer(e);
        }
       }
        int ans=0;
        UnionFind uf=new UnionFind(id,pointsArr);
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            ans+=uf.union(e);
        }
        return ans;


    }
}