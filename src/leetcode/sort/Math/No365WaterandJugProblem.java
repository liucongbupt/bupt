package leetcode.sort.Math; /**
 * @author liucong
 * @ClassName: leetcode.Math.No365WaterandJugProblem
 * @Description:
 * @date 2016年11月16日 下午3:04
 **/

/**
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.

 If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.

 Operations allowed:

 Fill any of the jugs completely with water.
 Empty any of the jugs.
 Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 Example 1: (From the famous "Die Hard" example)

 Input: x = 3, y = 5, z = 4
 Output: True
 Example 2:

 Input: x = 2, y = 6, z = 5
 Output: False
 Credits:
 Special thanks to @vinod23 for adding this problem and creating all leetcode.Sort cases.

 Subscribe to see which companies asked this question

 Hide Tags leetcode.Math
裴属定理
 */
public class No365WaterandJugProblem {
    public No365WaterandJugProblem() {
    }
    public boolean canMeasureWater(int x, int y, int z) {
        return x+y==z ||(x+y>z) && z%gcd(x,y)==0 ;
    }
    private int gcd(int a ,int b){
        return b==0?a:gcd(b,a%b);
    }
    public static void main(String[] args) {

    }
}
