class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        List<int[]> arr=new ArrayList<>();
        Map<Integer,Integer> freqMap=new HashMap<>();
        for(int a:nums){
            freqMap.put(a,freqMap.getOrDefault(a,0)+1);
            arr.add(new int[]{a-k,1});
            arr.add(new int[]{a,0});
            arr.add(new int[]{a+k+1,-1});
        }
        Collections.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int runningSum=0;
        int max=0;
        for(int[] a:arr){
            runningSum+=a[1];
            int opCount=runningSum-freqMap.getOrDefault(a[0],0);
            if(opCount>numOperations){
                max=Math.max(numOperations+freqMap.getOrDefault(a[0],0),max);
            }else{
                max=Math.max(runningSum,max);
            }
        }
        return max;
    }
}