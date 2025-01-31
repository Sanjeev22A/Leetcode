class Solution {
    boolean bfs(int node,int[][] graph,int[] color,int curColor){
       color[node]=curColor;
       Queue<Integer> queue=new LinkedList<>();
       int comp=(curColor+1)%2;
       for(int a:graph[node]){
            
            if(color[a]==-1){
                if(!bfs(a,graph,color,comp)){return false;}
            }
            else if(color[a]==comp){
                continue;
            }
            else{
                return false;
            }
       }
       return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1 && !bfs(i,graph,color,1)){
                return false;
            }
        }
        return true;
    }
}