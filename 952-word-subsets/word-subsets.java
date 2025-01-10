class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] check=new int[26];
        List<String> soln=new ArrayList<>();
        for(String w:words2){
            int[] temp=new int[26];
            for(char c:w.toCharArray()){
                temp[c-'a']++;
            }
            for(int i=0;i<26;i++){
                check[i]=Math.max(check[i],temp[i]);
            }
        }
        int i=0;
        for(String w:words1){
            int[] cur=new int[26];
            for(char c:w.toCharArray()){
                cur[c-'a']++;
            }
            boolean flag=true;
            for(i=0;i<26;i++){
                //System.out.println(check[i]+" : "+cur[i]+" : "+(char)(i+'a'));
                if(check[i]>cur[i]){
                    flag=false;
                }
            }
            if(flag){
                soln.add(w);
            }
        }
        return soln;
    }

}