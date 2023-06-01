class Solution {
    public int search(int[] nums, int target) {
        int left=s(nums,target);
        int right=s(nums,target+1);
       
        if(left==nums.length||nums[left]!=target){
            return 0;
        }else{
            
            return right-left;
        }

    }
    public int s(int[] nums,int target){
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
