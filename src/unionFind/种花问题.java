package unionFind;

public class 种花问题 {
    public static void main(String[] args) {
        int[] a = {1,0,0,0,1};
        System.out.println(new 种花问题().canPlaceFlowers(a, 1));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int res = 0;
        if (flowerbed.length == 1 ){
            if(flowerbed[0]==0 && n == 1) return true;
            else return false;
        }
        else {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                res++;
            }
            if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
                flowerbed[flowerbed.length - 1] = 1;
                res++;
            }
            for (int i = 1; i < flowerbed.length - 1; i++) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    res++;
                }
            }
            return res >= n;
        }
    }
}
