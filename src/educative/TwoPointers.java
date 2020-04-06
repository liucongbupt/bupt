package educative;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by liucong on 2020/3/31.
 */
public class TwoPointers {

    /**
     * Two sum
     * Time Complexity #
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * Space Complexity #
     * The algorithm runs in constant space O(1).
     */
    public static int[] twoSum(int[] arr, int targetSum) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[]{left, right}; // found the pair

            if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
        return new int[]{-1, -1};
    }

    /**
     * Time Complexity #
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * Space Complexity #
     * The space complexity will also be O(N), as, in the worst case, we will be pushing ‘N’ numbers in the HashTable.
     */
    public static int[] twoSumUsingMap(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i]))
                return new int[]{nums.get(targetSum - arr[i]), i};
            else
                nums.put(arr[i], i); // put the number and its index in the map
        }
        return new int[]{-1, -1}; // pair not found
    }


    /**
     * Remove Duplicates
     * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.
     */
    public static int removeDuplicates(int[] arr) {
        int count = -1;
        if (arr.length <= 0) return count;
        count = 1;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j] != arr[i]) {
                j = i;
                count++;
            }
        }
        return count;
    }

    /**
     * Time Complexity #
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * Space Complexity #
     * The algorithm runs in constant space O(1).
     *
     * @param arr
     * @return
     */

    public static int removeDuplicates1(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    /**
     * Similar Questions #
     * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
     */
    public static int removeKey(int[] arr, int key) {
        int nextElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[key] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        return nextElement;
    }

    public static int removeKey1(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }

    /**
     * Squaring a Sorted Array
     * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
     */
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int start = -1;
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[start] >= 0) break;
        }
        if (i < arr.length) {
            start = i;
        } else {
            start = arr.length - 1;
        }
        int left = start;
        int right = start + 1;
        int start1 = 0;
        while (left >= 0 && right <= arr.length - 1) {
            int leftVal = arr[left] * arr[left];
            int righttVal = arr[right] * arr[right];
            if (leftVal <= righttVal) {
                squares[start1] = leftVal;
                left--;
            } else {
                squares[start1] = righttVal;
                right++;
            }
            start1++;
        }
        while (left >= 0) {
            int leftVal = arr[left] * arr[left];
            squares[start1] = leftVal;
            left--;
            start1++;
        }
        while (right <= arr.length - 1) {
            int righttVal = arr[right] * arr[right];
            squares[start1] = righttVal;
            right++;
            start1++;
        }
        return squares;
    }

    /**
     * Time Complexity #
     * The time complexity of the above algorithm will be O(N), where ‘N’ is the total number of elements in the given array.
     * Space Complexity #
     * The algorithm runs in constant space O(N)
     */
    public static int[] makeSquaresD(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    /**
     * Triplet Sum to Zero (medium)
     * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
     */

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < arr.length; j++) {
                if (map.containsKey(sum - arr[j])) {

                    List<Integer> list = new LinkedList<>();
                    list.add(sum);
                    list.add(sum - arr[j]);
                    list.add(arr[j]);
                    if (!triplets.contains(list)){
                        triplets.add(list);
                    }
                } else {
                    map.put(arr[j], j);
                }
            }
        }
        return triplets;
    }

    /**
     * Sorting the array will take O(N * logN)O(N∗logN). The searchPair() function will take O(N)O(N). As we are calling searchPair() for every number in the input array, this means that overall searchTriplets() will take O(N * logN + N^2)O(N∗logN+N
     ​2
     ​​ ), which is asymptotically equivalent to O(N^2)O(N
     ​2
     ​​ ).

     Space complexity #
     Ignoring the space required for the output array, the space complexity of the above algorithm will be O(N)O(N) which is required for sorting.
     * @param arr
     * @return
     */
    public static List<List<Integer>> searchTripletsD(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets
            } else if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else right--; // we need a pair with a smaller sum
        }
    }

    /**
     * Triplet Sum Close to Target
     * Given an array of unsorted numbers and a target number,
     * find a triplet in the array whose sum is as close to the target number as possible,
     * return the sum of the triplet.
     * If there are more than one such triplet,
     * return the sum of the triplet with the smallest sum.
     */
