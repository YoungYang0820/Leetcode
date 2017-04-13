/**
 * Created by yangjiawei on 2017/4/13.
 */
public class M264UglyNumberII {
    public static int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int index2 = 1;
        int index3 = 1;
        int index5 = 1;
        int mult2 = 2;
        int mult3 = 3;
        int mult5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(mult2, Math.min(mult3, mult5));
            uglyNumber[i] = min;
            if (mult2 == min) mult2 = 2 * uglyNumber[index2++];
            if (mult3 == min) mult3 = 3 * uglyNumber[index3++];
            if (mult5 == min) mult5 = 5 * uglyNumber[index5++];
        }
        return uglyNumber[n - 1];
    }
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
