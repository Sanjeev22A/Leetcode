class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=0;
        int maxVal=0;
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            if(e.getValue()%2==0){
                count+=e.getValue();
            }
            else{
                if(maxVal<e.getValue()){
                    maxVal=e.getValue();
                    
                }
                count+=e.getValue()-1;
            }
            
        }
        if(maxVal==0){
            return count;
        }
        return count+1;
    }
}