class Point{
    char c;
    int firstChar,lastChar;
    Point(char c,int firstChar,int lastChar){
        this.c=c;
        this.firstChar=firstChar;
        this.lastChar=lastChar;
    }
    void setFirstChar(int i){
        firstChar=i;
    }
    void setLastChar(int i){
        lastChar=i;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Point> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(!map.containsKey(cur)){
                Point p=new Point(cur,i,i);
                map.put(cur,p);
            }else{
                Point p=map.get(cur);
                p.setLastChar(i);
                map.put(cur,p);
            }
        }
        List<Integer> partitionIndex=new ArrayList<>();
        partitionIndex.add(-1);
        int endIndex=-1;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            endIndex=Math.max(endIndex,map.get(c).lastChar);
            if(endIndex==i){
                partitionIndex.add(endIndex);
                endIndex=-1;
            }
            

        }
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<partitionIndex.size();i++){
            //System.out.println(partitionIndex.get(i));
            res.add(partitionIndex.get(i)-partitionIndex.get(i-1));
        }
        return res;
    }
}