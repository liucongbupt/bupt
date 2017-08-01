package offer;

/**
 * @author liucong
 * @ClassName: No24
 * @Description:
 * @date 2017年04月01日 下午3:02
 **/
public class No24 {
    public static boolean varifySequenceOfBST(int[] sequence){
        if (sequence==null||sequence.length==0)
            return false;
        return varify(sequence,0,sequence.length-1);
    }

    private static boolean varify(int[] sequence,int start,int end){
        if (start>=end)
            return true;

        int index = start;
        while (index<end-1&&sequence[index]<sequence[end]) index++;

        int right = index;
        while (right<end-1&&sequence[right]>sequence[end]) right++;

        if(right!=end-1)
            return false;


        return varify(sequence,start,index-1)&&varify(sequence,index,end-1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,7,6,9,10,10,8};
        int[] b = new int[]{7,4,6,5};
        System.out.println(varifySequenceOfBST(a));
        System.out.println(varifySequenceOfBST(b));
    }
}
