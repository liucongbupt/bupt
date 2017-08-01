package leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by liucong on 2017/5/10.
 */
public class No127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int path = 1;

        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        set.add(beginWord);
        queue.offer(beginWord);
        int size = queue.size();
        while (size!=0){
            path++;
            for (int i = 0; i < size; i++) {
                String v = queue.poll();
                Iterator<String> it = wordList.iterator();
                while(it.hasNext()){
                    String word = it.next();
                    if (!set.contains(word)&&isChanged(v,word)){
                        if (word.equals(endWord)){
                            return path;
                        }
                        set.add(word);
                        queue.add(word);
                        it.remove();
                    }
                }

            }
            size=queue.size();
        }
        return 0;
    }

    public boolean isChanged(String beginWord, String str) {
        int count = 0;
        int len = beginWord.length();
        for (int i = 0; i < len; i++) {
            if (beginWord.charAt(i)!=str.charAt(i))
                count++;
        }
        return count==1;
    }




    public static void main(String[] args) {
        No127WordLadder test = new No127WordLadder();
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> list=Arrays.asList(words);
        System.out.println(test.ladderLength("hit","cog",list));
    }

}
