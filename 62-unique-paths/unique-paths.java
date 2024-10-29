class Solution {
    class Pair{
        int i,j;
        
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
         public int hashCode() {
            return 31 * i + j; // A common way to generate hash codes for multiple fields
        }
        public boolean equals(Object o){
            if(o instanceof Pair){
                Pair cur=(Pair)o;
                return cur.i==this.i&&cur.j==this.j;
            }
            return false;
        }
    }
    HashMap<Pair,Integer> memo=new HashMap<>();
    int logic(int i,int j,int m,int n){
        Pair p=new Pair(i,j);
        if(memo.containsKey(p)){
            return memo.get(p);
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            
            memo.put(p,1);
            return 1;
        }
        int val1=logic(i,j+1,m,n);
        int val2=logic(i+1,j,m,n);
        int result=val1+val2;
        memo.put(p,result);

        return result;

    }
    public int uniquePaths(int m, int n) {
        return logic(0,0,m,n);
    }   
}