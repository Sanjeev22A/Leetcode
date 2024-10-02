class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> map=new TreeSet<>();
        for(int a:arr){
            map.add(a);
        }
        int[] newArr=new int[map.size()];
        int i=0;
        HashMap<Integer,Integer> newMapper=new HashMap<>();
        for(int d:map){
            newMapper.put(d,i+1);
            i++;
        }
        for(int j=0;j<arr.length;j++){
            arr[j]=newMapper.get(arr[j]);
        }
        return arr;
    }
}