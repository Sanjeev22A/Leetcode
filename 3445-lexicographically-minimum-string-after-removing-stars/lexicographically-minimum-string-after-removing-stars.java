class Solution {
    public String clearStars(String s) {
        List<Stack<Integer>> buckets=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<26;i++){
            buckets.add(new Stack<>());

        }
        boolean[] toRemove=new boolean[n];
        int i=0;
        char smallest='z'+1;
        
        int j=0;
        smallest='z'+1;
        for(char c:s.toCharArray()){
            if(c!='*'){
                buckets.get(c-'a').push(j);
            }
            if(c=='*'){
                toRemove[j]=true;
                for(i=0;i<26;i++){
                    if(!buckets.get(i).isEmpty()){
                        int index=buckets.get(i).pop();
                        toRemove[index]=true;
                        break;
                    }
                }
                
            }
            j++;
        }
        StringBuilder res=new StringBuilder();
        i=0;
        for(i=0;i<n;i++){
            if(!toRemove[i]){
                res.append(s.charAt(i));
            }
        }
        return res.toString();


    }
}