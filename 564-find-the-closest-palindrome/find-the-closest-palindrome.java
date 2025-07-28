class Solution {
    long generatePalindrome(long num,boolean isEven){
        long ans=num;
        if(isEven){
     
            while(num>0){
                ans=ans*10+num%10;
                num=num/10;
            }
        }else{

            num=num/10;
            while(num>0){
                ans=ans*10+num%10;
                num=num/10;
            }
        }
        return ans;
    
    }
    public String nearestPalindromic(String n) {
        
        long num=Long.parseLong(n);
        if(num<=10){
            return String.valueOf(num-1);
        }
        if(num==11){
            return "9";
        }
        int length=n.length();
        List<Long> candidates=new ArrayList<>();
       
        
        long a1=(long)num/(long)(Math.pow(10,length/2));
        
        long a2=a1-1;
        long a3=a1+1;
        long num2=num-2;
        int length2=String.valueOf(num2).length();
        
        long num3=num+2;
        int length3=String.valueOf(num3).length();
        //t=length2%2==1?(length2+1)/2:length2/2;
        long a4=(long)num2/(long)(Math.pow(10,length2/2));

        long a5=a4-1;
        long a6=a4+1;
        //t=length3%2==1?(length3+1)/2:length3/2;
        long a7=(long)num3/(long)(Math.pow(10,length3/2));
        long a8=a7-1;
        long a9=a7+1;
        
        candidates.add(a1);
        candidates.add(a2);
        candidates.add(a3);
        candidates.add(a4);
        candidates.add(a5);
        candidates.add(a6);
        candidates.add(a7);
        candidates.add(a8);
        candidates.add(a9);
        long dif=Long.MAX_VALUE;
        long ans=0;
        int i=0;
        for(long a:candidates){
            int l=0;
            if(i<3){
                l=length;
            }else if(i<6){
                l=length2;
            }else{
                l=length3;
            }

            long numTemp=generatePalindrome(a,l%2==0);
            
            long tempDif=Math.abs(numTemp-num);
            
            if(tempDif>0){
                if(tempDif==dif && numTemp<ans){
                    ans=numTemp;
                }else if(tempDif<dif){
                    ans=numTemp;
                    dif=tempDif;
                }
            }
            i++;
        }
        return String.valueOf(ans);
    }
}