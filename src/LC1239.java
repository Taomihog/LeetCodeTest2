import java.util.*;
public class LC1239 {
    public int maxLength(List<String> arr) {
        // max = 26 so build a char array of 26
        // put chars to the array by ++;
        // put chars of the next arry by ++; if array has the element; stop.
        // do it iteratively.
        // return the sum of the array.

        //step 1. convert list of string to list of int
       int[] intArr = new int[arr.size()];
       int imax = 0;
       boolean repeated;
        for (String temp : arr) {
            System.out.println(temp);
            repeated = false;
            for (char ch : temp.toCharArray()) {
                if ((intArr[imax] & 1 << (ch - 'a')) == 0) {
                    intArr[imax] = intArr[imax] | 1 << (ch - 'a');
//                    System.out.println("~");
                }
                else {
                    repeated = true;
//                    System.out.println("*");
                    break;
                }
            }
            if (!repeated) imax++;
            else intArr[imax] = 0;
        }
        System.out.println(imax);
        intArr = Arrays.copyOfRange(intArr, 0, imax);
        for (int a : intArr) System.out.println(Integer.toBinaryString(a));

        //step 2. recursion

        System.out.println("Result:");
        //this didn't work, the hint is lying!
//        int imax = intArr.size();
//        Integer[] arr2 = new Integer[intArr.size()];
//        Integer[] res = new Integer[intArr.size()];
//        arr2 = intArr.toArray(arr2);
//        res = intArr.toArray(res);
//        for (int i = 0; i < imax - 1; i++) {
//            for (int j = i + 1; j < imax; j++) {
//                if ((res[i] & arr2[j]) == 0) res[i] = res[i] | arr2[j];
//            }
//        }
        ArrayList<Integer> res = new ArrayList();
        res.add(0);
        for (int i: intArr){//concurrent modification exception otherwise.
            for (int j =0; j < res.size(); j++) {
                if ((res.get(j) & i) == 0) res.add(res.get(j) | i);
            }
        }
        int maxchar = 0;
        for (int a : res) {
            int count = a,a0 = a;
            do{
                a0=a0>>1;
                count-=a0;
            }
            while(a0!=0);
            if(count >maxchar) maxchar = count;
            System.out.println(Integer.toBinaryString(a)+", "+count);
        }
        System.out.println(maxchar);

        //step 3. compare how many 1 bits and return the final result;


        return maxchar;
    }

//clumsy implementation of the recursion
//    private ArrayList<Integer> recur(ArrayList<Integer> arr){//return all possible int from combining a;
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        if (arr.size() == 1) return arr;
//        for (int i = 0; i < arr.size(); i ++){
//            int a0 = arr.get(0);
//            arr.remove(0);
//            for (int x: recur(arr)) if ((a0&x)==0) {
//
//                System.out.println(Integer.toBinaryString(a0|x));
//                res.add(a0|x);
//            }
//            arr.add(a0);
//        }
//        return res;
//    }
}
