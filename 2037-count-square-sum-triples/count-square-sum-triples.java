class Solution {
    public int countTriples(int n) {
        Set<Integer> squares=new HashSet<>();
        for(int i=1;i<=n;i++){
            squares.add(i*i);
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int cur=i*i+j*j;
                if(squares.contains(cur)){
                    ans++;
                }
            }
        }
        return ans;
    }
}