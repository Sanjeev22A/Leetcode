class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int dist=0;
        int i=nums1.length-1;
        for(int j=nums2.length-1;j>=0 && i>=0;j--){
            
            while(i>=0 && nums1[i]<=nums2[j]){
                dist=Math.max(j-i,dist);
                i--;
            }

            
            
        }
        return dist;
    }
}