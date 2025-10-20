class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String a:operations){
            if(a.equals("--X")){
                --x;
            }else if(a.equals("X--")){
                x--;
            }else if(a.equals("++X")){
                ++x;
            }else if(a.equals("X++")){
                x++;
            }
        }
        return x;
    }
}