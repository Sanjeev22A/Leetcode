class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int x1=Math.abs(a-x);
            int x2=Math.abs(b-x);
            if(x1!=x2){
                return x2-x1;
            }else{
                return b-a;
            }
        });
        for(int a:arr){
            if(pq.size()==k){
                pq.offer(a);
                pq.poll();
            }else{
                pq.offer(a);
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int a:pq){
            result.add(a);
        }
        Collections.sort(result);
        return result;
    }
}