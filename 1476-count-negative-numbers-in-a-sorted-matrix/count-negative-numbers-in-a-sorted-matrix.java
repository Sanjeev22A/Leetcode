class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        int l=0,h=grid.length,mid=0;
        while(l<h){
            mid=(l+h)/2;
            if(grid[mid][0]>=0){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        System.out.println(l+":"+h+":"+mid);
        count+=grid[0].length*(grid.length-l);
        for(int i=0;i<l;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<0){
                    count+=(grid[i].length-j);
                    break;
                }
            }
        }
        return count;
    }
}