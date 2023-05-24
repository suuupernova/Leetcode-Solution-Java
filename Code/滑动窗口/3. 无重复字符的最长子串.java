//直接用以前的JavaScript思路改写的，并没有很好地用到java的hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int max=0;
        int pos=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                while(map.containsKey(s.charAt(i))){
                    map.remove(s.charAt(pos++));                
                }
                map.put(s.charAt(i),i);
            }else{
                map.put(s.charAt(i),i);
                max=Math.max(map.size(),max);
            }
            
        }
        return max;
    }
}

//另一个版本
//hash表存的是字母和它最新的下标
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(i-left+1,max);
        }
        return max;

    }
}
