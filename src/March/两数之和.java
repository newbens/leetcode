package March;

import java.util.*;

public class 两数之和 {
    public static void main(String[] args){
        int[] a = {3,3};
        int target = 6;
        int[] twoNum = new 两数之和().getTwoNum(a, target);
        System.out.println(Arrays.toString(twoNum));
    }

    public int[] getTwoNum(int[] a, int target) {
        Arrays.sort(a);
        int[] res = new int[2];
        int le = 0, ri = a.length - 1;
        while (le < ri) {
            if (a[le] + a[ri] < target) {
                le++;
            } else if (a[le] + a[ri] > target) {
                ri--;
            }else {
                res[0] = a[le];
                res[1] = a[ri];
                break;
            }
        }
        return res;
    }
}
