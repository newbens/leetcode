package unionFind;

import java.util.*;

public class 除法求值 {
    Map<String, HashMap<String, Double>> map;
    public static void main(String[] args) {
        List<List<String>> e = new ArrayList<>();
        e.add(Arrays.asList("a", "b"));
        e.add(Arrays.asList("b", "c"));
        double[] v = {2.0, 3.0};
        List<List<String>> q = new ArrayList<>();
        q.add(Arrays.asList("a", "c"));
        q.add(Arrays.asList("b", "a"));
        q.add(Arrays.asList("a", "e"));
        q.add(Arrays.asList("a", "a"));
        q.add(Arrays.asList("x", "x"));
        double[] doubles = new 除法求值().calcEquation(e, v, q);
        System.out.println(Arrays.toString(doubles));

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        int i = 0;
        for (List<String> s : equations) {
            map.computeIfAbsent(s.get(0), k -> new HashMap<>()).put(s.get(1), values[i]);
            map.computeIfAbsent(s.get(1), k -> new HashMap<>()).put(s.get(0), 1/values[i]);
            i++;
        }
        double[] res = new double[queries.size()];
        for (int j = 0; j < queries.size(); j++) {
            List<String> temp = queries.get(j);
            res[j] = dfs(temp.get(0), temp.get(1), 1, new HashMap());
        }
        return res;
    }

    public double dfs(String start,String end,double res,HashMap<String,String> visited) {
        if(!map.containsKey(start)) return -1;
        if(visited.containsKey(start)) return -1; //孤独节点
        if (start.equals(end)) {
            return res;
        }
        HashMap<String, Double> next = map.get(start);
        visited.put(start,"");
        for (String s : next.keySet()) {
            double finalRes = dfs(s,end,res*next.get(s),visited);
            if(finalRes != -1) return finalRes;
        }
        visited.remove(start);
        return -1;
    }
}
