class Solution {
    
    int getIndex(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        else return 26 + (c - 'A');
    }

    boolean checkEqual(int[] map1, int[] map2) {
        for (int i = 0; i < 52; i++) {
            if (map1[i] < map2[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int[] map2 = new int[52];
        int[] map1 = new int[52];
        for (char c : t.toCharArray()) {
            map2[getIndex(c)]++;
        }

        int start = 0, end = 0;
        int ans = Integer.MAX_VALUE;
        String temp = "";
        boolean startUpdate=false;
        while (start<=end && end < s.length()) {
            char c = s.charAt(end);
            if(!startUpdate){
                map1[getIndex(c)]++;
            }
            

            if (checkEqual(map1, map2)) {
                if (end - start + 1 < ans) {
                    ans = end - start + 1;
                    temp = s.substring(start, end + 1);
                    

                }
                map1[getIndex(s.charAt(start))]--;
                start++;
                startUpdate=true;
            } else {
                end++;
                startUpdate=false;
            }
            System.out.println(start+":"+end);
        }

        while (start<=end && checkEqual(map1, map2)) {
            if (end - start + 1 < ans) {
                temp = s.substring(start, end + 1);
            }
            System.out.println(s.substring(start,end+1));
            map1[getIndex(s.charAt(start))]--;
            start++;
        }

        return temp;
    }
}
