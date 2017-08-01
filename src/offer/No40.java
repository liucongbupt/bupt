package offer;

/**
 * @author liucong
 * @ClassName: No40
 * @Description:
 * @date 2017年04月03日 下午2:58
 **/
public class No40 {
    static int findFirstBit(int num){
        int index = 0;
        while ((num&1)==0&&index<32){
            num>>=1;
            index++;
        }
        return index;
    }

    static boolean isBit1(int num,int index){
        num =num>>index;
        return (num&1)==1;
    }
    static int[] findNumsAppearOnce(int[] data){
        if (data==null||data.length<2){
            return null;
        }

        int rtnExclusiveOr = 0;
        for (int i = 0; i < data.length; i++) {
            rtnExclusiveOr^=data[i];
        }
        int indexOf1 = findFirstBit(rtnExclusiveOr);
        int num1=0,num2=0;
        for (int i = 0; i < data.length; i++) {
            if (isBit1(data[i],indexOf1)){
                num1^=data[i];
            }else {
                num2^=data[i];
            }
        }
        return new int[]{num1,num2};
    }

    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] result1 = findNumsAppearOnce(data1);
        System.out.println(result1[0] + " " + result1[1]);

        int[] data2 = {4, 6};
        int[] result2 = findNumsAppearOnce(data2);
        System.out.println(result2[0] + " " + result2[1]);

        int[] data3 = {4, 6, 1, 1, 1, 1};
        int[] result3 = findNumsAppearOnce(data3);
        System.out.println(result3[0] + " " + result3[1]);
    }
}
