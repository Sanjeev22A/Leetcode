class Solution {
    int getDigitSum(int a){
        int s=0;
        while(a>0){
            s+=(a%10);
            a=a/10;
        }
        return s;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxVal=0;
        for(int i=1;i<=n;i++){
            int digSum=getDigitSum(i);
            map.put(digSum,map.getOrDefault(digSum,0)+1);
            maxVal=Math.max(maxVal,map.get(digSum));
        }
        int c=0;
        for(Map.Entry<Integer,Integer> a:map.entrySet()){
            if(a.getValue()==maxVal){
                c++;
            }
        }
        return c;
    }
}