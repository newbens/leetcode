package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class 爱生气的书店老板 {
    public static void main(String[] args){
        int[] c = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] g = {1, 1, 1, 1, 1, 1, 1, 1};
        int x = 3;
        System.out.println(new 爱生气的书店老板().maxSatisfied(c, g, x));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0,angryNum = 0;
        List<int[]> angry = new ArrayList<>();
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {  //不生气
                res += customers[i];
            }else {
                int[] a = {customers[i], i};
                angry.add(a);
            }
        }
        int le = 0,ri = 0,temp =0;
        if(angry.size() == 0) return res;
        else {
            while (ri < angry.size()) {
                if (angry.get(ri)[1] - angry.get(le)[1] >= X) { //滑动
                    angryNum = Math.max(angryNum, temp);
                    temp -= angry.get(le)[0];
                    le++;
                }else {
                    temp += angry.get(ri)[0];
                    ri++;
                }
            }
        }
        angryNum = Math.max(angryNum, temp);
        return res + angryNum;
    }

}

