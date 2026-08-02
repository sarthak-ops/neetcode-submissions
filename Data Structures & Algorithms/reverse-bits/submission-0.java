class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        int count = 0;
        while(count < 32){
            int bit = n & 1;
            n = n >>> 1;
            ans = ans << 1;
            ans |= bit;
            count++;
        }
        return ans;
    }
}
