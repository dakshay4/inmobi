package org.dakshay.dsa;

import java.util.Stack;

public class Probelm1 {

    public static int[] balancedParanthesis(String[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int ind = 0;
        for (String s : arr) {
            int len = s.length();
            Stack<Character> st = new Stack<>();
            int balanced = 0;
            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);
                while (!st.isEmpty() && c == ')') {
                    st.pop();
                    balanced++;
                }
                if (c == '(') st.push(c);
            }
            res[ind++] = balanced;
        }
        return res;
    }

    public static int[] balancedParanthesisV2(String[] arr) {
        int n = arr.length;

        int[] res = new int[n];
        int ind = 0;
        for (String s : arr) {
            int balanced = 0;
            int len = s.length();
            int open = 0;
            for(int j=0;j < len; j++) {
                char c = s.charAt(j);
                if(c=='(') open++;
                else {
                    if(open>0) {
                        balanced++;
                        open--;
                    }
                }
            }
            res[ind++] = balanced;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"((()))","(()())","(())()","()(())","()()()", ")()(", "", "))))(((((", "())(", "(", "(()(()))"};
        int[] resV1 = balancedParanthesis(arr);
        int[] resV2 = balancedParanthesisV2(arr);
        System.out.println("V1 output :");
        for(int i : resV1) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("V2 output :");
        for(int i : resV2) {
            System.out.print(i + " ");
        }
    }
}


/*
    arr = ["((()))","(()())","(())()","()(())","()()()", ")()(", (()(()))]
    output = [3,3,3,3,3,1]
    Space Complexity - O(Max(arr[i].length) 1<=i<arr.length
    Time Complexity - O(n*(x+y+...)), x, y.. are string size

    2 open, 1 closing = 1 open
    3 open,



    Matrix m*n
    [
        ["A","B","C","E"],
        ["S","F","C","E"],
        ["A","D","E","E"]
    ]

    target = "ABCCED"
 */

