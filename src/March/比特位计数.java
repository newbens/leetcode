package March;

import java.util.Arrays;

public class 比特位计数 {
    public static void main(String[] args) {
        int n = 5;
        int[] ints = new 比特位计数().countBits(n);
        System.out.println(Arrays.toString(ints));
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = res[i / 2];
            }
        }
        return res;
    }
}
