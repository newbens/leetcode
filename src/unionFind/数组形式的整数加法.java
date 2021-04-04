package unionFind;

import java.util.*;

public class 数组形式的整数加法 {
    public static void main(String[] args){
        int[] a = {9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        System.out.println(new 数组形式的整数加法().addToArrayForm(a, k));
    }
    //正向操作的话 会出现后面进位导致前面需要修改，所以逆向只需要将最后结果反转。
    public List<Integer> addToArrayForm(int[] a, int b) {
        List res = new ArrayList();
        for (int i = a.length-1; i >= 0 || b > 0; i--) {
            b += (i<0 ? 0 : a[i]);
            res.add(b % 10);
            b /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
