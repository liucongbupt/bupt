package offer;

/**
 * @author liucong
 * @ClassName: No10
 * @Description: 请实现一个函数， 输入一个整数，输出该数二进制表示中1的个数。
 * @date 2017年03月30日 上午9:37
 **/
public class No10 {
    public static int numberOfOne(int n){
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count+=(n&1);
            n>>=1;//>>>=也可以
        }
        return count;
    }

    public static int numberOfOne1(int n){
        int count = 0;
        int flag = 1;
        for (int i = 0; i < 32; i++) {
            if((n&flag)!=0)
                count++;
            flag<<=1;
        }
        return count;
    }
    public static int numberOfOne2(int n){
        int count = 0;
        while (n != 0) {
            count++;
            n=(n-1)&n;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfOne2(9));
        System.out.println(numberOfOne2(2));
        System.out.println(numberOfOne2(8));
        System.out.println(numberOfOne2(7));
//        System.out.println(numberOfOne(Integer.MAX_VALUE));
//        System.out.println(numberOfOne(Integer.MIN_VALUE));

    }
}
