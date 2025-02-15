class Solution {

    public boolean findPartitions(String num,int target){
        if(num.length()==0 && target==0){return true;}
        if(target<0){return false;}
        boolean key=false;
        for(int index=0;index<num.length();index++){
            String left=num.substring(0,index+1);
            String right=num.substring(index+1,num.length());
            key=key|| findPartitions(right,target-Integer.parseInt(left));
            if(key){return key;}
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            int a=i*i;
            if(findPartitions(String.valueOf(a),i)){
                sum+=a;
            }
        }
        return sum;
    }
}