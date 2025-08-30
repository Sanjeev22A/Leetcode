class Solution {
    public int distributeCandies(int[] candyType) {
        int distinctCount=0;
        Set<Integer> s=new HashSet<>();
        for(int a:candyType){
            if(!s.contains(a)){
                s.add(a);
                distinctCount++;
            }
        }
        return Math.min(distinctCount,candyType.length/2);
    }
}