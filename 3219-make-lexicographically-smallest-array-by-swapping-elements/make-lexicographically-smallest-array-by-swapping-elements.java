class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        Map<Integer,Integer> groupId=new HashMap<>();
        Map<Integer,LinkedList<Integer>> groups=new HashMap<>();
        int currentGroup=0;
        int[] newArr=new int[nums.length];
        for(int i=0;i<nums.length;i++){newArr[i]=nums[i];}
        Arrays.sort(newArr);
        int prev=0;
        for(int a:newArr){
            if(prev==0){
                prev=a;
                groupId.put(a,currentGroup);
                groups.put(currentGroup,new LinkedList<>());
                groups.get(currentGroup).add(a);
            }else if(a-prev<=limit){
                prev=a;
                groupId.put(a,currentGroup);
                groups.get(currentGroup).add(a);
            }
            else{
                prev=a;
                currentGroup++;
                groupId.put(a,currentGroup);
                groups.put(currentGroup,new LinkedList<>());
                groups.get(currentGroup).add(a);
            }
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            int gid=groupId.get(a);
            int b=groups.get(gid).poll();
            nums[i]=b;
            
        }
        return nums;
    }
   
}