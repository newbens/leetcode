package unionFind;

import java.util.*;

public class 账户合并 {
    public static void main(String[] args){

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();//保存邮箱和下标
        int n = accounts.size();
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                //遍历邮箱 如果出现相同邮箱，就说明是同一个人 合并就完事了
                if (map.containsKey(email)) {
                    Integer another = map.get(email);
                    u.union(another,i);  //出现的话 合并。
                }
                map.put(email, i);
            }
        }
        //以上阶段
        Map<Integer, Set<String>> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) { //合并邮箱
            int root = u.find(i);  //得到自己老大
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            if (map2.containsKey(root)) {
                map2.get(root).addAll(emails);
            }else {
                map2.put(root,new TreeSet<>(emails));
            }
        }
        for (Map.Entry<Integer, Set<String>> entry : map2.entrySet()) {
            List<String> temp = new LinkedList<>();
            Integer key = entry.getKey();
            String name = accounts.get(key).get(0);
            temp.add(name);
            temp.addAll(entry.getValue());
            res.add(temp);
        }
        return res;
    }
}
