class Solution {
    int GCD(int a,int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        if(a==b){
            return a;
        }
        int r=a%b;
        while(r!=0){
            a=b;
            b=r;
            r=a%b;
        }
        return b;
    }
    int LCM(int a,int b,int gcd){
        return (int)(((long)a*(long)b)/(long)gcd);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st=new Stack<>();

        for(int a:nums){
            if(st.isEmpty()){
                st.push(a);
            }else{
                st.push(a);
                while(true){
                    int top1=st.pop();
                    if(st.isEmpty()){
                        st.push(top1);
                        break;
                    }
                    int top2=st.pop();
                    int gcd=GCD(top1,top2);
                    if(gcd<=1){
                        st.push(top2);
                        st.push(top1);
                        break;
                    }else{
                        int lcm=LCM(top1,top2,gcd);
                        st.push(lcm);
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }
}