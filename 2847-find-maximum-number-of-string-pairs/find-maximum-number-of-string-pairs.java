class Solution {
    String reverse(String a){
        StringBuilder c=new StringBuilder();
        for(int i=a.length()-1;i>=0;i--){
            c.append(a.charAt(i));
        }
        return c.toString();
    }
    public int maximumNumberOfStringPairs(String[] words) {
        int count=0;
        boolean[] marked=new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(marked[i]){
                continue;
            }
            String a=reverse(words[i]);
            for(int j=i+1;j<words.length;j++){
                if(a.equals(words[j]) && !marked[j]){
                    count++;
                    marked[i]=true;
                    marked[j]=true;
                    break;
                }
            }
        }
        return count;
    }
}