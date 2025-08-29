class Solution {
    public long flowerGame(int n, int m) {
        int evenCount1=n/2;
        int oddCount1=(n%2==1)?n/2+1:n/2;
        int evenCount2=m/2;
        int oddCount2=(m%2==1)?m/2+1:m/2;
        return (long)evenCount1*(long)oddCount2+(long)evenCount2*(long)oddCount1;
    }
}