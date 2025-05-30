class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] arr=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int spell=spells[i];
            int left=0,right=potions.length-1;
            while(left<=right){
                int mid=(left+right)/2;
                long product=(long)spell*potions[mid];
                if(success<=product){right=mid-1;}
                else{left=mid+1;}
            }
            arr[i]=potions.length-left;
        }
        return arr;
    }
}