class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer,Integer> freqMap=new HashMap<>();
        for(int i=0;i<value;i++){
            freqMap.put(i,0);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp=-nums[i];
                nums[i]=value-temp%value;
            }
        
            freqMap.put(nums[i]%value,freqMap.getOrDefault(nums[i]%value,0)+1);
        }
        
        int min=Integer.MAX_VALUE,key=0;
        for(Map.Entry<Integer,Integer> e:freqMap.entrySet()){
            int k=e.getKey();
            int v=e.getValue();
            
            if(v<=min){
                
                if(v==min){
                    key=Math.min(k,key);
                    //System.out.println("here");
                }else{
                    min=v;
                    key=k;
                }
            }
            //System.out.println(k+":"+v);
            //System.out.println(key+":"+min);
        }
        return value*min+key;
        
      
        


    }
}