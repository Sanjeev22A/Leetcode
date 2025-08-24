class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry=0;
        for(int i=num.length-1;i>=0;i--){
            int rem=k%10;
            int peek=num[i]+carry+rem;
            num[i]=peek%10;
            carry=peek/10;
            k=k/10;
            if(carry==0 && k==0){
                break;
            }
        }
        if(k>0){
            carry+=k;
        }
        List<Integer> res=new ArrayList<>();
        while(carry>0){
            res.add(carry%10);
            carry/=10;
        }
        Collections.reverse(res);
        for(int a:num){
            res.add(a);
        }
        return res;
    }
}