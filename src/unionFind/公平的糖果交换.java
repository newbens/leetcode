package unionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 公平的糖果交换 {
    public static void main(String[] args){
        int[] a = {32,38,8,1,9};
        int[] b = {68,92};
        System.out.println(Arrays.toString(new 公平的糖果交换().fairCandySwap(a, b)));
    }
    public int[] fairCandySwap(int[] A, int[] B) {
        int aSum = 0,bSum = 0;
        int[] res = new int[2];
        Set<Integer> bSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            aSum += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            bSum += B[i];
            bSet.add(B[i]);
        }
        int diff = (aSum - bSum)/2;
        for (int i : A) {
            if (bSet.contains(i - diff)) {
                res[0] = i;
                res[1] = i - diff;
            }
        }
        return res;
    }
}
