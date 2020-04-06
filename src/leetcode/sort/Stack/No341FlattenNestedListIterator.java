package leetcode.sort.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liucong
 * @ClassName: No341FlattenNestedListIterator
 * @Description:
 * @date 2017年04月12日 上午10:02
 **/
public class No341FlattenNestedListIterator {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        List<Integer> list = new ArrayList<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger ni:nestedList
                 ) {
                if (ni.isInteger()){
                    list.add(ni.getInteger());
                }else {
                    manageList(ni.getList(),list);
                }
            }
        }

        public void manageList(List<NestedInteger> ni,List<Integer> list){
            for (NestedInteger n:ni
                 ) {
                if (n.isInteger()){
                    list.add(n.getInteger());
                }else {
                    manageList(n.getList(),list);
                }
            }
        }

        @Override
        public void remove() {

        }

        @Override
        public Integer next() {
            return list.remove(0);
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}
