class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permutate(nums);
    }
    List<List<Integer>> permutate(int[] nums){
        if(nums.length==1){
            List<List<Integer>> arr=new ArrayList<>();
            List<Integer> a=new ArrayList<>();
            a.add(nums[0]);
            arr.add(a);
            return arr;
            
        }else{
            int start=nums[0];
            int[] newList=new int[nums.length-1];
            for(int i=1;i<nums.length;i++){
                newList[i-1]=nums[i];
            }
            List<List<Integer>> res=permutate(newList);
            List<List<Integer>> result=new ArrayList<>();
            for(List<Integer> a:res){
                for(int i=0;i<=a.size();i++){
                    List<Integer> temp=new ArrayList<>(a);

                    temp.add(i,start);
                    result.add(temp);
                }

            }
            return result;
        }
    }
    
}