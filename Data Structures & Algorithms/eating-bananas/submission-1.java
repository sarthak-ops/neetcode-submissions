class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        int l = 1;
        int r = max;
        while(l <= r){
            int mid = l + ((r-l)/2);
            if(possible(piles, mid, h)){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean possible(int[] piles, int speed, int h){
        int hours = 0;
        for(int i = 0; i < piles.length; i++){
            hours += Math.ceil((double)piles[i]/speed);
        }
        if(hours <= h){
            return true;
        }
        else{
            return false;
        }
    }
}