//    public static int searchTriplet(int[] arr, int targetSum) {
//        Arrays.sort(arr);
//        int sum = Integer.MAX_VALUE;
//        int count = 1;
//        int diff = Integer.MAX_VALUE;
//        for (int i = 0; i < arr.length - 2; i++) {
//            int currentDiff = diff;
//            int[] rtn = searchPair(arr, arr[i], targetSum, currentDiff, i + 1);
//            if (rtn[2] <= diff) {
//                if (rtn[2] == diff) {
//                    if (rtn[0] * rtn[1] < count * sum) {
//                        count = rtn[0];
//                        sum = rtn[1];
//                        diff = rtn[2];
//                    }
//                } else {
//                    count = rtn[0];
//                    sum = rtn[1];
//                    diff = rtn[2];
//                }
//            }
//        }
//        if (sum == Integer.MAX_VALUE) return -1;
//        return count * sum;
//    }
//
//    public static int[] searchPair(int[] arr, int starter, int targetSum, int diff, int left) {
//        int right = arr.length - 1;
//        int sum = Integer.MAX_VALUE;
//        int count = 1;
//        while (left < right) {
//            int currentSum = arr[left] + arr[right] + starter;
//            int currentDiff = Math.abs(targetSum - currentSum);
//            if (currentDiff < diff) {
//                count = 1;
//                diff = currentDiff;
//                sum = currentSum;
//                left ++;
//            } else if (diff == currentDiff) {
//                count ++;
//                diff = currentDiff;
//                sum = currentSum;
//                left ++;
//            } else {
//                right--;
//            }
//        }
//        return new int[]{count, sum, diff};
//    }

    /**
     * \
     * Time complexity #
     Sorting the array will take O(N* logN)O(N∗logN). Overall searchTriplet() will take O(N * logN + N^2)O(N∗logN+N
     ​2
     ​​ ), which is asymptotically equivalent to O(N^2)O(N
     ​2
     ​​ ).

     Space complexity #
     The space complexity of the above algorithm will be O(N)O(N) which is required for sorting.
     * @param arr
     * @param targetSum
     * @return
     */
    public static int searchTripletD(int[] arr, int targetSum) {
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) //  we've found a triplet with an exact sum
                    return targetSum - targetDiff; // return sum of all the numbers

                // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff; // save the closest and the biggest difference

                if (targetDiff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
            }
        }
        return targetSum - smallestDifference;
    }

    /**
     * Triplets with Smaller Sum (medium)
     * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
     */
    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[left] + arr[right] + arr[i];
                if (sum < target) {
                    count+= right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static int searchTripletsD(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) { // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                count += right - left;
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return count;
    }


    /**
     * Subarrays with Product Less than a Target (medium)
     * We'll cover the following
     * Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
     */
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int windowStart = i;
            int windowSum = 0;
            for (int windowEnd = windowStart; windowEnd < arr.length; windowEnd++) {
                windowSum += arr[windowEnd];
                if (windowSum < target) {
                    List list = new LinkedList();
                    for (int j = windowStart; j <= windowEnd; j++) {
                        list.add(arr[j]);
                    }
                    subarrays.add(list);
                } else {
                    break;
                }
            }
        }
        return subarrays;
    }

    /**
     * Time complexity #
     The main for-loop managing the sliding window takes O(N)O(N) but creating subarrays can take up to O(N^2)O(N
     ​2
     ​​ ) in the worst case. Therefore overall, our algorithm will take O(N^3)O(N
     ​3
     ​​ ).

     Space complexity #
     Ignoring the space required for the output list, the algorithm runs in O(N)O(N) space which is used for the temp list.
     * @param arr
     * @param target
     * @return
     */

    public static List<List<Integer>> findSubarraysD(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from lef to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }


    /**
     * Dutch National Flag Problem (medium)
     * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
     * Time complexity #
     The time complexity of the above algorithm will be O(N)O(N) as we are iterating the input array only once.

     Space complexity #
     The algorithm runs in constant space O(1)O(1).
     */

    public static void sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < end;) {
            if (arr[i] == 0) {
                swap(arr, i, start);
                start++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 2) {
                swap(arr, end, i);
                end--;
            }
        }
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * Quadruple Sum to Target (medium)
     * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
     * @param args
     * Time complexity #
    Sorting the array will take O(N*logN)O(N∗logN). Overall searchQuadruplets() will take O(N * logN + N^3)O(N∗logN+N
    ​3
    ​​ ), which is asymptotically equivalent to O(N^3)O(N
    ​3
    ​​ ).

    Space complexity #
    The space complexity of the above algorithm will be O(N)O(N) which is required for sorting.
     */
    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                searchPair(arr, target - arr[i] - arr[j], arr[i], arr[j], j+1,quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPair(int[] arr, int targetSum, int one, int two, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == targetSum) {
                triplets.add(Arrays.asList(one, two, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) left++;
                while (left < right && arr[right] == arr[right + 1]) right--;
            } if (sum < targetSum) {
                left ++;
            } else {
                right --;
            }
        }
    }

    /**
     * Comparing Strings containing Backspaces (medium) #
       Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
     * @param args
     */

    public static boolean compare(String str1, String str2) {
        int str1end = str1.length() - 1;
        int str2end = str2.length() - 1;
        while (str1end >= 0 && str2end>=0) {
            int count = 0;
            while (str1.charAt(str1end) == '#') {
                str1end -= 1;
                count++;
            }
            str1end-=count;
            if (str1end < 0) break;
            count = 0;
            while (str2.charAt(str2end) == '#') {
                str2end -= 1;
                count++;
            }
            str2end-=count;
            if (str2end < 0) break;

            if (str1.charAt(str1end) == str2.charAt(str2end)) {
                str1end--;
                str2end--;
            } else {
                return false;
            }
        }
        if (str1end <= 0 && str2end <= 0) return true;
        return false;
    }

    /**
    * Time complexity #
     The time complexity of the above algorithm will be O(M+N)O(M+N) where ‘M’ and ‘N’ are the lengths of the two input strings respectively.

     Space complexity #
     The algorithm runs in constant space O(1)O(1).
     * */


    public static boolean compareD(String str1, String str2) {
        // use two pointer approach to compare the strings
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {

            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);

            if (i1 < 0 && i2 < 0) // reached the end of both the strings
                return true;

            if (i1 < 0 || i2 < 0) // reached the end of one of the strings
                return false;

            if (str1.charAt(i1) != str2.charAt(i2)) // check if the characters are equal
                return false;

            index1 = i1 - 1;
            index2 = i2 - 1;
        }

        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') // found a backspace character
                backspaceCount++;
            else if (backspaceCount > 0) // a non-backspace character
                backspaceCount--;
            else
                break;

            index--; // skip a backspace or a valid character
        }
        return index;
    }

    /**
     * Minimum Window Sort (medium) #
     Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
     * @param args
     */
    public static int sortS(int[] arr) {
        int[] original = arr.clone();
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        while (start < arr.length) {
            if (original[start] == arr[start]) {
                start ++;
            } else {
                break;
            }
        }
        while (end >= 0) {
            if (original[end] == arr[end]) {
                end--;
            } else {
                break;
            }
        }
        if (start < end) {
            return end - start + 1;
        } else {
            return arr.length;
        }
    }

    /**
     * Time complexity #
     The time complexity of the above algorithm will be O(N)O(N).

     Space complexity #
     The algorithm runs in constant space O(1)O(1).

     Mark as Completed
     ←    Back
     * @param arr
     * @return
     */
    public static int sortD(int[] arr) {
        int low = 0, high = arr.length - 1;
        // find the first number out of sorting order from the beginning
        while (low < arr.length - 1 && arr[low] <= arr[low + 1])
            low++;

        if (low == arr.length - 1) // if the array is sorted
            return 0;

        // find the first number out of sorting order from the end
        while (high > 0 && arr[high] >= arr[high - 1])
            high--;

        // find the maximum and minimum of the subarray
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k = low; k <= high; k++) {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low - 1] > subarrayMin)
            low--;
        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < arr.length - 1 && arr[high + 1] < subarrayMax)
            high++;

        return high - low + 1;
    }

    public static void main(String[] args) {

    }

}
