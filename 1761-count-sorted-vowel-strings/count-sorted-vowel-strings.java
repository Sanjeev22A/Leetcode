class Solution {
    int dfs(int curCharacter,int curDepth,int n){
        if(curDepth>=n){
            return 1;
        }
        if(curCharacter=='a'){
            return dfs('a',curDepth+1,n)+dfs('e',curDepth+1,n)+dfs('i',curDepth+1,n)+dfs('o',curDepth+1,n)+dfs('u',curDepth+1,n);
        }
        else if(curCharacter=='e'){
            return dfs('e',curDepth+1,n)+dfs('i',curDepth+1,n)+dfs('o',curDepth+1,n)+dfs('u',curDepth+1,n);
        }else if(curCharacter=='i'){
            return dfs('i',curDepth+1,n)+dfs('o',curDepth+1,n)+dfs('u',curDepth+1,n);
        }else if(curCharacter=='o'){
            return dfs('o',curDepth+1,n)+dfs('u',curDepth+1,n);
        }else{
            return dfs('u',curDepth+1,n);
        }
    }
    public int countVowelStrings(int n) {
        return dfs('a',0,n);
    }
}