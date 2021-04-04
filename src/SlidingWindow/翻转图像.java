package SlidingWindow;

import java.util.Arrays;

public class 翻转图像 {
    public static void main(String[] args){
        int[][] a = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] ints = new 翻转图像().flipAndInvertImage(a);
        System.out.println(Arrays.deepToString(ints));
    }
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        int len = A[0].length;
        for (int[] a : A) {
            int le = 0, ri = len - 1;
            while (le < ri) {
                if (a[le] == a[ri]) {
                    int num = (a[le] + 1) % 2;
                    a[le] = num;
                    a[ri] = num;
                }
                le++;
                ri--;
            }
            if(le == ri) a[le] = (a[le] + 1) % 2;
        }
        return A;
    }
}
