
class Spreadsheet {
    Map<String,Integer> map;
    int rows;
    boolean validCell(String cell){
        boolean alphabet=false,intt=false;
        for(char c:cell.toCharArray()){
            if(c>='A' && c<='Z'){
                alphabet=true;
            }
            if(c>='0' && c<='9'){
                intt=true;
            }

        }
        return alphabet&&intt;
    }
    public Spreadsheet(int rows) {
        map=new HashMap<>();
        this.rows=rows;
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        String[] arr=formula.split("\\+");
        String term2=arr[1];
        String term1=arr[0].substring(1);
        int v1=0;
        int v2=0;
        if(validCell(term1)){
            v1=map.getOrDefault(term1,0);

        }else{
            v1=Integer.parseInt(term1);
        }
        if(validCell(term2)){
            v2=map.getOrDefault(term2,0);
            
        }else{
            v2=Integer.parseInt(term2);
        }

        return v1+v2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */