class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int val=0;
        for(int a:derived){
            val=val^a;
        }
        return val==0;
    }
}