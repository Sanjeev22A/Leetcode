class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            int rem=target-numbers[i];
            if(map.containsKey(rem) && i!=map.get(rem)){
                int index=map.get(rem);
                return new int[]{index+1,i+1};
            } 
            map.put(numbers[i],i);
            
           
        }
        return null;
    }
}