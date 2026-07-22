class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> frnds=new HashSet<>();
        for(int a:friends){
            frnds.add(a);
        }
        int[] res=new int[friends.length];
        int 
    i=0;
        for(int a:order){
            if(frnds.contains(a)){
                res[i++]=a;
            }
        }
        return res;
    }
}