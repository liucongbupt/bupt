package offer;

/**
 * @author liucong
 * @ClassName: No38
 * @Description:
 * @date 2017年04月02日 下午11:04
 **/
public class No38 {
    int getFirstK(int[] data,int k,int start,int end){
        if (start>end)
            return -1;
        int midIndex = (start+end)/2;
        int minData = data[midIndex];
        if (minData==k){
            if( (midIndex>0&&data[midIndex-1]!=k)||(midIndex==0))
                return midIndex;
            else
                end = midIndex-1;
        }else if (midIndex>k){
            end = midIndex-1;
        }else {
            start = midIndex+1;
        }
        return getFirstK(data,k,start,end);
    }
    int getLastK(int[] data,int k,int start,int end){
        if (start>end)
            return -1;
        int midIndex = (start+end)/2;
        int midData = data[midIndex];
        if (midData==k){
            if ((midIndex<data.length-1&&data[midIndex+1]!=k)||(midIndex==data.length-1))
                return midIndex;
            else
                start=midIndex+1;
        }else if (midData>k){
            end = midIndex-1;
        }else {
            start = midIndex+1;
        }
        return getLastK(data,k,start,end);
    }

    int getNumOfK(int[] data,int k){
        int number = 0;
        if (data!=null&&data.length>0){
            int first = getFirstK(data,k,0,data.length-1);
            int last = getLastK(data,k,0,data.length-1);
            if (first>-1&&last>-1)
                number=last-first+1;
        }
        return number;
    }

    public static void main(String[] args) {
        No38 a = new No38();
        System.out.println(a.getNumOfK(new int[]{1,2,2,2,2,3},2));
    }
}
