/**
 * Created by liucong on 2017/5/8.
 */
public class Main {
    static class A{
        int a;
        int b;

        public A(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        A a = new A(1,2);
        A b = new A(3,4);
        swap(a);
        swap(a,b);
        System.out.println(a.a+" "+a.b);
        System.out.println(b.a+" "+b.b);
    }

    static void swap(A a){
        int tmp = a.a;
        a.a = a.b;
        a.b = tmp;
    }
    static void swap(A a,A b){
        A tmp = b;
        b = a;
        a = tmp;
    }
}
