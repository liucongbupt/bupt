package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liucong on 2017/5/10.
 */
public class No535EncodeandDecodeTinyURL {
    public class Codec {
        List<String> urls = new ArrayList<String>();
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            urls.add(longUrl);
            return String.valueOf(urls.size()-1);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int idx = Integer.valueOf(shortUrl);
            return idx<urls.size()?urls.get(idx):"";
        }
    }
}
