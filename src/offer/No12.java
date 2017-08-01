package offer;

/**
 * @author liucong
 * @ClassName: No12
 * @Description: 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
 * @date 2017年03月30日 下午11:40
 **/
public class No12 {
    public static void print1ToMaxOfNDigits(int n){
        if(n<=0)
            throw  new IllegalArgumentException("bad input");

        char[] number = new char[n+1];
        for (int i = 0; i < number.length; i++) {
            number[i]='0';
        }
        while (!increment(number)){
            printNumber(number);
        }
    }

    private static boolean increment(char[] number){
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength-1; i >0 ; i--) {
            int nSum = number[i]-'0'+nTakeOver;
            if(i==nLength-1)
                nSum++;

            if(nSum>=10){
                nSum-=10;
                nTakeOver=1;
                number[i]= (char) ('0'+nSum);
                if (i==1)
                    isOverFlow = true;
            }else {
                number[i]=(char)('0'+nSum);
                break;
            }
        }
        return isOverFlow;
    }

    private static void printNumber(char[] number){
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; i++) {
            if(isBeginning0&&number[i]!='0')
                isBeginning0=false;
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void print1toMaxOfNDigits(int n){
        if(n<=0)
            throw new IllegalArgumentException("bad input");
        char[] number = new char[n+1];
        for (int i = 0; i < 10; i++) {
            number[0]=(char) (i+'0');
            print1ToMaxOfNDigitsRecursively(number,n+1,0);
        }


    }
    private static void print1ToMaxOfNDigitsRecursively(char[] number,int length,int index){
        if (index==length-1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index+1]=(char)(i+'0');
            print1ToMaxOfNDigitsRecursively(number,length,index+1);
        }
    }
    public static void main(String[] args) {
//        print1ToMaxOfNDigits(3);
        print1toMaxOfNDigits(2);
    }
}
