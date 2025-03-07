class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] marker=new int[right+1];
        List<Integer> array=new ArrayList<>();
        for(int i=2;i<right+1;i++){
            if(marker[i]==0){
                if(i>=left){
                    array.add(i);
                }
                marker[i]=1;
                long j=(long)i*i;
                
                while(j<=right){
                    marker[(int)j]=2;
                    j=j+i;
                }
            }
        }
        if(array.size()<2){
            return new int[]{-1,-1};
        }
        int[] pair=new int[2];
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<array.size()-1;i++){
            int d=array.get(i+1)-array.get(i);
            if(d<diff){
                diff=d;
                pair[0]=array.get(i);
                pair[1]=array.get(i+1);
            }
        }
        return pair;
    }
}