class Solution {
    Set<Integer> set;
    Map<Integer,Long> cache;

    
    long getReplacement(int a){
        if(cache.containsKey(a)){
            return cache.get(a);
        }
        int replacement=a;
        for(int i=1;i*i<=a;i++){
            if(a%i==0){
                int d1=i;
                int d2=a/i;
                if(set.contains(d1)){
                    replacement=Math.min(replacement,d1);
                }
                if(set.contains(d2)){
                    replacement=Math.min(replacement,d2);
                }
            }
        }
        cache.put(a,(long)replacement);
        return (long)replacement;
    }
    public long minArraySum(int[] nums) {
        set=new HashSet<>();
        cache=new HashMap<>();
        for(int a:nums){
            set.add(a);
        }
        long sum=0L;
        for(int a:nums){
            sum+=getReplacement(a);
        }
        return sum;

    }
}