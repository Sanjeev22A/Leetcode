class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> cur,prev,uniques;
        prev=new HashSet<>();
        uniques=new HashSet<>();
        for(int a:arr){
            cur=new HashSet<>();
            prev.add(0);
            for(int b:prev){
                cur.add(a|b);
                uniques.add(a|b);
            }
            prev=cur;
        }
        return uniques.size();
    }
}