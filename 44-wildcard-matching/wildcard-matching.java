class Solution {
    Map<String,Boolean> cache;
    boolean match(String s,int i,int j,String p){
        String key=i+":"+j;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        if(i>=s.length() && j>=p.length()){
            cache.put(key,true);
            return true;
        }

        if(j>=p.length()){
            cache.put(key,false);
            return false;
        }
        if(i>=s.length()){
            boolean flag=true;
            for(int k=j;k<p.length();k++){
                if(p.charAt(k)!='*'){
                    cache.put(key,false);
                    return false;
                }
            }
            cache.put(key,true);
            return true;
        }
        if(s.charAt(i)==p.charAt(j)){
            cache.put(key,match(s,i+1,j+1,p));
            return cache.get(key);
        }
        else if(p.charAt(j)=='?'){
            return match(s,i+1,j+1,p);
        }else if(p.charAt(j)=='*'){
            boolean flag=false;
            for(int k=i;k<=s.length();k++){
                flag=flag|match(s,k,j+1,p);
                
            }
            cache.put(key,flag);

            return flag;

        }
        cache.put(key,false);
        return false;
    }
    public boolean isMatch(String s, String p) {
        cache=new HashMap<>();
        return match(s,0,0,p);
    }
}