//和240是一个题，但是测试用例里多了一个为空的情况
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        
        int m=matrix.length,n=m==0?0:matrix[0].length;
        
        int x=0,y=n-1;
        while(x<m&&y>=0){
            if(matrix[x][y]==target){
                return true;
            }else if(matrix[x][y]>target){
                y--;
            }else{
                x++;
            }
        }
        return false;

    }
}
