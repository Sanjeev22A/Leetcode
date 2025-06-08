class Solution {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res=new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,n);

        }
        return res;
    }

    void dfs(int current,int n){
        if(current>n){
            return;
        }
        res.add(current);
        for(int i=0;i<=9;i++){
            dfs(current*10+i,n);
        }
    }

}