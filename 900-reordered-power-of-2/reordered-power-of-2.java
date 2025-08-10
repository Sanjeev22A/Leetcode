
class Solution {

    int numDigits(int num){
        int count=0;
        while(num>0){
            count++;
            num/=10;
        }
        return count;
    }
    int[] digitCount(int num){
        int[] digit=new int[10];
        while(num>0){
            int rem=num%10;
            digit[rem]++;
            num/=10;
        }
        return digit;
    }
    boolean equals(int[] a1,int[] a2){
        for(int i=0;i<10;i++){
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }
    boolean normalize(int a,int b){
        int[] a1=digitCount(a);
        int[] a2=digitCount(b);
        return equals(a1,a2);
    }
    int minPower2(int val){
        for(int i=31;i>=0;i--){
            if((val&(1<<i))>0){
                return 1<<(i);
            }
        }
        return -1;
    }
    public boolean reorderedPowerOf2(int n) {
        int count=numDigits(n);
        int min=(int)Math.pow(10,count-1);
        
        min=minPower2(min);
        int max=(int)Math.pow(10,count);
        System.out.println(min+":"+max);
        for(long i=(long)min;i<=max;i*=(long)2){
            if(normalize(n,(int)i)){
                return true;
            }
        }
        return false;

    }
}