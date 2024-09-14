class Entry{
    String end;
    double cost;
    Entry(String end,double cost){
        this.end=end;
        this.cost=cost;
    }
}
class Solution {
    double dfs(double cost,String current,String end,HashMap<String,List<Entry>> graph,HashSet<String> visited){
        if(current.equals(end)){
            return cost;
        }
        if(!graph.containsKey(current)){
            return -1;
        }
        visited.add(current);
        List<Entry> nodes=graph.get(current);
        for(Entry node:nodes){
            double result=-1;
            if(!visited.contains(node.end)){
                result=dfs(cost*node.cost,node.end,end,graph,visited);
                if(result>=0){
                    return result;
                }
            }
        }
        return -1;
    }
    double calculate(List<String> query,HashMap<String,List<Entry>> graph){
        double cost=1;
        if(!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))){
            return -1;
        }
        else{
            cost=dfs(cost,query.get(0),query.get(1),graph,new HashSet<String>());
        }
        return cost;

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Entry>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> current = equations.get(i);
            
            
            if (graph.containsKey(current.get(0))) {
                List<Entry> e = graph.get(current.get(0));
                e.add(new Entry(current.get(1), values[i]));
            } else {
                List<Entry> e = new ArrayList<>();
                e.add(new Entry(current.get(1), values[i]));
                graph.put(current.get(0), e);
            }

            
            if (graph.containsKey(current.get(1))) {
                List<Entry> e = graph.get(current.get(1));
                e.add(new Entry(current.get(0), 1 / values[i]));
            } else {
                List<Entry> e = new ArrayList<>();
                e.add(new Entry(current.get(0), 1 / values[i]));
                graph.put(current.get(1), e);
            }
        }

        double[] results=new double[queries.size()];
        int i=0;
        for(List<String> query:queries){
            results[i++]=calculate(query,graph);
        }
        return results;

    }
}