/**
 * Created by yangjiawei on 2017/4/11.
 */
public class E67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int maxLen = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLen; i++) {
            int aDig = 0;
            int bDig = 0;
            if (i < a.length()) aDig = a.charAt(a.length() - 1 - i) - '0';
            if (i < b.length()) bDig = b.charAt(b.length() - 1 - i) - '0';
            sb.append((aDig + bDig + carry) & 1);
            carry = (aDig + bDig + carry) >> 1;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
