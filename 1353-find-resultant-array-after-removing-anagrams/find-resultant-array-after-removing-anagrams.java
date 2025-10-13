class Solution {
    String createHashCode(String s){
        int[] c=new int[26];
        for(char d:s.toCharArray()){
            c[d-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int a:c){
            sb.append(a+"#");
        }
        return sb.toString();
    }
    public List<String> removeAnagrams(String[] words) {
        boolean[] marked=new boolean[words.length];
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(marked[i]){
                continue;
            }
            String a=createHashCode(words[i]);
            res.add(words[i]);
            for(int j=i+1;j<words.length;j++){
                String b=createHashCode(words[j]);
                if(a.equals(b)){
                    marked[j]=true;
                }else{
                    break;
                }
            }
        }
        return res;
    }
}