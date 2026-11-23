class Solution {
    public char posInfinite(String s, int pos) {
        // code here
        long n = s.length();
        long step = 0;
        long target = pos;
        
        while(n < target){
            step++;
            n = 2 * n + step;
        }
        
        
        while(target > s.length()){
            long prevLen = (n-step)/2;
            
            if (target > prevLen && target <= prevLen + step) {
               return '$';
            }

            if (target > prevLen + step) {
                target = n - target + 1;
            }

            n = prevLen;
            step--;
        }
        
        return s.charAt((int) target - 1);
    }
}