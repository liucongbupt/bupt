package leetcode.sort.String;

/**
 * @author liucong
 * @ClassName: No520DetectCapital
 * @Description:
 * @date 2017年04月12日 下午8:05
 **/
public class No520DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        int i = 0;
        if (arr[i]>='a'&&arr[i]<='z'){
            i++;
            while (i<arr.length){
                if (arr[i]>='A'&&arr[i]<='Z')
                    return false;
                i++;
            }
        }else {
            i++;
            if (i<arr.length){
                if (arr[i]>='A'&&arr[i]<='Z'){
                    while (i<arr.length){
                        if (arr[i]>='a'&&arr[i]<='z') return false;
                        i++;
                    }
                }else {
                    while (i<arr.length){
                        if (arr[i]>='A'&&arr[i]<='Z') return false;
                        i++;
                    }
                }
            }
        }
        return true;
    }
}
