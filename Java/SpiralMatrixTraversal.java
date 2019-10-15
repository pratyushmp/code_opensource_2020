public class Solution {
    public int[][] generateMatrix(int A) {
        int n = A*A;
        int[][] sol = new int[A][A];
        int t = 0, l = 0, r = A-1, b = A-1;
        int s = 1;
        while(t<=b && l<=r) {
            
            for(int j=l; j<=r;j++)
                sol[t][j] = s++;
            t++;
            
            for(int j=t; j<=b; j++) {
                sol[j][r] = s++;
            }
             r--;
            
            if(t<=b) {
                for(int j=r; j >= l; j--) {
                    sol[b][j] = s++;
                }
                b--;
            }
            
            if(l<=r) {
                for(int j=b; j >= t; j--){
                    sol[j][l] = s++;
                }
                l++;
            }
            
            
        }
        return sol;
    }
}

