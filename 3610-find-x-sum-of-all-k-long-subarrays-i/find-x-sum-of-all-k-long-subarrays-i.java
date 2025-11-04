class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int[] answer=new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++){
            int[] count=new int[51];
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
                if(a[1]!=b[1]){
                    return Integer.compare(a[1],b[1]);
                }else{
                    return Integer.compare(a[0],b[0]);
                }
            });
            for(int j=i;j<i+k;j++){
                count[nums[j]]++;
            }
            for(int m=0;m<51;m++){
                int[] temp=new int[2];
                temp[0]=m;temp[1]=count[m];
                
                pq.offer(temp);
                if(pq.size()>x){pq.poll();}
            }
            int sum=0;
            while(!pq.isEmpty()){
                int[] a=pq.poll();
                sum+=a[0]*a[1];
            }
            answer[i]=sum;

        }
        return answer;
    }
}