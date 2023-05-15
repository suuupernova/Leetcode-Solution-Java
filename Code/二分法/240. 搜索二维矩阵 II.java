//二分法
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row:matrix){
            int index=search(row,target);
            if(index>=0){
                return true;
            }
        }
        return false;
        
    }
    private int search(int[] nums,int target){
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid=(h-l)/2+l;
            int num=nums[mid];
            if(num==target){
                return mid;
            }else if(num>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
//z字查找
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int m=matrix.length,n=matrix[0].length;
       int x=0,y=n-1;
       while(x<m&&y>=0){
           if(matrix[x][y]==target){
               return true;
           }
           else if(matrix[x][y]>target){
               --y;
           }else{
               ++x;
           }
       }
       return false;
    }
}
