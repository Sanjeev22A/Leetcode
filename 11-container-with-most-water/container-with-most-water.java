class Solution {
    int max(int a,int b){
        return a>b?a:b;
    }
    int min(int a,int b){
        return a<b?a:b;
    }
    public int maxArea(int[] height) {
     int a=0;
     int b=height.length-1;
     int start=a,end=b;
     while(a<b){
         if(height[a]<height[b]){
             a++;
         }
         else{
             b--;
         }
         if((b-a)*(min(height[a],height[b])) > (end-start)*(min(height[end],height[start]))){
             start=a;
             end=b;
         }
     }
        return (end-start)*(min(height[end],height[start]));
    }
}