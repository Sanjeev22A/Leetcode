class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited=new boolean[arr.length];
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int cur=q.poll();
            
            if(arr[cur]==0){
                
                return true;
            }
            visited[cur]=true;
            int left=cur-arr[cur];
            int right=cur+arr[cur];

            
            if(left>=0 && left<arr.length && !visited[left]){
                visited[left]=true;
                q.offer(left);
            }
            if(right>=0 && right<arr.length && !visited[right]){
                visited[right]=true;
                q.offer(right);
            }
        }
        return false;
    }
}