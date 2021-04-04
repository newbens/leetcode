package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class K个不同整数的子数组 {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2,3};
        int k = 2;
        System.out.println(new K个不同整数的子数组().subarraysWithKDistinct(a,k));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int len = A.length;
        if(len < K)return 0;
        int min = 0,max = 0;
        Windows w1 = new Windows();  //最长子串窗口
        Windows w2 = new Windows();  //最短子串窗口
        int res = 0;
        for (int i = 0; i < len; i++) {
            w1.add(A[i]);
            w2.add(A[i]);
            while (w1.cnt >= K) {
                w1.remove(A[max++]);
            }
            while (w2.cnt > K) {
                w2.remove(A[min++]);
            }
            res += (max - min);
        }
        return res;
    }
}
class Windows{
    public Map<Integer,Integer> map;
    public Integer cnt = 0;
    public Windows() {
        this.map = new HashMap<>();
    }

    public void add(Integer i) {
        map.put(i, map.getOrDefault(i, 0) + 1);
        if(map.get(i) == 1) cnt++;
    }
    public void remove(Integer i) {
        map.put(i, map.get(i) - 1);
        if(map.get(i) == 0) cnt--;
    }

}
