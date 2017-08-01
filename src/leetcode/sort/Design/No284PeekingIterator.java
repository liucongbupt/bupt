package leetcode.sort.Design;

import java.util.Iterator;

/**
 * @author liucong
 * @ClassName: No284PeekingIterator
 * @Description:
 * @date 2017年04月12日 下午5:14
 **/
public class No284PeekingIterator {
    class PeekingIterator implements Iterator<Integer> {
        private Integer next = null;
        private Iterator<Integer> iter;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
            if (iter.hasNext())
                next = iter.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = next;
            next = iter.hasNext()?iter.next():null;
            return res;
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }
    }
}
