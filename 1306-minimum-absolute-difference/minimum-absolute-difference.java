class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            minDiff=Math.min(arr[i+1]-arr[i],minDiff);
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            int diff=arr[i+1]-arr[i];
            if(diff==minDiff){
                List<Integer> temp=new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                res.add(temp);
            }
        }
        return res;
    }
}