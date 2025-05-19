class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l,h,mid;
        l=0;
        h=letters.length;
        while(l<h){
            mid=(l+h)/2;
            if(letters[mid]<=target){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return letters[l%letters.length];
    }
}