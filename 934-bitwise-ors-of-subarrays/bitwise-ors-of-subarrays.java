class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> cur,prev,unique;
        
        prev=new HashSet<>();
        unique=new HashSet<>();
        for(int a:arr){
            cur=new HashSet<>();
            prev.add(0); //To include only one element
            for(int b:prev){
                cur.add(b|a);
                unique.add(b|a);
            }
            prev=cur;

        }
        return unique.size();
    }
}