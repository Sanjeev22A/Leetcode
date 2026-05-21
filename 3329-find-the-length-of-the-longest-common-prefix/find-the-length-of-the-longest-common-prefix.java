class Solution {
    List<Integer> getAllPrefix(int a){
        List<Integer> ans=new ArrayList<>();
        String s=Integer.toString(a);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            ans.add(Integer.parseInt(sb.toString()));
        }
        return ans;
    }
    void addPrefix(int a,Set<Integer> s1){
        List<Integer> prefix=getAllPrefix(a);
        for(int b:prefix){
            s1.add(b);
        }
    }
    int length(int b){
        int i=0;
        while(b>0){
            b/=10;
            i++;
        }
        return i;
    }
    int getMaxLength(int a,Set<Integer> s1){
        int max=0;
        List<Integer> prefix=getAllPrefix(a);
        for(int b:prefix){
            if(s1.contains(b)){
                max=Math.max(max,length(b));
            }
        }
        return max;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> s1=new HashSet<>();
        for(int a:arr1){
            addPrefix(a,s1);
        }
        int max=0;
        for(int a:arr2){
            max=Math.max(max,getMaxLength(a,s1));
        }
        return max;
    }
}