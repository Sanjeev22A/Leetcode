class Solution {

    public int maxProduct(int n) {
        List<Integer> digits=new ArrayList<>();
        while(n>0){
            int c=n%10;
            digits.add(c);
            n/=10;
        }
        Collections.sort(digits);
        int len=digits.size();
        return digits.get(len-2)*digits.get(len-1);
    }
}