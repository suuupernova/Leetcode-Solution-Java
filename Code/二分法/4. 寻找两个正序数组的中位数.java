class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        int mid=(len1+len2)/2;
        if((len1+len2)%2==1){
            double left=getK(nums1,nums2,0,0,mid+1);
            return left;
        }else{
            double left=getK(nums1,nums2,0,0,mid);
            double right=getK(nums1,nums2,0,0,mid+1);
            System.out.print(left);
            System.out.print(right);
            return (left+right)/2;
        }
    }
    private int getK(int[] nums1,int[] nums2,int i,int j,int k){
        int len1=nums1.length,len2=nums2.length;
        if(len1-i>len2-j)return getK(nums2,nums1,j,i,k);
        if(len1==i)return nums2[j+k-1];
        //if(len2==j)return nums1[i+k-1];
        if(k==1)return Math.min(nums1[i],nums2[j]);
        int idx1=Math.min(len1-1,i+k/2-1);
        int idx2=Math.min(len2-1,j+(k-k/2)-1);
        if(nums1[idx1]>nums2[idx2]){
            return getK(nums1,nums2,i,idx2+1,k-(idx2-j+1));
        }else{
            return getK(nums1,nums2,idx1+1,j,k-(idx1-i+1));
        }

    }
}
