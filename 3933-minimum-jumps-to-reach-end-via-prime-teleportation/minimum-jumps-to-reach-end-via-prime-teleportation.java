class Solution {
    boolean[] isPrime;
    void makePrimes(){
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        for(int i=2;i<=Math.pow(isPrime.length,0.5);i++){
            if(isPrime[i]){
                for(int j=i*i;j<isPrime.length;j+=i){
                    isPrime[j]=false;
                }
            }
        }
    }
    boolean isPrime(int a){
        return isPrime[a];
    }
    public int minJumps(int[] nums) {
        int max=0;
        for(int a:nums){
            max=Math.max(a,max);
        }
        int n=nums.length;
        isPrime=new boolean[max+1];
        makePrimes();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        boolean[] visited=new boolean[nums.length];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                int cur=q.poll();
                if(cur==n-1){
                    return steps;
                }
                visited[cur]=true;
                if(cur>0 && !visited[cur-1]){
                    visited[cur-1]=true;
                    q.offer(cur-1);
                }
                if(cur<nums.length-1 && !visited[cur+1]){
                    visited[cur+1]=true;
                    q.offer(cur+1);
                }
                //System.out.println(isPrime(nums[cur]));
                if(isPrime(nums[cur])){
                    
                    for(int i=nums[cur];i<max+1;i+=nums[cur]){
                        if(map.containsKey(i)){
                            for(int idx:map.get(i)){
                                if(!visited[idx]){
                                    System.out.println(idx);
                                    visited[idx]=true;
                                    q.offer(idx);
                                }
                            }
                            map.remove(i);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
        
    }
}