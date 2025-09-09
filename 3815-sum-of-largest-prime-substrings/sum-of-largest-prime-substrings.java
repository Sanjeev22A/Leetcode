class Solution {
    Set<Long> subStrings;
    boolean isPrime(Long a){
        if(a==1L)return false;
        for(int i=2;i<=Math.pow(a,0.5);i++){
            if(a%i==0)return false;
        }
        return true;
    }
    void generate(String s){
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                Long a=Long.parseLong(s.substring(i,j+1));
                subStrings.add(a);
            }
        }
    }
    public long sumOfLargestPrimes(String s) {
        subStrings=new HashSet<>();
        generate(s);
        List<Long> ls=new ArrayList<>(subStrings);
        Collections.sort(ls,(a,b)->(Long.compare(b,a)));
        long ans=0L;
        int count=0;
        for(long a:ls){
            if(isPrime(a)){
                //System.out.println(a);
                ans+=a;
                count++;
            }
            if(count==3){
                break;
            }
        }
        

        return ans;
    }
}