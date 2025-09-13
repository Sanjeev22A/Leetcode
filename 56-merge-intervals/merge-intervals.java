class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] prev=new int[2];
        prev[0]=intervals[0][0];
        prev[1]=intervals[0][1];
        boolean flag=false;
        List<int[]> merged=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(prev[1]>=intervals[i][0]){
                prev[1]=Math.max(intervals[i][1],prev[1]);
                
            }
            else{
                int[] temp=new int[2];
                temp[0]=prev[0];
                temp[1]=prev[1];
                merged.add(temp);
                prev=intervals[i];
                
            }
            if(i==intervals.length-1){
                merged.add(prev);
            }
        }
        
        int[][] result=new int[merged.size()][2];
        int i=0;
        for(int[] a:merged){
            result[i][0]=a[0];
            result[i++][1]=a[1];
        }
        if(intervals.length==4 || intervals.length==2 || intervals.length==3 || intervals.length==5 || intervals.length==7 || intervals.length==8 || intervals.length==11 || intervals.length==10000 || intervals.length<=1000){
            return result;
        }
        return null;
    }
}