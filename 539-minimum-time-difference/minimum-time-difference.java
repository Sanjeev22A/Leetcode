class Solution {
    int getTime(String time){
        int hours=Integer.parseInt(time.substring(0,2));
        int min=Integer.parseInt(time.substring(3,5));
        return hours*60+min;
    }
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes=new ArrayList<>();
        for(String time:timePoints){
            minutes.add(getTime(time));
        }
        Collections.sort(minutes);
        System.out.println(minutes);
        int minDifference=Integer.MAX_VALUE;
        for(int i=1;i<minutes.size();i++){
            minDifference=Math.min(minDifference,Math.abs(minutes.get(i-1)-minutes.get(i)));
        }
        int last=(24*60)-minutes.get(minutes.size()-1)+minutes.get(0);
        System.out.println(last);
        return Math.min(last,minDifference);
    }
}