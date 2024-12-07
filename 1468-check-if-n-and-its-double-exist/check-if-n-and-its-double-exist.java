class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> numsMap=new HashSet<>();
        for(int a:arr){
            
            if(numsMap.contains(a*2)){
                return true;
            }
            if(a%2==0 && numsMap.contains(a/2)){
                return true;
            }
            numsMap.add(a);
        }
        return false;
    }
}