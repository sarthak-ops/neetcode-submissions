class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(max, piles[i]);
        }
        while(min <= max){
            int mid = (min + max) / 2;
            if(possible(mid, h, piles)){
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean possible(int mid, int h, int[] piles){
        int total = 0;
        for(int i = 0; i < piles.length; i++){
            total += (int) Math.ceil((double)piles[i] / mid);
        }
        return total <= h;
    }

}
