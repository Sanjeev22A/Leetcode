class Solution {
    int convert(int num){
        
        List<Integer> temp=new ArrayList<>();
        while(num>0){
            temp.add(num%10);
            num/=10;
        }
        int ans=0;
        boolean flag=false;
        for(int i=temp.size()-1;i>=0;i--){
            int rem=temp.get(i);
            if(rem==6 && !flag){
                ans=ans*10+9;
                flag=true;
            }else{
                ans=ans*10+rem;
            }
        }
        return ans;
    }
    public int maximum69Number (int num) {
        return convert(num);
    }
}