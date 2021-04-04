package unionFind;

import java.util.*;

public class 交换字符串元素 {
    public static void main(String[] args){
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        List<Integer> c = new LinkedList<>();
        a.add(0);
        a.add(3);
        b.add(1);
        b.add(2);
        c.add(0);
        c.add(2);
        List<List<Integer>> pairs = new LinkedList<>();
        pairs.add(a);
        pairs.add(b);
        pairs.add(c);
        String s = "dcab";
        String s1 = new 交换字符串元素().smallestStringWithSwaps(s, pairs);
        System.out.println(s1);
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0) return s;
        int len = s.length();
        UnionFind u = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            u.union(index1, index2);
        }
        char[] chars = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = u.find(i);
            if (map.containsKey(root)) {
                map.get(root).offer(chars[i]);
            }else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(chars[i]);
                map.put(root, minHeap);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int i1 = u.find(i);
            PriorityQueue<Character> characters = map.get(i1);
            sb.append(characters.poll());
        }
        return sb.toString();
    }
}
