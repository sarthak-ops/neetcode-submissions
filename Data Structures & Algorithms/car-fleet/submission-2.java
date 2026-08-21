class Solution {
    class Car{
        int pos;
        double time;
        public Car(int pos, double time){
            this.pos = pos;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int fleet = 0;
        List<Car> x = new ArrayList<>();
        double maxt = 0;
        for(int i = 0; i < speed.length; i++){
            double time = (double)(target - position[i])/speed[i];
            x.add(new Car(position[i], time));
        }
        x.sort(Comparator.comparingInt((Car c) -> c.pos).reversed());
        for(Car c : x){
            if(c.time > maxt){
                fleet++;
                maxt = c.time;
            }
        }
        return fleet;
    }
}
