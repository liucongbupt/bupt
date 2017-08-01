package offer;

/**
 * @author liucong
 * @ClassName: No4
 * @Description:
 * @date 2017年03月06日 下午9:07
 **/
public class No4{

    public int ReplaceBlank(char[] string ,int usedlength){
        if(string==null||string.length==0)
            return -1;

        int whitecount = 0;
        for (int i = 0; i < usedlength; i++) {
            if(string[i]==' '){
                whitecount++;
            }
        }


        int targetLength = whitecount*2+usedlength;
        int tmp = targetLength;
        if(targetLength>string.length)
            return -1;

        if(whitecount==0)
            return usedlength;

        usedlength--;
        targetLength--;

        while(usedlength>=0&&usedlength<targetLength){
            if(string[usedlength]==' '){
                string[targetLength--] ='0' ;
                string[targetLength--] ='2' ;
                string[targetLength--] ='%' ;
            }else{
                string[targetLength--]=string[usedlength];
            }
            usedlength--;
        }
        return tmp;
    }
}
