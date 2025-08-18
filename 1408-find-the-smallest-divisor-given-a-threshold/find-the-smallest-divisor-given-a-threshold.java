class Solution {
    int ceil(int a,int b){
        if(a%b==0){
            return a/b;
        }
        return a/b+1;
    }
    int max_arr(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int a:nums){
            max=Math.max(a,max);
        }
        return max;
    }
    int output(int[] nums,int limit){
        int sum=0;
        for(int a:nums){
            sum+=ceil(a,limit);
        }
        return sum;
        
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int smallest=1,largest=max_arr(nums);
        int ans=-1;
        while(smallest<=largest){
            int mid=smallest+(largest-smallest)/2;
            int thresh=output(nums,mid);
            if(thresh<=threshold){
                ans=mid;
                largest=mid-1;
            }else{
                smallest=mid+1;
            }
        }
        return ans;
    }
}