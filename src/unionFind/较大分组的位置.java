package unionFind;

import java.util.*;

public class 较大分组的位置 {
    public static void main(String[] args) {
        String s = "aba";
        List<List<Integer>> lists = new 较大分组的位置().largeGroupPositions(s);
        System.out.println(Arrays.deepToString(new List[]{lists}));
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        char start = chars[0];
        int num = 1;
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == start) {
                num++;
            }else {
                if (num >= 3) {
                    res.add(Arrays.asList(index,index+num-1));
                }
                start = chars[i];
                index = i;
                num = 1;
            }
        }
        if (num >= 3) {
            res.add(Arrays.asList(index,index+num-1));

        }
        return res;
    }
}

