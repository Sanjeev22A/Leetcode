class Solution {
    public String largestNumber(int[] nums) {
        String[] arr=new String[nums.length];
        int i=0;
        for(int a:nums){
            arr[i++]=String.valueOf(a);
        }
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String a,String b){
                String order1=a+b;
                String order2=b+a;
                return order1.compareTo(order2);
            }
        });
        if(arr[arr.length-1].equals("0")){
            return "0";
        }
        String result="";
        for(i=arr.length-1;i>=0;i--){
            result+=arr[i];
        }

        return result;
    }
}