package offer;

/**
 * @author liucong
 * @ClassName: No47
 * @Description:
 * @date 2017年04月04日 下午5:41
 **/
public class No47 {
    int add(int a,int b){
        int sum=0;
        int carry = 0;
        do{
            sum = a^b;
            carry = (a&b)<<1;

            a = sum;
            b = carry;
        }while (b!=0);
            return a;
    }
}
