import java.util.HashMap;

/**
 * Created by yangjiawei on 2017/6/13.
 */
public class M535_TinyURL {
    HashMap<String, String> s2l = new HashMap<>();
    HashMap<String, String> l2s = new HashMap<>();
    String dict = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String encode(String longUrl) {
        StringBuilder sb;
        do {
            sb = new StringBuilder();
            sb.append("http://tinyurl.com/");
            for (int i = 0; i < 6; i++) {
                sb.append(dict.charAt((int) (Math.random() * dict.length())));
            }
        } while(l2s.containsKey(sb.toString()));
        l2s.put(longUrl, sb.toString());
        s2l.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return s2l.get(shortUrl);
    }
}
