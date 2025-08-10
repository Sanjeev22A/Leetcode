class Solution {
    public int minimumSum(int num) {
        List<Integer> digits=new ArrayList<>();
        while(num>0){
            digits.add(num%10);
            num=num/10;
        }
        Collections.sort(digits);
        int a=digits.get(0);
        int b=digits.get(1);
        a=a*10+digits.get(3);
        b=b*10+digits.get(2);
        //System.out.println(a+":"+b);
        return a+b;

    }
}