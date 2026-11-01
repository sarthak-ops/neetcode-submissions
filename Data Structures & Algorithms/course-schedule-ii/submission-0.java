class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visit;
    boolean[] path;
    List<Integer> order = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.visit = new boolean[numCourses];
        this.path = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int[] cur = prerequisites[i];
            graph.get(cur[1]).add(cur[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(visit[i]==false){
                if(dfs(i)) return new int[0];
            }
        }
        Collections.reverse(order);
        return order.stream().mapToInt(Integer::intValue).toArray();
    }
    public boolean dfs(int course){
        if(path[course])return true;
        if(visit[course])return false;
        path[course]=true;
        visit[course]=true;
        for(int c : graph.get(course)){
            if(dfs(c)) return true;
        }
        path[course]=false;
        order.add(course);
        return false;
    }
}
