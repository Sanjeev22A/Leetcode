class Solution {
    public int tupleSameProduct(int[] nums) {
        List<Long> arr=new ArrayList<>();
        int firstIndex=0,secondIndex;
        for(firstIndex=0;firstIndex<nums.length-1;firstIndex++){
            for(secondIndex=firstIndex+1;secondIndex<nums.length;secondIndex++){
                long product=nums[firstIndex]*nums[secondIndex];
                arr.add(product);
            }
        }
        int result=0;
        Collections.sort(arr);
        long lastProductSeen=-1;
        long currentProductSeen=0;
        int count=0;
        for(int i=0;i<arr.size();i++){
            currentProductSeen=arr.get(i);
            if(currentProductSeen==lastProductSeen){
                count++;
            }else{
                lastProductSeen=currentProductSeen;
                result+=(count*(count-1))*4;
                count=1;
            }
        }
        result+=(count*(count-1))*4;
        return result;

        
    }
}