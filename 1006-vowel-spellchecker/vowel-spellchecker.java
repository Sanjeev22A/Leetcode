class Solution {
    boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }
        return false;
    }
    String purifyVowels(String s){
        StringBuilder temp=new StringBuilder();
        s=s.toLowerCase();
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                temp.append('*');
            }else{
                temp.append(c);
            }
        }
        return temp.toString();
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactMatch=new HashSet<>();
        Map<String,String> lowerCaseMatch=new HashMap<>();
        Map<String,String> vowelModulation=new HashMap<>();
        for(String s:wordlist){
            exactMatch.add(s);
            String sLower=s.toLowerCase();
            lowerCaseMatch.putIfAbsent(sLower,s);
            String vowelRemoved=purifyVowels(s);
            vowelModulation.putIfAbsent(vowelRemoved,s);
        }
        String[] res=new String[queries.length];
        for(int i=0;i<queries.length;i++){
            String query=queries[i];
            String queryLower=query.toLowerCase();
            String vw=purifyVowels(query);
            if(exactMatch.contains(query)){
                res[i]=query;
            }else if(lowerCaseMatch.containsKey(queryLower)){
                res[i]=lowerCaseMatch.get(queryLower);
            }else if(vowelModulation.containsKey(vw)){
                res[i]=vowelModulation.get(vw);
            }else{
                res[i]="";
            }
        }
        return res;
    }
}