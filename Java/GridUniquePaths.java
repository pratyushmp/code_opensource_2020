public class Solution {
    int total = 0;
    public int uniquePaths(int A, int B) {
        
        if(A == 1 && B == 1 )
            total += 1;
        
        if(A == 1 && B != 1)
            uniquePaths(A, B-1);
        
        if(A != 1 && B == 1)
            uniquePaths(A-1, B);
            
        if(A != 1 && B != 1) {
            uniquePaths(A-1, B);
            uniquePaths(A, B-1);
        }
       return total;
        
    }
}

