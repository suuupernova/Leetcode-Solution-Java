class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=search(nums,target);
        int r=search(nums,target+1);
        if(l==nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{l,r-1};
    }
    //寻找>=target的第一个
    private int search(int[] nums,int target){
        int l=0,r=nums.length;
        while(l<r){
            int mid=(r+l)>>1;
            if(nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
            
        }
        return l;
    }
}


//写了新的版本
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=search(nums,target);
        int r=search(nums,target+1);
        if(l==nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{l,r-1};
        

    }
    private int search(int[] nums,int target){
        int l=-1,r=nums.length;
        while(l+1!=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid;
            }else{
                r=mid;
            }
        }
        return r;
        
    }
}
