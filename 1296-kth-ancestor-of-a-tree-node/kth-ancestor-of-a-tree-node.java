class TreeAncestor {
    int[][] up;
    int n;
    int[] parent;
    int LOG=20;

    int log(int n){
        return (int)(Math.log(n)/Math.log(2)+1);
    }
    void preprocess(){
        for(int i=0;i<n;i++){
            up[i][0]=parent[i];
        }
        for(int j=1;j<LOG;j++){
            for(int i=0;i<n;i++){
                if(up[i][j-1]==-1){
                    up[i][j]=-1;
                    continue;
                }
                up[i][j]=up[up[i][j-1]][j-1];
            }
        }
    }
    public TreeAncestor(int n, int[] parent) {
        LOG=log(n);
        this.parent=parent;
        this.n=n;
        this.up=new int[n][LOG];
        preprocess();
    }
    
    public int getKthAncestor(int node, int k) {
        for(int j=0;j<LOG;j++){
            if(node==-1){
                return -1;
            }
            if((k&(1<<j))>0){
                node=up[node][j];
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */