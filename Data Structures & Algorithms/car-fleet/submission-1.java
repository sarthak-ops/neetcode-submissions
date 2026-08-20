class Solution {
    class Car{
        double time;
        int pos;
        public Car(int pos, double time){
            this.time = time;
            this.pos = pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(speed.length == 0) return 0;
        int nofleet = 0;
        double maxt = 0.0;
        List<Car> x = new ArrayList<>();
        for(int i = 0; i < speed.length; i++){
            double time = (double)(target - position[i]) / speed[i];
            x.add(new Car(position[i], time));
        }
        x.sort(Comparator.comparingInt((Car c) -> c.pos).reversed());
        for (Car c : x) {
            if (c.time > maxt) {
                nofleet++;
                maxt = c.time;
            }
        }
        return nofleet;
    }
}
