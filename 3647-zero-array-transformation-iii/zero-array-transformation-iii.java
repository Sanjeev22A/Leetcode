class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        int[] decArray=new int[nums.length+1];
        int j=0;
        int dec=0;
        for(int i=0;i<nums.length;i++){
            dec+=decArray[i];
            while(j<queries.length && queries[j][0]==i){
                System.out.println(queries[j][1]);
                heap.offer(queries[j][1]);
                j++;
            }
            while(dec<nums[i] && !heap.isEmpty() && heap.peek()>=i){  //Heap.peak()>=i is marking the condition where we have queries spanning to the current index to decrement
                dec+=1;
                decArray[heap.poll()+1]-=1;
            }
            
            if(nums[i]>dec){
                return -1;
            }
        }
        return heap.size();
    }
}