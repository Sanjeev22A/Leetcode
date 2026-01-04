class Solution {
    int divSum(int a){
        int divCount=0;
        int sum=0;
        for(int i=1;i<=Math.pow(a,0.5);i++){
            
            if(a%i==0){
                divCount++;
                sum+=i;
                int q=a/i;
                if(q!=i){
                    divCount++;
                    sum+=q;
                }
                
                
            }
            if(divCount>4){
                return 0;
            }
        }
        if(divCount!=4){
            return 0;
        }
        return sum;
    }
    public int sumFourDivisors(int[] nums) {
        Set<Integer> notFourDiv=new HashSet<>();
        Map<Integer,Integer> divSumMap=new HashMap<>();
        int ans=0;
        for(int a:nums){
            if(notFourDiv.contains(a)){
                continue;
            }
            if(divSumMap.containsKey(a)){
                ans+=divSumMap.get(a);
                continue;
            }
            int divSum=divSum(a);
            System.out.println(divSum+":"+a);
            ans+=divSum;
            if(divSum==0){
                notFourDiv.add(a);
            }
            else{
                divSumMap.put(a,divSum);
            }
        }
        return ans;
    }
}