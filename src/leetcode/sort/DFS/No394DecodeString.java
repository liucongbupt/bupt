package leetcode.sort.DFS;

/**
 * @author liucong
 * @ClassName: No394DecodeString
 * @Description:
 * @date 2017年03月26日 下午3:29
 **/
public class No394DecodeString {
    int i = 0;
    public String decodeString(String s) {
        return dfs(s,0);
    }

    private String dfs(String s,int count){
        String temp  = "";
        String num = "";
        if(count>0) i++;
        while (i<s.length()){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                num+=s.charAt(i);
            }else if(s.charAt(i)=='['){
                temp+=dfs(s,Integer.valueOf(num));
                num="";
            }else if(s.charAt(i)==']'){
                String rtn = "";
                for (int j = 0; j < count; j++) {
                    rtn+=temp;
                }
                return rtn;
            }else {
                temp+=s.charAt(i);
            }
            i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        No394DecodeString test = new No394DecodeString();
        System.out.println(test.decodeString("3[a]2[bc]"));
    }
}
