class Solution {
    int getLength(int num,Map<Integer,Integer> count){
        long b=(long)num;
        if(num==1){
            int c=count.getOrDefault(num,0);
            if(c%2==0){
                return c-1;
            }
            return c;
        }
        int i=0;
        boolean flag=false;
        while(true){
            if(b>Integer.MAX_VALUE){
                flag=true;
                break;
            }
            Integer d=count.getOrDefault((int)b,null);
            if(d==null){
                flag=true;
                break;
            }
            if(count.get((int)b)==1){
                break;
            }else{
                i+=1;
            }
            b=b*b;
        }
        if(flag){
            return 2*(i-1)+1;
        }
        return 2*i+1;
    }
    public int maximumLength(int[] nums) {
       Map<Integer,Integer> count=new HashMap<>();
       for(int a: nums){
        count.put(a,count.getOrDefault(a,0)+1);
       }
       int ans=1;
       for(Map.Entry<Integer,Integer> e:count.entrySet()){
            ans=Math.max(ans,getLength(e.getKey(),count));
       }
       return ans;
    }
}