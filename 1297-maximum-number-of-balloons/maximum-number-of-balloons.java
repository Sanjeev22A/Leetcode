class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        for(char c:text.toCharArray()){
            if(c=='b'){
                b++;
            }else if(c=='a'){
                a++;
            }else if(c=='l'){
                l++;
            }else if(c=='o'){
                o++;
            }else if(c=='n'){
                n++;
            }
        }
        int[] arr=new int[]{b,a,l/2,o/2,n};
        int min=Integer.MAX_VALUE;
        for(int d:arr){
            min=Math.min(min,d);
        }
        return min;
    }
}