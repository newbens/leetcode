package unionFind;

import java.util.ArrayList;
import java.util.List;

public class 可被5整除的二进制前缀 {
    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 1, 1};
        List<Boolean> booleans = new 可被5整除的二进制前缀().prefixesDivBy5(a);
        System.out.println(booleans);
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int init = 0;
        for (int i : A) {
            init = (init << 1) + i;
            init = init > 9 ? init-10 : init;
            res.add(init % 5 == 0);
        }
        return res;
    }

}
