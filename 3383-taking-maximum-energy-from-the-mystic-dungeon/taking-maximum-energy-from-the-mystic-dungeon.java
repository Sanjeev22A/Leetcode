class Solution {
    int[] energy;
    int k;
    
    public int maximumEnergy(int[] energy, int k) {
        this.energy=energy;
        this.k=k;
        int[] cache=new int[energy.length];
        int max=Integer.MIN_VALUE;
        for(int i=energy.length-1;i>=0;i--){
            int j=i+k;
            cache[i]=energy[i];
            if(j<energy.length){
                cache[i]+=cache[j];
            }
            max=Math.max(cache[i],max);
        }
        return max;
    }
}