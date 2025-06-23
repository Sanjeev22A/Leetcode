class Solution {
    int floor(int n,int k){
        if(n%k==0){
            return n/k;
        }
        return n/k;
    }
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> res=new HashSet<>();
        int maj=floor(nums.length,3);
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
            if(map.get(a)>maj){
                res.add(a);
            }
        }
        return new ArrayList<>(res);
    }
}