class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        Map<Integer,Integer> numMap=new HashMap<>();
        for(int a:nums){
            numSet.add(a);
        }
        int max=0;
        for(int a:numSet){
            if(numMap.containsKey(a)){
                continue;
            }
            
            int count=1;
            int b=a;
            while(numSet.contains(b-1)){
                if(numMap.containsKey(b-1)){
                    count=count+numMap.get(b-1);
                    break;
                }
                count++;
                b--;
            }
            max=Math.max(max,count);
            b=a;
            for(int i=count;i>0;i--){
                if(numMap.containsKey(b)){
                    break;
                }
                numMap.put(b,i);
                b--;
            }

        }
        return max;

    }
}