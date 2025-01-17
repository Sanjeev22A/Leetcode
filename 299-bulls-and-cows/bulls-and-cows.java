class Solution {
    public String getHint(String secret, String guess) {
        int bull=0,cow=0;
        Map<Character,Integer> bullMap=new HashMap<>();
        Map<Character,Integer> cowMap=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<secret.length();i++){
            bullMap.put(secret.charAt(i),bullMap.getOrDefault(secret.charAt(i),0)+1);
            cowMap.put(guess.charAt(i),cowMap.getOrDefault(guess.charAt(i),0)+1);
            set.add(guess.charAt(i));
            if(guess.charAt(i)==secret.charAt(i)){
                bull++;
            }
        }
        for(char c:set){
            cow+=Math.min(cowMap.getOrDefault(c,0),bullMap.getOrDefault(c,0));
        }
        cow-=bull;
        return bull+"A"+cow+"B";
    }
}