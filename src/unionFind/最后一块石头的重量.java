package unionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 最后一块石头的重量 {
    public static void main(String[] args){
        int[] a = {316,157,73,106,771,828,46,212,926,604,600,992,71,51,477,869,425,405,859,924,45,187,283,590,303,66,508,982,464,398};
        System.out.println(new 最后一块石头的重量().lastStoneWeight(a));

    }
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }
        return backTrace(list);
    }

    public int backTrace(List<Integer> list) {
        if(list.size() == 0) return 0;
        if(list.size() == 1) return list.get(0);
        Collections.sort(list);
        int n = list.size();
        int num = list.get(n - 1) - list.get(n - 2);
        list.remove(n - 1);
        list.set(n - 2, num);
        return backTrace(list);
    }
}
