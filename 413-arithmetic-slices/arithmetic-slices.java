class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int[] difLength=new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            difLength[i-1]=nums[i]-nums[i-1];
        }
        int ans=0;
        int curCount=0;
        for(int i=0;i<difLength.length-1;i++){
            if(difLength[i]==difLength[i+1]){
                curCount++;
            }else{
                curCount+=2;
                System.out.println(curCount);
                for(int j=3;j<=curCount;j++){
                    ans+=(curCount-j+1);
                }
                curCount=0;
            }
        }
        if(curCount!=0){
            curCount+=2;
            System.out.println(curCount);
            for(int j=3;j<=curCount;j++){
                ans+=(curCount-j+1);
            }
            curCount=0;
        }
        return ans;
    }
}