class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            
            if (i > 1) {
                for (int j = 1; j < i; j++) {
                    cur.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            
            if (i > 0) {
                cur.add(1);
            }
            
            result.add(cur);
        }
        
        return result;
    }
}
