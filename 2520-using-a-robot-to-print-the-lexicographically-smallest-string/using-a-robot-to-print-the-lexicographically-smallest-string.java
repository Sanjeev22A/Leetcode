class Solution {
    public String robotWithString(String s) {
        int[] map=new int[26];
        char[] smallest=new char[s.length()];
        char temp='z'+1;
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            map[c-'a']++;
            temp=(char)Math.min(temp,c);
            smallest[i]=temp;
        }
        Stack<Character> B=new Stack<>();
        StringBuilder C=new StringBuilder();
        char min='z';
        for(int i=0;i<s.length();i++){
            char c=smallest[i];
            min=(char)Math.min(c,min);
            
            while(map[min-'a']==0 && min!='z'){
                min++;
            }
            if(!B.isEmpty() && B.peek()>s.charAt(i)){
                B.push(s.charAt(i));
                map[s.charAt(i)-'a']--;
                while(!B.isEmpty() && B.peek()<=min){
                    C.append(B.pop());
                }
            }else{
                while(!B.isEmpty() && B.peek()<=min){
                    C.append(B.pop());
                }
                B.push(s.charAt(i));
                map[s.charAt(i)-'a']--;
            }

            
            
            
        }
        while(!B.isEmpty()){
            C.append(B.pop());
        }
        return C.toString();
    }
}