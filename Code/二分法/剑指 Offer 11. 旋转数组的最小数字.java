class Solution {
    public int minArray(int[] numbers) {
        
        int l=0,r=numbers.length-1;
        
        int min=-6000;
        while(l<r){
            int mid=l+(r-l)/2;
            if(numbers[mid]<numbers[r]){
                r=mid;
            }else if(numbers[mid]>numbers[r]){
                l=mid+1;
            }else{
                r-=1;
            }
        }
        return numbers[l];
    }
}
