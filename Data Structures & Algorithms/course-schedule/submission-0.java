class Solution {
    HashMap<Integer, List<Integer>> ans;
    HashSet<Integer> visit;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new HashSet<>();
        ans = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            ans.put(i, new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            ans.get(course).add(prereq);
        }
        for(int course : ans.keySet()){
            if(dfs(course) == false) return false;
        }
        return true;
    }
    public boolean dfs(int course){
        if(visit.contains(course)){
            return false;
        }
        if(ans.get(course).size() == 0){
            return true;
        }
        visit.add(course);
        for(int pre : ans.get(course)){
            if(dfs(pre) == false) return false;
        }
        visit.remove(course);
        ans.get(course).clear();
        return true;
    }
}
