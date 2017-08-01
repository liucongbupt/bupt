package leetcode.sort.Math;

/**
 * @author liucong
 * @ClassName: No65ValidNumber
 * @Description:
 * @date 2016年10月17日 5:26 PM
 **/

/**
 * Validate if a given string is numeric.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags leetcode.Math leetcode.String
 * Hide Similar Problems (E) leetcode.String to Integer (atoi)
 */
public class No65ValidNumber {
    public static int INVALID = 0;
    public static int SPACE = 1;
    public static int SIGN = 2;
    public static int DOT = 4;
    public static int DIGIT = 3;
    public static int EXPONENT = 5;

    public No65ValidNumber() {
    }

    public boolean isNumber(String s) {

        int transitionTable[][] = {
                {-1, 0, 3, 1, 2, -1},     // next states for state 0
                {-1, 8, -1, 1, 4, 5},    // next states for state 1
                {-1, -1, -1, 4, -1, -1},    // next states for state 2
                {-1, -1, -1, 1, 2, -1},    // next states for state 3
                {-1, 8, -1, 4, -1, 5},    // next states for state 4
                {-1, -1, 6, 7, -1, -1},    // next states for state 5
                {-1, -1, -1, 7, -1, -1},    // next states for state 6
                {-1, 8, -1, 7, -1, -1},    // next states for state 7
                {-1, 8, -1, -1, -1, -1}     // next states for state 8

        };
        int state = 0;
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i != charArray.length) {
            int inputState = INVALID;
            if (charArray[i] == ' ')
                inputState = SPACE;
            else if (charArray[i] == '+' || charArray[i] == '-')
                inputState = SIGN;
            else if (charArray[i] == '.')
                inputState = DOT;
            else if (charArray[i] == 'e' || charArray[i] == 'E')
                inputState = EXPONENT;
            else if (charArray[i] >= '0' && charArray[i] <= '9')
                inputState = DIGIT;
            state = transitionTable[state][inputState];
            if (state == -1)
                return false;
            else
                ++i;
        }
        return state == 1 || state == 4 || state == 7 || state == 8;
    }

    public static void main(String[] args) {
        No65ValidNumber vn = new No65ValidNumber();
        boolean rtn = vn.isNumber("3");
    }
}
