class Solution {
    int[] weights;
    int idx(char c){
        return (int)(c-'a');
    }
    char map(int x){
        x=x%26;
        return (char)('a'+(25-x));
    }
    char convert(String s){
        int total=0;
        for(char c:s.toCharArray()){
            total+=weights[idx(c)];

        }
        return map(total);
    }
    public String mapWordWeights(String[] words, int[] weights) {
        this.weights=weights;
        StringBuilder sb=new StringBuilder();
        for(String s:words){
            sb.append(convert(s));
        }
        return sb.toString();
    }
}