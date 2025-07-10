class Solution {
    List<List<Integer>> permutations;
    int n;
    void backTrack(List<Integer> cur,boolean[] visited){
        if(cur.size()==n){
            permutations.add(cur);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                
                if(myChecker(i+1,cur.size()+1)){
                    visited[i]=true;
                    List<Integer> temp=new ArrayList<>(cur);
                    temp.add(i+1);
                    backTrack(temp,visited);
                    visited[i]=false;
                }
                
            }
        }
    }
    boolean myChecker(int val,int index){
        if(val%index==0 || index%val==0){
            return true;
        }
        return false;
    }
    boolean check(List<Integer> a){
        for(int i=0;i<n;i++){
            if((i+1)%a.get(i)!=0 && a.get(i)%(i+1)!=0){
                return false;
            }
        }
        return true;
    }
    public int countArrangement(int n) {
        permutations=new ArrayList<>();
        this.n=n;
        backTrack(new ArrayList<>(),new boolean[n]);
        
        
        return permutations.size();
    }
}