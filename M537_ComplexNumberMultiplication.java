import java.util.stream.Stream;

/**
 * Created by yangjiawei on 2017/6/28.
 */
public class M537_ComplexNumberMultiplication {
    public static String complexNumberMultiply(String a, String b) {
        int[] aNum = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        int[] bNum = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        return (aNum[0] * bNum[0] - aNum[1] * bNum[1]) + "+" + (aNum[0] * bNum[1] + aNum[1] * bNum[0]) + "i";
    }
    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+2i", "2+-1i"));
    }
}
