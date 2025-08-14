class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] temp=new int[trips.length*2][2];
        int i=0;
        for(int[] a:trips){
            temp[i++]=new int[]{a[0],a[1]};
            temp[i++]=new int[]{-a[0],a[2]};
        }

        Arrays.sort(temp,(a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            else{
                return a[0]-b[0];
            }
        });
        int count=0;
        for(int[] a:temp){
            count+=a[0];
            if(count>capacity){
                return false;
            }
        }
        return true;
    }
}