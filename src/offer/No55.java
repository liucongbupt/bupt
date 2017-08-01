package offer;

/**
 * @author liucong
 * @ClassName: No55
 * @Description:
 * @date 2017年04月05日 上午10:15
 **/
public class No55 {
    public static class CharStatistics{
        private int index = 0;
        private int[] occurence = new int[256];

        public CharStatistics() {
            for (int i = 0; i < occurence.length; i++) {
                occurence[i]=-1;
            }
        }

        private void insert(char ch){
            if (ch>255){
                throw new IllegalArgumentException(ch+"must be a ascII char");
            }
            if (occurence[ch]==-1)
                occurence[ch]=index;
            else 
                occurence[ch]=-2;
        }
        private char firstAppearingOnce(String str){
            if (str==null)
                throw new IllegalArgumentException(str);
            for (int i = 0; i < str.length(); i++) {
                insert(str.charAt(i));
            }
            int min = Integer.MAX_VALUE;
            char ch = '\0';
            for (int i = 0; i < occurence.length; i++) {
                if (occurence[i]>=0&&occurence[i]<=Integer.MAX_VALUE){
                    min = Math.min(min,occurence[i]);
                    ch= str.charAt(min);

                }
            }
            return ch;
        }
    }
    public static void main(String[] args) {
        System.out.println(new CharStatistics().firstAppearingOnce("")); // '\0'
        System.out.println(new CharStatistics().firstAppearingOnce("g")); // 'g'
        System.out.println(new CharStatistics().firstAppearingOnce("go")); // 'g'
        System.out.println(new CharStatistics().firstAppearingOnce("goo")); // 'g'
        System.out.println(new CharStatistics().firstAppearingOnce("goog")); // '\0'
        System.out.println(new CharStatistics().firstAppearingOnce("googl")); // l
        System.out.println(new CharStatistics().firstAppearingOnce("google")); // l
    }
}
