package org.dakshay.dsa;

public class Problem2 {

    public static boolean targetPresence(char[][] nums, String target) {
        int m = nums.length;
        int n = nums[0].length;
        boolean res = false;
        for(int i =0 ; i<m; i++) {
            for(int j=0; j<n; j++) {
                 res|=backtrack(nums, i, j, target, 0);
            }
        }
        return res;
    }

    static int[] x = new int[]{-1, 0, 1, 0};
    static int[] y = new int[]{0, 1, 0, -1};

    public static boolean backtrack(char[][] nums,
                                    int i, int j,
                                    String target, int targetCharacter) { // node
        char c = nums[i][j];
        if(targetCharacter == target.length()) return true;
        if(targetCharacter>target.length()) return false;

        boolean res = false;
        if(c == target.charAt(targetCharacter)) {
            for(int d=0;d<4;d++) {
                int t1 = i+x[d];
                int t2 = j+y[d];
                if(inBoundaries(t1,t2, nums) && (i!=t1 && j!=t2)) {
                     res|=backtrack(nums, t1, t2, target, targetCharacter+1);
                }
            }
        }
        return res;
    }

    private static boolean inBoundaries(int p, int q, char[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        boolean in= p >= 0 && q >= 0 && p < m && q < n;
//        System.out.println(p + ":" + q + " in " + in);
        return in;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','E'},
                {'A','D','E','E'}
        };
        boolean res = targetPresence(nums, "ABCCEDZ");
        System.out.println("Result is : " + res );
    }
}


/*
    Matrix m*n
    [
        ["A","B","C","E"],
        ["S","F","C","E"],
        ["A","D","E","E"]
    ]

    target = "ABCCED"

 */