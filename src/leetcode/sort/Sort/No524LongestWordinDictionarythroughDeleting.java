package leetcode.sort.Sort;

/**
 * @author liucong
 * @ClassName: No524LongestWordinDictionarythroughDeleting
 * @Description:
 * @date 2017年03月15日 上午11:38
 **/

import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 */
public class No524LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String rtn = "";
        for (String word:d
             ) {
            int i=0 ,j=0;
            while(i<word.length()&&j<s.length()){
                if(word.charAt(i)==s.charAt(j)){
                    j++;
                    i++;
                }else{
                    j++;
                }
            }
            if(i==word.length()&&(word.length()>rtn.length()||word.compareTo(rtn)<0)){
                rtn=word;
            }

            if(i==word.length()){
                if(word.length()>rtn.length())
                    rtn=word;
                else if(word.length()==rtn.length()&&word.compareTo(rtn)<0)
                    rtn = word;
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println("ab".compareTo("ba"));
    }

}
