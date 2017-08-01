package leetcode.sort.Array;

/**
 * @author liucong
 * @ClassName: No167TwoSumIIInputarrayissorted
 * @Description:
 * @date 2017年02月26日 下午8:50
 **/
public class No167TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;

        int[] rtn = new int[2];
        int i = 0;
        int j = numbers.length-1;
        while(i<j){
            int x = numbers[i]+numbers[j];
            if(x<target){
                i++;
            }else if(x>target){
                j--;
            }else if(x==target){
                rtn[0]=i+1;
                rtn[1]=j+1;
                return rtn;
            }
        }
        return rtn;
    }
}
