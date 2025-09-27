class Solution {
    double dist(int[] p1,int[] p2){
        return Math.pow(Math.pow(p1[0]-p2[0],2)+Math.pow(p1[1]-p2[1],2),0.5);
    }
    double Area(int[] p1,int[] p2,int[] p3){
        double s1=dist(p1,p2);
        double s2=dist(p2,p3);
        double s3=dist(p3,p1);
        double s=(s1+s2+s3)/2;
        double val=s*(s-s1)*(s-s2)*(s-s3);
        if(val<=0){
            return 0.0;
        }
        return Math.pow(val,0.5);
    }
    public double largestTriangleArea(int[][] points) {
        double area=0.0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=j+1;k<points.length;k++){
                    double temp=Area(points[i],points[j],points[k]);
                    area=Math.max(temp,area);
                }
            }
        }
        if(area<0.0){
            return 0.0;
        }
        return area;
    }
}