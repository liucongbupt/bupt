package offer;

/**
 * @author liucong
 * @ClassName: No46
 * @Description:
 * @date 2017年04月04日 下午5:33
 **/
public class No46 {

    static class Temp{
        static int N = 0;
        static int sum = 0;
        public Temp() {
            N++;
            sum+=N;
        }

        public static int getSum() {
            return sum;
        }
        public static void Reset() {
            N=0;
            sum=0;
        }
    }
    public static int solution(int n){
        Temp[] test = new Temp[n];
        for (int i = 0; i < n; i++) {
            test[i] = new Temp();
        }
        return Temp.getSum();
    }
    public static void main(String[] args) {
//        System.out.println(solution(3));
        System.out.println(solution(4));
//        System.out.println(solution(5));
    }


}
