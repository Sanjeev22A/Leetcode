class Point{
    char c;
    int count;
    Point(char c,int count){
        this.c=c;
        this.count=count;
    }
}
class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new TreeMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Point> lst=new ArrayList<>();
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            lst.add(new Point(e.getKey(),e.getValue()));
        }
        Collections.sort(lst,(a,b)->(b.count-a.count));
        StringBuilder ans=new StringBuilder();
        for(Point a:lst){
            for(int i=0;i<a.count;i++){
                ans.append(a.c);
            }
        }
        return ans.toString();

    }
}