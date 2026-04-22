class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        for(String a:queries){
            for(String b:dictionary){
                if(match(a,b)){
                    ans.add(a);
                    break;
                }
            }
        }
        return ans;
   }

   private boolean match(String a,String b){
    int count=0;
    if(a.length()!=b.length()){
        return false;
    }
    for(int i=0;i<a.length();i++){
        if(a.charAt(i)!=b.charAt(i)){
            count++;
        }
        if(count>2){
            return false;
        }
    }
    return true;
   }
}