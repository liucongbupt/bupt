package offer;

/**
 * @author liucong
 * @ClassName: No36
 * @Description:
 * @date 2017年04月02日 下午10:57
 **/
public class No36 {
    int reversePairs(int[] data){
        if (data==null||data.length<0){
            return 0;
        }

        int[] copy = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            copy[i]=data[i];
        }
        int count = inversePairsCore(data,copy,0,data.length-1);
        return count;
    }

    int inversePairsCore(int[] data,int[] copy,int start, int end){
        if (start==end)
        {
            copy[start]=data[start];
            return 0;
        }
        int mid = (end-start)/2;
        int left = inversePairsCore(data,copy,start,start+mid);
        int right = inversePairsCore(data,copy,start+mid+1,end);

        int i = start+mid;
        int j = end;

        int indexCopy = end;
        int count = 0;
        while (i>=start&&j>=start+mid+1){
            if(data[i]>data[j]){
                copy[indexCopy--]=data[i--];
                count += j - start - mid;
            }else{
                copy[indexCopy--]=data[j--];
            }
        }

        for (; i>=start ; --i) {
            copy[indexCopy--] = data[i];
        }
        for (; j>=start+mid+1 ; --j) {
            copy[indexCopy--] = data[j];
        }
        return left+right+count;

    }
}
