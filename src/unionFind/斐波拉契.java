package unionFind;

public class 斐波拉契 {
    public static void main(String[] args){
        int n = 4;
        System.out.println(new 斐波拉契().fib2(n));
    }
    public int fib(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        return fib(n - 1) + fib(n - 2);
    }
    //非递归
    public int fib2(int n) {
        if(n < 2) return n;
        int a = 0,b = 0,c = 1;
        for (int i = 2; i <= n ; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
