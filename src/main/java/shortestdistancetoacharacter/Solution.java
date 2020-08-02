package shortestdistancetoacharacter;

class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] a1 = S.toCharArray();
        int previousTargetIdx = -1;
        int[] res = new int[a1.length];

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == C) {
                previousTargetIdx = i;
            }
            int j;
            boolean finded = false;
            for (j = i + 1; j < a1.length; j++) {
                if (a1[j] == C) {
                    finded = true;
                    break;
                }
            }
            if (previousTargetIdx > -1 && finded) {
                res[i] = Math.min(i - previousTargetIdx, j - i);
            } else if (finded) {
                res[i] = j - i;
            } else if (previousTargetIdx > -1) {
                res[i] = i - previousTargetIdx;
            }
        }
        
        return res;
    }
}
