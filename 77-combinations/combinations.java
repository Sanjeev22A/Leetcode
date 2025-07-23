class Solution {
    List<List<Integer>> result;
    void combi(int index,int n,int k,List<Integer> current){
        
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index>n){
            return;
        }
        for(int i=index;i<=n;i++){
            current.add(i);
            combi(i+1,n,k,current);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        result=new ArrayList<>();
        
        combi(1,n,k,new ArrayList<>());
        return result;
    }
}