package offer;

/**
 * @author liucong
 * @ClassName: No51
 * @Description:
 * @date 2017年04月04日 下午8:04
 **/
public class No51 {
    static  int duplicate(int[] num){
        if (num==null||num.length<1){
            return -1;
        }

        for (int i : num) {
            if (i < 0 || i >= num.length) {
                return -1;
            }
        }
        int i = 0;
        while (i<num.length){
            if (num[i]!=i){
                if (num[num[i]]==num[i]){
                    return num[i];
                }else {
                    swap(num,i,num[i]);
                }
            }else {
                i++;
            }
        }
        return -1;
    }

    static void swap(int[] num,int i,int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 1, 4};
        System.out.println(duplicate(numbers1));

        int[] numbers2 = {2, 4, 3, 1, 4};
        System.out.println(duplicate(numbers2));

        int[] numbers3 = {2, 4, 2, 1, 4};
        System.out.println(duplicate(numbers3));

        int[] numbers4 = {2, 1, 3, 0, 4};
        System.out.println(duplicate(numbers4));

        int[] numbers5 = {2, 1, 3, 5, 4};
        System.out.println(duplicate(numbers5));
    }

}
