class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> arr=new TreeMap<>();
        for(int[] a:nums1){
            arr.put(a[0],arr.getOrDefault(a[0],0)+a[1]);
        }
        for(int[] a:nums2){
            arr.put(a[0],arr.getOrDefault(a[0],0)+a[1]);
        }
        int[][] result=new int[arr.size()][2];
        int i=0;
        for(Map.Entry<Integer,Integer> e:arr.entrySet()){
            result[i][0]=e.getKey();
            result[i++][1]=e.getValue();
        }
        return result;
    }
}