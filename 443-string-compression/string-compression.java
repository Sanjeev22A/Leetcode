class Point{
    char c;
    int count;
    Point(char c,int count){
        this.c=c;
        this.count=count;
    }
}
class Solution {
    public int compress(char[] chars) {
        List<Point> p=new ArrayList<>();
        char prev='.';
        int count=0;
        int length=0;
        for(char c:chars){
            if(c!=prev){
                if(count>0){
                    if(count>1){
                        length+=2;
                    }else{
                        length+=1;
                    }
                    p.add(new Point(prev,count));
                }
                prev=c;
                count=1;
            }else{
                count++;
            }
        }
        if(count>0){
            if(count>1){
                length+=2;
            }else{
                length+=1;
            }
            p.add(new Point(prev,count));

        }
       
        String ans="";
        for(Point a:p){
            ans+=a.c;
            if(a.count>1){
                ans+=a.count;
            }
        }
        //System.out.println(ans);
        for(int i=0;i<ans.length();i++){
            chars[i]=ans.charAt(i);
        }
        return ans.length();
    }
}