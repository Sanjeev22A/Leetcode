class Solution {
    Double esp=Math.pow(10,-4);
    boolean canGet(List<Double> arr){
        if(arr.size()==1){
            if(Math.abs(arr.get(0)-24.0)<esp){
                
                return true;
            }
            System.out.println(arr.get(0));
            return false;
        }
        boolean flag=false;
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<i;j++){
                double v1=arr.get(i),v2=arr.get(j);
                arr.remove(i);
                arr.remove(j);
                //Trying addition
                arr.add(v1+v2);
                flag=flag | canGet(arr);
                arr.remove(arr.size()-1);

                //Trying subtraction
                arr.add(v1-v2);
                flag=flag|canGet(arr);
                arr.remove(arr.size()-1);
                arr.add(v2-v1);
                flag=flag|canGet(arr);
                arr.remove(arr.size()-1);

                //Trying multiplication
                arr.add(v1*v2);
                flag=flag|canGet(arr);
                arr.remove(arr.size()-1);

                if(v1>esp){
                    arr.add(v2/v1);
                    flag=flag|canGet(arr);
                    arr.remove(arr.size()-1);
                }
                if(v2>esp){
                    arr.add(v1/v2);
                    flag=flag|canGet(arr);
                    arr.remove(arr.size()-1);
                }
                arr.add(j,v2);
                arr.add(i,v1);
                
            }
        }
        return flag;
    }
    public boolean judgePoint24(int[] cards) {
        
        List<Double> arr=new ArrayList<>();
        for(int a:cards){arr.add((double)a);}
        return canGet(arr);
    }
}