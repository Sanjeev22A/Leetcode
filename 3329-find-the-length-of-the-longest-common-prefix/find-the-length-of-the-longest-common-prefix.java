class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> prefixes=new HashSet<>();
        for(int e:arr1){
            String prefix="";
            for(char c:String.valueOf(e).toCharArray()){
                prefix+=c;
                prefixes.add(prefix);
            }
        }
        int maxLength=0;
        for(int e:arr2){
            String prefix="";
            for(char c:String.valueOf(e).toCharArray()){
                prefix+=c;
                if(prefixes.contains(prefix)){
                    maxLength=Math.max(maxLength,prefix.length());
                }
            }
        }
        return maxLength;
    }
}