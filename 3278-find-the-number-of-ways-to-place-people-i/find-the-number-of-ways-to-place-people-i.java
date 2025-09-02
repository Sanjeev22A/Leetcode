class Solution {
    public int numberOfPairs(int[][] points) {
        int count=0;
        for(int i=0;i<points.length;i++){
            int[] a=points[i];
            for(int j=0;j<points.length;j++){
                int[] b=points[j];
                if(i==j || !(b[0]<=a[0] && b[1]>=a[1])){
                    continue;
                }
                boolean flag=false;
                for(int k=0;k<points.length;k++){
                    int[] c=points[k];
                    if(i==k || j==k){
                        continue;
                    }
                    if(c[0]<=a[0] && c[1]>=a[1] && b[0]<=c[0] && b[1]>=c[1]){
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    count++;
                }
            }
        }
        return count;
    }
}