class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int a=spells[i];
            int start=0,end=potions.length-1;
            int ans=potions.length;
            while(start<=end){
                int mid=start+(end-start)/2;
                long val=(long)a*(long)potions[mid];
              
                if(val>=(long)success){
                    ans=mid;
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            res[i]=potions.length-ans;
        }
        return res;
    }
}