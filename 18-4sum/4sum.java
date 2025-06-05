class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int k=j+1,r=n-1;
                while(k<r){
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[r];
                    if(sum==target){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[r]);
                        res.add(temp);
                        k++;
                        while(k<r && nums[k]==nums[k-1]){
                            k++;
                        }
                        r--;
                        while(k<r && nums[r]==nums[r+1]){
                            r--;
                        }
                    }
                    else if(sum<target){
                        k++;
                        while(k<r && nums[k]==nums[k-1]){
                        k++;
                    }
                    }
                    else{
                        r--;
                        while(k<r && nums[r]==nums[r+1]){
                        r--;
                        }
                    }
                    
                    
                    
                }
            }

        }
        return res;
    }
}