class Solution {
    int floor(int n,int k){
        return n/k;
    }
    public String longestSubsequenceRepeatedK(String s, int k) {
        char[] map=new char[26];
        List<Character> permissible=new ArrayList<>();
        for(char c:s.toCharArray()){
            map[c-'a']++;
            
        }
        for(int i=0;i<26;i++){
            if(map[i]>=k){
                permissible.add((char)('a'+i));
            }
        }
        if(permissible.size()==0){
            return "";
        }
        int n=s.length();
        int ansLength=n/k;

        Queue<String> q=new LinkedList<>();
        for(char c:permissible){
            q.offer(c+"");
        }
        String ans="";
        String cur="";
        while(!q.isEmpty()){
            cur=q.poll();
            if(cur.length()>ansLength){
                return ans;
            }
            ans=cur;
            for(char c:permissible){
                if(ifPresent(s,cur+c,k)){
                    q.offer(cur+c);
                }
            }
            
        }
        return ans;



    }
    
    boolean ifPresent(String s,String t,int k){
        int pos=0;
        int count=0;
        for(char c:s.toCharArray()){
            if(c==t.charAt(pos)){
                pos++;
            }

            if(pos==t.length()){
                count++;
                pos=0;
            }
            if(count>=k){
                return true;
            }
        }
        if(count>=k){
            return true;
        }
        return false;

    }
}